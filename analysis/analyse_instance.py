#!/usr/bin/env python3
"""Summarise the exported events of one instance into CSV tables.

Reads the daily files written by export_es.py (gzipped JSON lines) and writes
CSV tables and summary.json to the results folder. Standard library only.

Four kinds of record are kept apart:
- sensor records (P0f, Fatt and Suricata), which describe traffic in general;
- T-Pot web UI records (NGINX), which include the authors' own browsing;
- addresses listed in --exclude-ips (one per line, kept in a separate file);
- honeypot events, which are the attack data.

Source locations come from the `geoip` field, which describes the attacking
address. The `geoip_ext` field describes the instance itself and is not used.

Examples:
    python3 analysis/analyse_instance.py ~/tpot-data/eu/tpot-export ~/tpot-data/eu/results --exclude-ips ~/tpot-data/eu/exclude-ips.txt
    python3 analysis/analyse_instance.py ~/tpot-data/eu/tpot-export ~/tpot-data/eu/test --files "2026-10-01.ndjson.gz"
"""
import argparse
import collections
import csv
import glob
import gzip
import json
import os

TOP = 100
HTTP_PREFIXES = ("GET ", "POST ", "HEAD ", "CONNECT ", "OPTIONS ", "Host:")
SENSOR_TYPES = {"P0f", "Fatt", "Suricata"}
WEB_UI_TYPES = {"NGINX"}
WEB_TYPES = {"Tanner", "Honeyaml", "H0neytr4p"}


def documents(folder, pattern):
    """Yield the _source of every event, file by file."""
    for path in sorted(glob.glob(os.path.join(folder, pattern))):
        with gzip.open(path, "rt", encoding="utf-8") as handle:
            for line in handle:
                yield json.loads(line)["_source"]


def load_excluded(path):
    """Return the set of addresses listed in a file, one per line."""
    if not path:
        return set()
    with open(os.path.expanduser(path), encoding="utf-8") as handle:
        return {line.strip() for line in handle if line.strip() and not line.startswith("#")}


def write_rows(path, header, rows):
    with open(path, "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(header)
        writer.writerows(rows)


def web_request(src, kind):
    """Return (method, path) of a web honeypot event."""
    if kind in ("Tanner", "Honeyaml"):
        return src.get("method") or "", src.get("path") or ""
    return src.get("request_method") or "", src.get("request_uri") or ""


def user_agent(src, kind):
    """Return the User-Agent of a web honeypot event, or an empty string."""
    if kind == "Tanner" and isinstance(src.get("headers"), dict):
        return src["headers"].get("User-Agent") or src["headers"].get("user-agent") or ""
    return (src.get("user_agent") or src.get("http_user_agent")
            or src.get("user-agent") or src.get("header_user-agent") or "")


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("folder", help="folder with the daily .ndjson.gz files")
    parser.add_argument("out", help="folder for the result tables")
    parser.add_argument("--files", default="*.ndjson.gz", help="file pattern inside the folder")
    parser.add_argument("--exclude-ips", help="file with addresses to leave out of the honeypot tables")
    args = parser.parse_args()
    os.makedirs(args.out, exist_ok=True)
    excluded = load_excluded(args.exclude_ips)

    total = sensor_events = web_ui_events = excluded_events = 0
    with_geoip = honeypot_with_geoip = http_text_logins = 0
    first = last = None
    by_type = collections.Counter()
    by_day_type = collections.Counter()
    by_hour = collections.Counter()
    honeypot_by_hour = collections.Counter()
    src_events = collections.Counter()
    src_location = {}
    country_events = collections.Counter()
    country_ips = collections.defaultdict(set)
    as_events = collections.Counter()
    as_ips = collections.defaultdict(set)
    ports = collections.Counter()
    reputation = collections.Counter()
    credentials = collections.Counter()
    usernames = collections.Counter()
    passwords = collections.Counter()
    commands = collections.Counter()
    download_urls = collections.Counter()
    download_hashes = collections.Counter()
    web_requests = collections.Counter()
    user_agents = collections.Counter()
    sip_methods = collections.Counter()
    sip_agents = collections.Counter()
    conpot_events = collections.Counter()
    signatures = collections.Counter()
    suricata_event_types = collections.Counter()
    tpot_ips = collections.defaultdict(set)

    for src in documents(args.folder, args.files):
        total += 1
        stamp = src.get("@timestamp") or ""
        if first is None or stamp < first:
            first = stamp
        if last is None or stamp > last:
            last = stamp
        day, hour = stamp[:10], stamp[:13]
        kind = src.get("type") or "unknown"
        if str(src.get("eventid", "")).startswith("cowrie."):
            # Cowrie's key events overwrite the type field with the key algorithm
            kind = "Cowrie"
        if src.get("t-pot_ip_ext"):
            tpot_ips[day].add(src["t-pot_ip_ext"])
        if src.get("src_ip") in excluded and kind not in SENSOR_TYPES and kind not in WEB_UI_TYPES:
            excluded_events += 1
            continue
        by_type[kind] += 1
        by_day_type[(day, kind)] += 1
        by_hour[hour] += 1
        geo = src.get("geoip") or {}
        if geo:
            with_geoip += 1

        if kind in SENSOR_TYPES:
            sensor_events += 1
            if kind == "Suricata":
                suricata_event_types[src.get("event_type") or "none"] += 1
                alert = src.get("alert")
                if isinstance(alert, dict) and alert.get("signature"):
                    signatures[alert["signature"]] += 1
            continue
        if kind in WEB_UI_TYPES:
            web_ui_events += 1
            continue
        ip = src.get("src_ip")
        honeypot_by_hour[hour] += 1
        if geo:
            honeypot_with_geoip += 1
        country = geo.get("country_name") or "unknown"
        as_org = geo.get("as_org") or "unknown"
        country_events[country] += 1
        as_events[as_org] += 1
        if ip:
            src_events[ip] += 1
            src_location.setdefault(ip, (country, as_org))
            country_ips[country].add(ip)
            as_ips[as_org].add(ip)
        port = src.get("dest_port")
        if port not in (None, "", 0):
            ports[(kind, str(port))] += 1
        if src.get("ip_rep"):
            reputation[src["ip_rep"]] += 1

        if "username" in src or "password" in src:
            user = str(src.get("username") or "")
            password = str(src.get("password") or "")
            if user.startswith(HTTP_PREFIXES):
                http_text_logins += 1
            credentials[(kind, user, password)] += 1
            usernames[(kind, user)] += 1
            passwords[(kind, password)] += 1

        eventid = src.get("eventid") or ""
        if eventid == "cowrie.command.input":
            commands[src.get("input") or ""] += 1
        elif eventid == "cowrie.session.file_download":
            if src.get("url"):
                download_urls[src["url"]] += 1
            if src.get("shasum"):
                download_hashes[src["shasum"]] += 1

        if kind in WEB_TYPES:
            method, path = web_request(src, kind)
            web_requests[(kind, method, path)] += 1
            agent = user_agent(src, kind)
            if agent:
                user_agents[(kind, agent)] += 1
        if kind == "Sentrypeer":
            sip_methods[src.get("sip_method") or ""] += 1
            sip_agents[src.get("sip_user_agent") or ""] += 1
        if kind == "ConPot":
            conpot_events[src.get("event_type") or ""] += 1

    honeypot_events = total - sensor_events - web_ui_events - excluded_events
    write_rows(os.path.join(args.out, "events_per_hour.csv"), ["hour_utc", "events", "honeypot_events"],
               [(hour, by_hour[hour], honeypot_by_hour[hour]) for hour in sorted(by_hour)])
    write_rows(os.path.join(args.out, "events_per_day_type.csv"), ["day_utc", "type", "events"],
               [(day, kind, n) for (day, kind), n in sorted(by_day_type.items())])
    write_rows(os.path.join(args.out, "types.csv"), ["type", "events", "sensor"],
               [(kind, n, kind in SENSOR_TYPES) for kind, n in by_type.most_common()])
    write_rows(os.path.join(args.out, "countries.csv"), ["country", "honeypot_events", "unique_source_ips"],
               [(c, n, len(country_ips[c])) for c, n in country_events.most_common(TOP)])
    write_rows(os.path.join(args.out, "as_orgs.csv"), ["as_org", "honeypot_events", "unique_source_ips"],
               [(a, n, len(as_ips[a])) for a, n in as_events.most_common(TOP)])
    write_rows(os.path.join(args.out, "top_source_ips.csv"), ["src_ip", "honeypot_events", "country", "as_org"],
               [(ip, n, *src_location[ip]) for ip, n in src_events.most_common(TOP)])
    write_rows(os.path.join(args.out, "ports.csv"), ["type", "dest_port", "events"],
               [(kind, port, n) for (kind, port), n in ports.most_common(TOP)])
    write_rows(os.path.join(args.out, "ip_reputation.csv"), ["label", "honeypot_events"],
               reputation.most_common(TOP))
    write_rows(os.path.join(args.out, "credentials.csv"), ["type", "username", "password", "attempts"],
               [(k, u, p, n) for (k, u, p), n in credentials.most_common(TOP)])
    write_rows(os.path.join(args.out, "usernames.csv"), ["type", "username", "attempts"],
               [(k, u, n) for (k, u), n in usernames.most_common(TOP)])
    write_rows(os.path.join(args.out, "passwords.csv"), ["type", "password", "attempts"],
               [(k, p, n) for (k, p), n in passwords.most_common(TOP)])
    write_rows(os.path.join(args.out, "commands.csv"), ["input", "count"], commands.most_common(TOP))
    write_rows(os.path.join(args.out, "download_urls.csv"), ["url", "count"], download_urls.most_common(TOP))
    write_rows(os.path.join(args.out, "download_hashes.csv"), ["sha256", "count"], download_hashes.most_common(TOP))
    write_rows(os.path.join(args.out, "web_requests.csv"), ["type", "method", "path", "count"],
               [(k, m, p, n) for (k, m, p), n in web_requests.most_common(TOP)])
    write_rows(os.path.join(args.out, "user_agents.csv"), ["type", "user_agent", "count"],
               [(k, a, n) for (k, a), n in user_agents.most_common(TOP)])
    write_rows(os.path.join(args.out, "sip_methods.csv"), ["sip_method", "count"], sip_methods.most_common(TOP))
    write_rows(os.path.join(args.out, "sip_user_agents.csv"), ["sip_user_agent", "count"],
               sip_agents.most_common(TOP))
    write_rows(os.path.join(args.out, "conpot_event_types.csv"), ["event_type", "count"],
               conpot_events.most_common(TOP))
    write_rows(os.path.join(args.out, "suricata_event_types.csv"), ["event_type", "events"],
               suricata_event_types.most_common())
    write_rows(os.path.join(args.out, "suricata_signatures.csv"), ["signature", "alerts"],
               signatures.most_common())
    write_rows(os.path.join(args.out, "tpot_ip_by_day.csv"), ["day_utc", "t_pot_ip_ext"],
               [(day, ";".join(sorted(ips))) for day, ips in sorted(tpot_ips.items())])

    summary = {
        "events": total,
        "sensor_events": sensor_events,
        "web_ui_events": web_ui_events,
        "excluded_address_events": excluded_events,
        "honeypot_events": honeypot_events,
        "first_event_utc": first,
        "last_event_utc": last,
        "events_with_geoip": with_geoip,
        "honeypot_events_with_geoip": honeypot_with_geoip,
        "honeypot_unique_source_ips": len(src_events),
        "honeypot_countries": len(country_events),
        "download_urls": len(download_urls),
        "download_hashes": len(download_hashes),
        "login_events_with_http_text": http_text_logins,
        "events_by_type": dict(by_type.most_common()),
    }
    with open(os.path.join(args.out, "summary.json"), "w", encoding="utf-8") as handle:
        json.dump(summary, handle, indent=2)
    print(json.dumps(summary, indent=2))


if __name__ == "__main__":
    main()
