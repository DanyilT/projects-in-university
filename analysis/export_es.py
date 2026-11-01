#!/usr/bin/env python3
"""Export T-Pot events from Elasticsearch to gzipped JSON lines, one file per UTC day.

Run it on the T-Pot VM with the Python 3 standard library only. T-Pot publishes
Elasticsearch on 127.0.0.1:64298 (docker-compose.yml). The script only reads: it
opens a point in time, pages through one day at a time with search_after, and
closes the point in time again.

Example:
    python3 export_es.py --start 2026-10-01 --end 2026-10-29 --out ~/tpot-export

If Elasticsearch asks for a login, set ES_USER and ES_PASSWORD in the shell first.
"""
import argparse
import base64
import datetime as dt
import gzip
import json
import os
import urllib.error
import urllib.parse
import urllib.request

TIME_FORMAT = "%Y-%m-%dT%H:%M:%SZ"


class Elastic:
    def __init__(self, url):
        self.url = url.rstrip("/")
        self.headers = {"Content-Type": "application/json"}
        user = os.environ.get("ES_USER")
        password = os.environ.get("ES_PASSWORD")
        if user and password:
            token = base64.b64encode(f"{user}:{password}".encode()).decode()
            self.headers["Authorization"] = f"Basic {token}"

    def call(self, method, path, body=None):
        data = None if body is None else json.dumps(body).encode()
        request = urllib.request.Request(self.url + path, data=data, method=method, headers=self.headers)
        try:
            with urllib.request.urlopen(request, timeout=120) as reply:
                return json.load(reply)
        except urllib.error.HTTPError as err:
            detail = err.read().decode(errors="replace")[:300]
            raise SystemExit(f"{method} {path} failed with HTTP {err.code}: {detail}")
        except urllib.error.URLError as err:
            raise SystemExit(f"cannot reach {self.url}: {err.reason}")


def export_day(es, index, day, page, out_dir):
    start = dt.datetime.combine(day, dt.time(), tzinfo=dt.timezone.utc)
    end = start + dt.timedelta(days=1)
    query = {"range": {"@timestamp": {"gte": start.strftime(TIME_FORMAT), "lt": end.strftime(TIME_FORMAT)}}}
    expected = es.call("POST", f"/{index}/_count", {"query": query})["count"]
    pit_id = es.call("POST", f"/{index}/_pit?keep_alive=2m")["id"]
    path = os.path.join(out_dir, f"{day.isoformat()}.ndjson.gz")
    written = 0
    search_after = None
    try:
        with gzip.open(path, "wt", encoding="utf-8") as out:
            while True:
                body = {
                    "size": page,
                    "query": query,
                    "sort": [{"@timestamp": "asc"}, {"_shard_doc": "asc"}],
                    "pit": {"id": pit_id, "keep_alive": "2m"},
                    "track_total_hits": False,
                }
                if search_after:
                    body["search_after"] = search_after
                reply = es.call("POST", "/_search", body)
                hits = reply["hits"]["hits"]
                if not hits:
                    break
                for hit in hits:
                    record = {"_index": hit["_index"], "_id": hit["_id"], "_source": hit["_source"]}
                    out.write(json.dumps(record, separators=(",", ":")) + "\n")
                written += len(hits)
                search_after = hits[-1]["sort"]
                pit_id = reply.get("pit_id", pit_id)
    finally:
        es.call("DELETE", "/_pit", {"id": pit_id})
    return expected, written, path


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("--start", required=True, help="first UTC day to export, YYYY-MM-DD (inclusive)")
    parser.add_argument("--end", required=True, help="UTC day after the last day to export, YYYY-MM-DD (exclusive)")
    parser.add_argument("--out", required=True, help="folder for the daily files and manifest.json")
    parser.add_argument("--url", default="http://127.0.0.1:64298", help="Elasticsearch URL on the VM")
    parser.add_argument("--index", default="logstash-*", help="index pattern to export; list them with _cat/indices")
    parser.add_argument("--page", type=int, default=5000, help="documents per request, at most 10000")
    args = parser.parse_args()

    first = dt.date.fromisoformat(args.start)
    last = dt.date.fromisoformat(args.end)
    os.makedirs(args.out, exist_ok=True)
    es = Elastic(args.url)
    index = urllib.parse.quote(args.index, safe="*,-_.")
    days = []
    day = first
    while day < last:
        expected, written, path = export_day(es, index, day, args.page, args.out)
        days.append({"day": day.isoformat(), "expected": expected, "written": written, "file": os.path.basename(path)})
        note = "" if expected == written else "  <- counts differ"
        print(f"{day}  counted {expected:>9}  written {written:>9}{note}")
        day += dt.timedelta(days=1)

    manifest = {
        "url": args.url,
        "index": args.index,
        "exported_at": dt.datetime.now(dt.timezone.utc).isoformat(timespec="seconds"),
        "days": days,
    }
    with open(os.path.join(args.out, "manifest.json"), "w", encoding="utf-8") as handle:
        json.dump(manifest, handle, indent=2)
    print(f"done: {len(days)} day(s) in {args.out}")


if __name__ == "__main__":
    main()
