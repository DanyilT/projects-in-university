#!/usr/bin/env python3
"""Load exported T-Pot events into a local Elasticsearch for Kibana.

Reads the daily .ndjson.gz files written by export_es.py and bulk-loads them into
daily indices named <prefix>-YYYY.MM.DD (UTC). The index template keeps strings as
keywords and maps geoip.location as geo_point, so Kibana maps work. Document ids
are kept, so loading the same files again overwrites events instead of duplicating
them. Standard library only.

The T-Pot web UI records (NGINX) and any address listed in --exclude-ips are left
out, so they never appear in Kibana. The export files stay complete as the archive.

Example (local stack from docker-compose, listening on 127.0.0.1:9200):
    python3 analysis/load_local_es.py ~/tpot-data/eu/tpot-export --prefix tpot-eu --exclude-ips ~/tpot-data/eu/exclude-ips.txt
"""
import argparse
import glob
import gzip
import json
import os
import urllib.error
import urllib.request

WEB_UI_TYPES = {"NGINX"}

TEMPLATE = {
    "index_patterns": ["tpot-*"],
    "priority": 100,
    "template": {
        "settings": {
            "number_of_shards": 1,
            "number_of_replicas": 0,
            "refresh_interval": "30s",
            "index.mapping.total_fields.limit": 20000,
            "index.mapping.ignore_malformed": True,
        },
        "mappings": {
            "dynamic_templates": [
                {
                    "strings_as_keywords": {
                        "match_mapping_type": "string",
                        "mapping": {"type": "keyword", "ignore_above": 1024},
                    }
                }
            ],
            "properties": {
                "@timestamp": {"type": "date"},
                "geoip": {"properties": {"location": {"type": "geo_point"}}},
            },
        },
    },
}


def load_excluded(path):
    """Return the set of addresses listed in a file, one per line."""
    if not path:
        return set()
    with open(os.path.expanduser(path), encoding="utf-8") as handle:
        return {line.strip() for line in handle if line.strip() and not line.startswith("#")}


def call(method, url, body=None, content_type="application/json"):
    data = None
    if body is not None:
        data = body if isinstance(body, bytes) else json.dumps(body).encode("utf-8")
    request = urllib.request.Request(url, data=data, method=method, headers={"Content-Type": content_type})
    try:
        with urllib.request.urlopen(request, timeout=600) as reply:
            return json.load(reply)
    except urllib.error.HTTPError as err:
        raise SystemExit(f"{method} {url} failed: HTTP {err.code}: {err.read()[:300]!r}")
    except urllib.error.URLError as err:
        raise SystemExit(f"cannot reach {url}: {err.reason}")


def send(es, lines, stats):
    """Send one bulk request and count the documents that failed."""
    body = ("\n".join(lines) + "\n").encode("utf-8")
    reply = call("POST", f"{es}/_bulk", body, content_type="application/x-ndjson")
    for item in reply["items"]:
        result = next(iter(item.values()))
        stats["loaded"] += 1
        if "error" in result:
            stats["failed"] += 1
            if stats["failed"] <= 5:
                print("  failed:", json.dumps(result["error"])[:300])


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("folder", help="folder with the daily .ndjson.gz files")
    parser.add_argument("--prefix", required=True, help="index prefix, for example tpot-eu")
    parser.add_argument("--es", default="http://127.0.0.1:9200", help="local Elasticsearch URL")
    parser.add_argument("--files", default="*.ndjson.gz", help="file pattern inside the folder")
    parser.add_argument("--batch", type=int, default=5000, help="documents per bulk request")
    parser.add_argument("--exclude-ips", help="file with addresses to leave out of the local index")
    args = parser.parse_args()
    excluded = load_excluded(args.exclude_ips)

    call("PUT", f"{args.es}/_index_template/tpot-events", TEMPLATE)
    stats = {"loaded": 0, "failed": 0, "skipped": 0}
    lines = []
    for path in sorted(glob.glob(os.path.join(args.folder, args.files))):
        before = stats["loaded"]
        with gzip.open(path, "rt", encoding="utf-8") as handle:
            for line in handle:
                record = json.loads(line)
                source = record["_source"]
                if source.get("type") in WEB_UI_TYPES or source.get("src_ip") in excluded:
                    stats["skipped"] += 1
                    continue
                day = (source.get("@timestamp") or "")[:10].replace("-", ".") or "undated"
                lines.append(json.dumps({"index": {"_index": f"{args.prefix}-{day}", "_id": record["_id"]}},
                                        separators=(",", ":")))
                lines.append(json.dumps(source, separators=(",", ":")))
                if len(lines) >= 2 * args.batch:
                    send(args.es, lines, stats)
                    lines = []
        print(f"{os.path.basename(path)}: {stats['loaded'] - before} documents")
    if lines:
        send(args.es, lines, stats)
    call("POST", f"{args.es}/_refresh")
    print(f"done: {stats['loaded']} documents loaded, {stats['failed']} failed, "
          f"{stats['skipped']} skipped (web UI and excluded addresses)")


if __name__ == "__main__":
    main()
