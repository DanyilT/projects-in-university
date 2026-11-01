#!/usr/bin/env python3
"""Analyse the key-writing Cowrie sessions of the T-Pot instances (Section 3.2 of the report).

A key-writing session is a Cowrie session in which the attacker typed a command that
contains the key comment `mdrfckr`. The script reads the daily files that export_es.py
wrote for each instance and writes these files to the results folder:

- ssh_sessions.csv: one row per key-writing session, without addresses or key text;
- ssh_fingerprints.csv: the SSH client fingerprints (hassh) of those sessions, and how
  well each fingerprint picks out the key-writing sessions among all Cowrie sessions;
- ssh_indicators.csv: the same comparison for the stored key file and the unlock command;
- ssh_example_session.csv: one session in order, with the key and the new passwords masked;
- ssh_summary.json: counts for each instance.

Source addresses are used only to count them. Addresses listed in --exclude-ips are left
out, as in the other scripts. Standard library only.

Example:
    python3 analysis/ssh_sessions.py ~/tpot-data/investigations eu=~/tpot-data/eu/final/tpot-export us=~/tpot-data/us/final/tpot-export asia=~/tpot-data/asia/final/tpot-export --exclude-ips ~/tpot-data/eu/exclude-ips.txt
"""
import argparse
import collections
import csv
import glob
import gzip
import json
import os
import re
import statistics
from datetime import datetime

KEY_COMMENT = "mdrfckr"
UNLOCK = "chattr -ia .ssh"
# The SHA-256 of the authorized_keys file that the campaign writes, from the SANS ISC guest
# diary "New Malware Libraries means New Signatures" (15 May 2026), https://isc.sans.edu/diary/32986.
PUBLISHED_SHA256 = "a8460f446be540410004b1a8db4083773fa46f7fe76fa84219c93daa1669f8f2"
# Fingerprints (hassh) that the same diary lists for the campaign, with the client banner and period.
PUBLISHED_HASSH = {
    "51cba57125523ce4b9db67714a90bf6e": "libssh 0.6.0 and 0.6.3, October to November 2022",
    "f555226df1963d1d3c09daf865abdc9a": "libssh 0.9.5 and 0.9.6, December 2022 onward",
    "03a80b21afa810682a776a7d42e5e6fb": "libssh 0.11.1, April 2026",
}
TIME_FORMAT = "%Y-%m-%dT%H:%M:%S.%fZ"
KEPT = ("session", "eventid", "src_ip", "input", "username", "password", "version", "hassh", "shasum", "duration")


def load_excluded(path):
    """Return the set of addresses listed in a file, one per line."""
    if not path:
        return set()
    with open(os.path.expanduser(path), encoding="utf-8") as handle:
        return {line.strip() for line in handle if line.strip() and not line.startswith("#")}


def cowrie_sessions(folder, excluded):
    """Return {session id: [event, ...]} for every Cowrie event in the daily files of one instance."""
    sessions = collections.defaultdict(list)
    for path in sorted(glob.glob(os.path.join(os.path.expanduser(folder), "*.ndjson.gz"))):
        with gzip.open(path, "rt", encoding="utf-8") as handle:
            for line in handle:
                if '"cowrie.' not in line:
                    continue
                src = json.loads(line)["_source"]
                if not str(src.get("eventid", "")).startswith("cowrie.") or src.get("src_ip") in excluded:
                    continue
                event = {key: src.get(key) for key in KEPT}
                event["ts"] = src.get("@timestamp") or ""
                if event["session"]:
                    sessions[event["session"]].append(event)
    return sessions


def summarise(events):
    """Reduce the events of one session to the facts that the report uses."""
    events.sort(key=lambda e: e["ts"])
    commands = [e["input"] for e in events if e["eventid"] == "cowrie.command.input" and e["input"]]
    key_index = next((i + 1 for i, c in enumerate(commands) if KEY_COMMENT in c), None)
    closed = next((e["duration"] for e in events if e["eventid"] == "cowrie.session.closed"), None)
    return {
        "first": events[0]["ts"],
        "ip": next((e["src_ip"] for e in events if e["src_ip"]), None),
        "version": next((e["version"] for e in events if e["eventid"] == "cowrie.client.version"), None),
        "hassh": next((e["hassh"] for e in events if e["eventid"] == "cowrie.client.kex"), None),
        "logged_in": any(e["eventid"] == "cowrie.login.success" for e in events),
        "commands": commands,
        "key_index": key_index,
        "unlock_first": any(UNLOCK in c for c in commands[:key_index]) if key_index else False,
        "stored": [e["shasum"] for e in events if e["eventid"] == "cowrie.session.file_download" and e["shasum"]],
        "duration": float(closed) if closed else None,
    }


def mask(command):
    """Hide the public key and the new passwords in a typed command."""
    command = re.sub(r"ssh-rsa\s+\S+", "ssh-rsa [key omitted]", command)
    return re.sub(r'(echo(?: -e)? )"[^"]*"(\s*\|\s*(?:ch)?passwd)', r'\1"[passwords]"\2', command)


def example_rows(events):
    """List one session in order: seconds since the connection, event and detail."""
    events = sorted(events, key=lambda e: e["ts"])
    start = events[0]["ts"]

    def seconds(ts):
        return round((parse(ts) - parse(start)).total_seconds(), 1)

    rows = []
    for e in events:
        kind, detail = e["eventid"], None
        if kind == "cowrie.session.connect":
            label, detail = "Connection", "SSH to port 22"
        elif kind == "cowrie.client.version":
            label, detail = "Client version", e["version"]
        elif kind == "cowrie.client.kex":
            label, detail = "Client fingerprint (hassh)", e["hassh"]
        elif kind == "cowrie.login.success":
            label, detail = "Login accepted", f"{e['username']} / {e['password']}"
        elif kind == "cowrie.command.input":
            label, detail = "Command", mask(e["input"])
        elif kind == "cowrie.session.file_download":
            label, detail = "File stored", f"SHA-256 {e['shasum']}"
        elif kind == "cowrie.session.closed":
            label, detail = "Session closed", f"after {e['duration']} s"
        else:
            continue
        rows.append((seconds(e["ts"]), label, detail))
    return rows


def parse(ts):
    return datetime.strptime(ts, TIME_FORMAT)


def pct(part, whole):
    return round(100 * part / whole, 1) if whole else 0.0


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("out", help="folder for the result tables")
    parser.add_argument("exports", nargs="+", help="region=folder with the daily .ndjson.gz files")
    parser.add_argument("--exclude-ips", help="file with addresses to leave out")
    parser.add_argument("--example", default="us", help="region of the example session (default: us)")
    args = parser.parse_args()
    os.makedirs(args.out, exist_ok=True)
    excluded = load_excluded(args.exclude_ips)

    keyed = {}  # region -> {session id: summary} for the key-writing sessions
    all_hassh = {}  # region -> Counter of fingerprints over all Cowrie sessions
    login_hassh, typed_hassh = {}, {}  # the same fingerprints, for sessions that logged in and that typed commands
    all_unlock = {}  # region -> number of sessions that typed the unlock command
    all_stored = {}  # region -> number of sessions that stored the published file
    example = None
    for item in args.exports:
        region, folder = item.split("=", 1)
        sessions = cowrie_sessions(folder, excluded)
        keyed[region], all_hassh[region] = {}, collections.Counter()
        login_hassh[region], typed_hassh[region] = collections.Counter(), collections.Counter()
        all_unlock[region] = all_stored[region] = 0
        for sid, events in sessions.items():
            info = summarise(events)
            if info["hassh"]:
                all_hassh[region][info["hassh"]] += 1
                login_hassh[region][info["hassh"]] += info["logged_in"]
                typed_hassh[region][info["hassh"]] += bool(info["commands"])
            all_unlock[region] += any(UNLOCK in c for c in info["commands"])
            all_stored[region] += PUBLISHED_SHA256 in info["stored"]
            if info["key_index"]:
                keyed[region][sid] = info
                if region == args.example and info["stored"] and (example is None or info["first"] < example[0]):
                    example = (info["first"], sid, events)
        print(region, len(sessions), "Cowrie sessions,", len(keyed[region]), "key-writing")

    regions = list(keyed)
    sessions_path = os.path.join(args.out, "ssh_sessions.csv")
    with open(sessions_path, "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["region", "session", "day_utc", "client_version", "hassh", "commands", "key_write_position",
                         "unlock_before_key_write", "stored_file_sha256", "duration_s"])
        for region in regions:
            for sid, i in sorted(keyed[region].items(), key=lambda kv: kv[1]["first"]):
                writer.writerow([region, sid, i["first"][:10], i["version"], i["hassh"], len(i["commands"]), i["key_index"],
                                 i["unlock_first"], ";".join(sorted(set(i["stored"]))), i["duration"]])

    summary, fingerprints, indicators = {}, [], []
    total_keyed = sum(len(v) for v in keyed.values())
    for region in regions:
        rows = list(keyed[region].values())
        n = len(rows)
        by_hassh = collections.Counter(r["hassh"] for r in rows)
        for hassh, count in by_hassh.most_common():
            versions = sorted({r["version"] for r in rows if r["hassh"] == hassh})
            addresses = len({r["ip"] for r in rows if r["hassh"] == hassh})
            fingerprints.append([region, hassh, " / ".join(v for v in versions if v), PUBLISHED_HASSH.get(hassh, "not listed"),
                                 count, addresses, pct(count, n), all_hassh[region][hassh], login_hassh[region][hassh],
                                 typed_hassh[region][hassh], pct(count, typed_hassh[region][hassh])])
            indicators.append([region, f"hassh {hassh[:8]}", count, pct(count, n), all_hassh[region][hassh], typed_hassh[region][hassh]])
        stored = sum(PUBLISHED_SHA256 in r["stored"] for r in rows)
        indicators.append([region, "stored file equals the published SHA-256", stored, pct(stored, n), all_stored[region], all_stored[region]])
        unlock = sum(r["unlock_first"] for r in rows)
        indicators.append([region, f"typed `{UNLOCK}` before the key write", unlock, pct(unlock, n), all_unlock[region], all_unlock[region]])
        durations = [r["duration"] for r in rows if r["duration"] is not None]
        after = collections.Counter()
        for r in rows:
            for c in set(mask(c) for c in r["commands"][r["key_index"]:]):
                if "passwd" not in c and "UNIX password" not in c:
                    after[c] += 1
        common = [c for c, k in after.items() if k >= 0.9 * n]
        summary[region] = {
            "key_writing_sessions": n,
            "addresses": len({r["ip"] for r in rows}),
            "sessions_per_day": dict(sorted(collections.Counter(r["first"][:10] for r in rows).items())),
            "addresses_per_day": {d: len({r["ip"] for r in rows if r["first"][:10] == d}) for d in sorted({r["first"][:10] for r in rows})},
            "fingerprints": dict(by_hassh.most_common()),
            "stored_file_hashes": dict(collections.Counter(h for r in rows for h in set(r["stored"])).most_common()),
            "sessions_with_the_published_file": stored,
            "sessions_without_a_stored_file": sum(not r["stored"] for r in rows),
            "key_write_position": dict(sorted(collections.Counter(r["key_index"] for r in rows).items())),
            "unlock_before_key_write": unlock,
            "commands_after_the_key_write_typed_by_90_percent": len(common),
            "sessions_that_typed_all_of_them": sum(all(c in {mask(x) for x in r["commands"]} for c in common) for r in rows),
            "sessions_with_a_password_change": sum(any("passwd" in c for c in r["commands"]) for r in rows),
            "sessions_with_competitor_cleanup": sum(any("secure.sh" in c for c in r["commands"]) for r in rows),
            "sessions_that_logged_in": sum(r["logged_in"] for r in rows),
            "commands_per_session": [min(len(r["commands"]) for r in rows), max(len(r["commands"]) for r in rows)] if rows else None,
            "duration_s": [min(durations), statistics.median(durations), max(durations)] if durations else None,
        }
    if len(regions) > 1:
        sets = {region: {r["ip"] for r in keyed[region].values()} for region in regions}
        both = set.intersection(*[s for s in sets.values() if s])
        summary["addresses_in_every_region_with_sessions"] = len(both)
        summary["key_writing_sessions_total"] = total_keyed
    with open(os.path.join(args.out, "ssh_fingerprints.csv"), "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["region", "hassh", "client_banner", "listed_in_the_sans_diary", "key_writing_sessions", "key_writing_addresses",
                         "share_of_key_writing_sessions_pct", "all_cowrie_sessions_with_it", "of_which_logged_in", "of_which_typed_commands",
                         "share_of_those_that_typed_commands_that_wrote_the_key_pct"])
        writer.writerows(fingerprints)
    with open(os.path.join(args.out, "ssh_indicators.csv"), "w", newline="", encoding="utf-8") as handle:
        writer = csv.writer(handle)
        writer.writerow(["region", "indicator", "key_writing_sessions_matched", "recall_pct", "all_cowrie_sessions_matched", "of_which_typed_commands"])
        writer.writerows(indicators)
    if example:
        with open(os.path.join(args.out, "ssh_example_session.csv"), "w", newline="", encoding="utf-8") as handle:
            writer = csv.writer(handle)
            writer.writerow(["seconds_since_connection", "event", "detail"])
            writer.writerows(example_rows(example[2]))
        summary["example_session"] = {"region": args.example, "session": example[1], "first_event_utc": example[0]}
    with open(os.path.join(args.out, "ssh_summary.json"), "w", encoding="utf-8") as handle:
        json.dump(summary, handle, indent=2)
    print(json.dumps(summary, indent=2)[:3000])


if __name__ == "__main__":
    main()
