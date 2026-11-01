#!/usr/bin/env python3
"""Compare the request sequences of the libredtail-http scanner in the web honeypots (Section 3.3).

For each source address and web honeypot the script lists the requests that carry the
libredtail-http user agent in time order. A run ends after a pause of five minutes. The
script finds the request sequence that most runs share, called the script here, and counts
how many runs follow it in order. Tanner (port 80) logs the request path and the response
label. H0neytr4p (port 443) logs the request URI and the request body, so the bodies of
different addresses can be compared there.

The script writes these files to the results folder:
- php_runs.csv: one row per run, without addresses;
- php_example_run.csv: the first complete run on Tanner, request by request;
- php_sequence_summary.json: counts for each instance.

Source addresses are used only to count them. Addresses listed in --exclude-ips are left
out. Standard library only.

Example:
    python3 analysis/php_sequences.py ~/tpot-data/investigations eu=~/tpot-data/eu/final/tpot-export us=~/tpot-data/us/final/tpot-export asia=~/tpot-data/asia/final/tpot-export --exclude-ips ~/tpot-data/eu/exclude-ips.txt
"""
import argparse
import collections
import csv
import glob
import gzip
import hashlib
import itertools
import json
import os
import statistics
from datetime import datetime

WEB_TYPES = {"Tanner", "H0neytr4p", "Honeyaml", "Wordpot"}
AGENT = "libredtail"
GAP_SECONDS = 300
COMPLETE = 44  # two traversal requests, five CVE-2024-4577 requests and 37 PHPUnit probes
TIME_FORMAT = "%Y-%m-%dT%H:%M:%S.%fZ"


def load_excluded(path):
    """Return the set of addresses listed in a file, one per line."""
    if not path:
        return set()
    with open(os.path.expanduser(path), encoding="utf-8") as handle:
        return {line.strip() for line in handle if line.strip() and not line.startswith("#")}


def header(src, key):
    headers = src.get("headers")
    if isinstance(headers, dict):
        for name, value in headers.items():
            if name.lower() == key:
                return str(value or "")
    return str(src.get(f"header_{key}") or src.get(key) or "")


def uri(src):
    """Return the requested URI: H0neytr4p keeps it in request_uri, the other honeypots in path."""
    if src.get("type") == "H0neytr4p":
        return src.get("request_uri") or ""
    return src.get("path") or src.get("request_uri") or src.get("url") or ""


def label(src):
    """Return Tanner's detection label of the response, or an empty string."""
    try:
        return src["response_msg"]["response"]["message"]["detection"]["name"]
    except (KeyError, TypeError):
        return ""


def phase(path):
    """Name the probe that a request belongs to."""
    low = path.lower()
    if path.startswith("/cgi-bin/") and "bin/sh" in path:
        return "traversal"
    if "allow_url_include" in low:
        return "cve-2024-4577"
    if "eval-stdin" in low:
        return "phpunit"
    if "invokefunction" in low:
        return "thinkphp"
    if "pearcmd" in low or "lang=../" in low:
        return "pearcmd"
    if path.startswith("/containers/json"):
        return "docker"
    return "other"


def in_order(run, script):
    """True when every request is a step of the script and the steps follow the script's order.

    H0neytr4p logs whole seconds, so requests that share a timestamp may come in any order.
    """
    position = {path: number for number, path in enumerate(script)}
    last = -1
    for _, group in itertools.groupby(run, key=lambda r: r["ts"]):
        steps = []
        for r in group:
            if r["uri"] not in position:
                return False
            steps.append(position[r["uri"]])
        if min(steps) <= last:
            return False
        last = max(steps)
    return True


def read_runs(folder, excluded):
    """Return the libredtail runs of one instance as {(address, honeypot, port): [request, ...]}."""
    requests = collections.defaultdict(list)
    for path in sorted(glob.glob(os.path.join(os.path.expanduser(folder), "*.ndjson.gz"))):
        with gzip.open(path, "rt", encoding="utf-8") as handle:
            for line in handle:
                if AGENT not in line:
                    continue
                src = json.loads(line)["_source"]
                if src.get("type") not in WEB_TYPES or src.get("src_ip") in excluded or AGENT not in header(src, "user-agent").lower():
                    continue
                body = src.get("payload") or ""
                requests[(src.get("src_ip"), src["type"], str(src.get("dest_port")))].append({
                    "ts": datetime.strptime(src["@timestamp"], TIME_FORMAT),
                    "uri": uri(src),
                    "method": src.get("method") or src.get("request_method") or "",
                    "length": header(src, "content-length"),
                    "label": label(src),
                    "body": hashlib.sha256(body.encode()).hexdigest()[:12] if body else "",
                })
    runs = []
    for (ip, kind, port), items in requests.items():
        items.sort(key=lambda r: r["ts"])
        current = [items[0]]
        for item in items[1:]:
            if (item["ts"] - current[-1]["ts"]).total_seconds() > GAP_SECONDS:
                runs.append((ip, kind, port, current))
                current = []
            current.append(item)
        runs.append((ip, kind, port, current))
    return runs


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("out", help="folder for the result tables")
    parser.add_argument("exports", nargs="+", help="region=folder with the daily .ndjson.gz files")
    parser.add_argument("--exclude-ips", help="file with addresses to leave out")
    args = parser.parse_args()
    os.makedirs(args.out, exist_ok=True)
    excluded = load_excluded(args.exclude_ips)

    runs = {}
    for item in args.exports:
        region, folder = item.split("=", 1)
        runs[region] = read_runs(folder, excluded)
        print(region, len(runs[region]), "runs from", len({r[0] for r in runs[region]}), "addresses")

    # The script is the most common 49-request sequence on Tanner.
    candidates = collections.Counter(tuple(r["uri"] for r in run) for rs in runs.values() for ip, kind, port, run in rs
                                     if kind == "Tanner" and len(run) == 49)
    script, shared = candidates.most_common(1)[0]
    phases = collections.Counter(phase(path) for path in script)

    summary = {"script_requests": len(script), "script_phases": dict(phases), "runs_with_the_exact_script": shared}
    rows, example = [], None
    payloads = collections.defaultdict(set)  # (probe, body hash) -> {(region, address)}
    lengths = collections.defaultdict(collections.Counter)
    for region, rs in runs.items():
        complete = partial = other = 0
        durations, labels = [], collections.Counter()
        complete_addresses = set()
        for ip, kind, port, run in rs:
            ordered = in_order(run, script)
            span = (run[-1]["ts"] - run[0]["ts"]).total_seconds()
            state = "complete" if ordered and len(run) >= COMPLETE else "partial" if ordered else "other"
            if state == "complete":
                complete += 1
                complete_addresses.add(ip)
                durations.append(span)
                for r in run:
                    if kind == "Tanner":
                        labels[(phase(r["uri"]), r["label"])] += 1
                if kind == "Tanner" and (example is None or run[0]["ts"] < example[0]) and region == "eu":
                    example = (run[0]["ts"], run)
            elif state == "partial":
                partial += 1
            else:
                other += 1
            rows.append([region, kind, port, run[0]["ts"].strftime("%Y-%m-%d"), len(run), state, round(span, 1)])
            for r in run:
                probe = phase(r["uri"])
                if r["body"] and probe in ("traversal", "cve-2024-4577"):
                    payloads[(probe, r["body"])].add((region, ip))
                if kind == "Tanner" and probe in ("traversal", "cve-2024-4577") and r["length"]:
                    lengths[probe][r["length"]] += 1
        days = sorted({r[3] for r in rows if r[0] == region})
        summary[region] = {
            "addresses": len({ip for ip, *_ in rs}),
            "runs": len(rs),
            "complete_runs": complete,
            "addresses_with_a_complete_run": len(complete_addresses),
            "partial_runs_in_script_order": partial,
            "runs_out_of_script_order": other,
            "requests": sum(len(run) for *_, run in rs),
            "runs_per_port": dict(collections.Counter(port for _, _, port, _ in rs)),
            "first_day": days[0], "last_day": days[-1],
            "complete_run_seconds": [min(durations), statistics.median(durations), max(durations)] if durations else None,
            "tanner_labels_in_complete_runs": {f"{p}|{l}": n for (p, l), n in sorted(labels.items())},
        }
    everyone = {region: {ip for ip, *_ in rs} for region, rs in runs.items()}
    names = list(everyone)
    summary["addresses_overall"] = len(set().union(*everyone.values()))
    summary["addresses_in_all_instances"] = len(set.intersection(*everyone.values()))
    summary["addresses_in_two_or_more_instances"] = len({ip for ip in set().union(*everyone.values()) if sum(ip in s for s in everyone.values()) > 1})
    summary["request_bodies"] = {
        probe: {
            "distinct_bodies": len({b for (p, b) in payloads if p == probe}),
            "addresses_per_body": sorted((len({ip for _, ip in v}) for (p, b), v in payloads.items() if p == probe), reverse=True),
            "regions_of_the_most_common_body": sorted({r for r, _ in max((v for (p, b), v in payloads.items() if p == probe), key=len)}),
        } for probe in ("traversal", "cve-2024-4577") if any(p == probe for p, _ in payloads)
    }
    summary["tanner_content_lengths"] = {probe: dict(c.most_common(5)) for probe, c in lengths.items()}

    with open(os.path.join(args.out, "php_runs.csv"), "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["region", "honeypot", "port", "first_day_utc", "requests", "relation_to_the_script", "seconds"])
        writer.writerows(rows)
    if example:
        start, run = example
        with open(os.path.join(args.out, "php_example_run.csv"), "w", newline="", encoding="utf-8") as handle:
            writer = csv.writer(handle)
            writer.writerow(["request", "seconds", "method", "probe", "uri", "body_bytes", "tanner_response"])
            for number, r in enumerate(run, 1):
                writer.writerow([number, round((r["ts"] - start).total_seconds(), 1), r["method"], phase(r["uri"]), r["uri"][:140], r["length"], r["label"]])
        summary["example_run_first_request_utc"] = start.strftime("%Y-%m-%dT%H:%M:%SZ")
    with open(os.path.join(args.out, "php_sequence_summary.json"), "w", encoding="utf-8") as handle:
        json.dump(summary, handle, indent=2)
    print(json.dumps(summary, indent=2)[:4000])


if __name__ == "__main__":
    main()
