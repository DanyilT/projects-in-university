#!/usr/bin/env python3
"""Count PHP-targeted requests in the web honeypots of one instance (Table D7 of the report).

Reads the daily files written by export_es.py and writes php_probes.csv,
php_summary.json and eval_stdin_paths.txt to the results folder. A request is
PHP-targeted when its path, request URI or URL contains ".php". Each probe family
is matched on the same three fields, ignoring case, so one request can count in
more than one family. Addresses listed in --exclude-ips are left out, as in
load_local_es.py. Standard library only.

Example:
    python3 analysis/php_probes.py ~/tpot-data/eu/final/tpot-export ~/tpot-data/eu/final/results --exclude-ips ~/tpot-data/eu/exclude-ips.txt
"""
import argparse
import collections
import csv
import glob
import gzip
import json
import os

WEB_TYPES = {"Tanner", "H0neytr4p", "Honeyaml", "Wordpot"}
FIELDS = ("path", "request_uri", "url")
ANY_PHP = "Any .php request"
FAMILIES = [
    ("PHPUnit eval-stdin (CVE-2017-9841)", ("eval-stdin",)),
    ("PHP-CGI payload (CVE-2024-4577)", ("allow_url_include",)),
    ("phpMyAdmin", ("phpmyadmin", "/pma/")),
    ("WordPress login and XML-RPC", ("wp-login.php", "xmlrpc.php")),
    ("phpinfo", ("phpinfo", "info.php")),
    (".env files", (".env",)),
    ("ThinkPHP", ("invokefunction",)),
]
LATE_START, LATE_END = "2026-10-26", "2026-10-29"  # UTC days; the end day is excluded
TRAVERSAL = ("%2e", "%%32", "bin/sh")


def load_excluded(path):
    """Return the set of addresses listed in a file, one per line."""
    if not path:
        return set()
    with open(os.path.expanduser(path), encoding="utf-8") as handle:
        return {line.strip() for line in handle if line.strip() and not line.startswith("#")}


def contains(texts, needles):
    return any(needle in text for text in texts for needle in needles)


def user_agent(src):
    """Return the User-Agent of a web honeypot request, in lower case."""
    headers = src.get("headers")
    if isinstance(headers, dict):
        for key, value in headers.items():
            if key.lower() == "user-agent":
                return str(value or "").lower()
    return str(src.get("user-agent") or src.get("header_user-agent") or "").lower()


def detection(src):
    """Return Tanner's detection label, or 'none' when the event has none."""
    try:
        return src["response_msg"]["response"]["message"]["detection"]["name"]
    except (KeyError, TypeError):
        return "none"


def target(texts):
    """Label a request: C = PHP-CGI payload, P = PHPUnit probe, T = traversal to a shell, O = other."""
    if contains(texts, ("allow_url_include",)):
        return "C"
    if contains(texts, ("eval-stdin",)):
        return "P"
    if contains(texts, TRAVERSAL):
        return "T"
    return "O"


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("folder", help="folder with the daily .ndjson.gz files")
    parser.add_argument("out", help="folder for the result tables")
    parser.add_argument("--exclude-ips", help="file with addresses to leave out")
    args = parser.parse_args()
    os.makedirs(args.out, exist_ok=True)
    excluded = load_excluded(args.exclude_ips)

    counts = collections.Counter()  # (probe, window) -> requests
    sources = collections.defaultdict(set)  # (probe, window) -> source addresses
    daily = collections.Counter()  # (probe, day) -> requests
    detections = collections.Counter()
    eval_paths = set()
    payloads = collections.Counter()
    payload_sources = set()
    libredtail_requests = 0
    libredtail_sources = set()
    posts = collections.defaultdict(list)

    for path in sorted(glob.glob(os.path.join(args.folder, "*.ndjson.gz"))):
        with gzip.open(path, "rt", encoding="utf-8") as handle:
            for line in handle:
                if not any(kind in line for kind in WEB_TYPES):
                    continue
                src = json.loads(line)["_source"]
                kind = src.get("type")
                ip = src.get("src_ip")
                if kind not in WEB_TYPES or ip in excluded:
                    continue
                texts = [str(src.get(field) or "").lower() for field in FIELDS]
                stamp = src.get("@timestamp") or ""
                day = stamp[:10]
                late = LATE_START <= day < LATE_END
                agent = user_agent(src)

                probes = [ANY_PHP] if contains(texts, (".php",)) else []
                probes += [name for name, needles in FAMILIES if contains(texts, needles)]
                for name in probes:
                    counts[(name, "all")] += 1
                    sources[(name, "all")].add(ip)
                    daily[(name, day)] += 1
                    if late:
                        counts[(name, "late")] += 1
                        sources[(name, "late")].add(ip)

                if kind == "Tanner" and contains(texts, (".php",)):
                    detections[detection(src)] += 1
                if kind == "Tanner" and contains(texts, ("eval-stdin",)):
                    eval_paths.add(src.get("path") or "")
                if contains(texts, ("allow_url_include",)):
                    payloads["requests"] += 1
                    payload_sources.add(ip)
                    if "libredtail" in agent:
                        payloads["libredtail"] += 1
                if "libredtail" in agent:
                    libredtail_requests += 1
                    libredtail_sources.add(ip)
                    if (src.get("method") or src.get("request_method")) == "POST":
                        posts[ip].append((stamp, target(texts)))

    patterns = collections.Counter()
    for events in posts.values():
        events.sort()
        patterns["".join(letter for _, letter in events[:4])] += 1

    with open(os.path.join(args.out, "php_probes.csv"), "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["probe", "requests", "addresses", "requests_26_28_oct", "addresses_26_28_oct"])
        for name in [ANY_PHP] + [name for name, _ in FAMILIES]:
            writer.writerow([name, counts[(name, "all")], len(sources[(name, "all")]),
                             counts[(name, "late")], len(sources[(name, "late")])])

    with open(os.path.join(args.out, "eval_stdin_paths.txt"), "w", encoding="utf-8") as handle:
        handle.write("\n".join(sorted(eval_paths)) + "\n")

    summary = {
        "tanner_php_requests": sum(detections.values()),
        "tanner_php_detections": dict(detections.most_common()),
        "eval_stdin_tanner_paths": len(eval_paths),
        "payload_requests": payloads["requests"],
        "payload_addresses": len(payload_sources),
        "payload_with_libredtail_agent": payloads["libredtail"],
        "libredtail_requests": libredtail_requests,
        "libredtail_addresses": len(libredtail_sources),
        "libredtail_first_four_posts": dict(patterns.most_common()),
        "daily": {f"{name}|{day}": n for (name, day), n in sorted(daily.items())},
    }
    with open(os.path.join(args.out, "php_summary.json"), "w", encoding="utf-8") as handle:
        json.dump(summary, handle, indent=2)
    print(json.dumps(summary, indent=2))


if __name__ == "__main__":
    main()
