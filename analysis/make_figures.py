"""Draw the figures of the report from the analysis tables.

Usage: python3 analysis/make_figures.py <eu-results> <us-results> <out-folder>
           [--asia <asia-results>] [--investigations <folder>]

The results folders are the output of analyse_instance.py. The investigations folder
is the output of ssh_sessions.py and php_sequences.py. Without --asia the figure of the
services is skipped, and without --investigations the figures of the two campaigns.

The figures need matplotlib, which is not part of the standard library.
The analysis itself (analyse_instance.py) uses the standard library only.
"""
import argparse
import collections
import csv
import datetime as dt
import json
import os

import matplotlib

matplotlib.use("Agg")
import matplotlib.pyplot as plt  # noqa: E402
from matplotlib.patches import Patch  # noqa: E402

EU_COLOUR = "#1b6ca8"
US_COLOUR = "#c4572b"
ASIA_COLOUR = "#4f9d69"
WINDOW_START = dt.datetime(2026, 10, 1)
HOURS = 28 * 24
# Table 3: label, honeypot type and destination port of each service
SERVICES = [
    ("SIP, 5060 (Sentrypeer)", "Sentrypeer", "5060"),
    ("RDP, 3389 (RDPHoneypot)", "RDPHoneypot", "3389"),
    ("Heralding, 5900", "Heralding", "5900"),
    ("SSH (Cowrie), 22", "Cowrie", "22"),
    ("MSSQL (Dionaea), 1433", "Dionaea", "1433"),
    ("SMB (Dionaea), 445", "Dionaea", "445"),
    ("Telnet (Cowrie), 23", "Cowrie", "23"),
    ("HTTP (Tanner), 80", "Tanner", "80"),
]
TOP_SERVICES = 10
# SSH client fingerprints (hassh) of the key-writing sessions
FINGERPRINTS = [
    ("f555226df1963d1d3c09daf865abdc9a", "libssh 0.9.6", "#34495e"),
    ("03a80b21afa810682a776a7d42e5e6fb", "libssh 0.11.1", "#e0a458"),
    ("af8223ac9914f509afdadfaf5f7ee94e", "libssh 0.12.0", "#5b8e7d"),
]
# indicators of ssh_indicators.csv: label in the figure, name in the table
INDICATORS = [
    ("Unlock command before the key write", "typed `chattr -ia .ssh` before the key write"),
    ("Stored file equals the published hash", "stored file equals the published SHA-256"),
    ("Fingerprint libssh 0.9.6", "hassh f555226d"),
    ("Fingerprint libssh 0.11.1", "hassh 03a80b21"),
    ("Fingerprint libssh 0.12.0", "hassh af8223ac"),
]
# the six phases of the libredtail script, in the order of the requests
PHASES = [
    ("traversal", "Path traversal", "#555555"),
    ("cve-2024-4577", "CVE-2024-4577", "#b5365c"),
    ("phpunit", "PHPUnit eval-stdin.php", "#2c7fb8"),
    ("thinkphp", "ThinkPHP", "#e0a458"),
    ("pearcmd", "pearcmd", "#7b4fa0"),
    ("docker", "Docker API", "#4f9d69"),
]
SMALL = {"font.size": 7, "axes.titlesize": 7.5, "axes.labelsize": 7, "xtick.labelsize": 6.5,
         "ytick.labelsize": 6.5, "legend.fontsize": 6.5}


def read_hourly(folder):
    """Return {hour: (all events, honeypot events)} for the hours that have events."""
    hourly = {}
    with open(os.path.join(folder, "events_per_hour.csv")) as fh:
        for row in csv.DictReader(fh):
            stamp = dt.datetime.strptime(row["hour_utc"], "%Y-%m-%dT%H")
            hourly[stamp] = (int(row["events"]), int(row["honeypot_events"]))
    return hourly


def local_offset(region, stamp):
    """UTC offset of each region's location; Europe moves from CEST to CET on 25 October."""
    if region == "eu":
        return 2 if stamp < dt.datetime(2026, 10, 25, 1) else 1
    return -5


def figure_hourly(eu, us, out_path):
    fig, axes = plt.subplots(2, 1, figsize=(10, 6), sharex=True)
    stamps = [WINDOW_START + dt.timedelta(hours=i) for i in range(HOURS)]
    for ax, name, hourly, colour in [
        (axes[0], "Europe", eu, EU_COLOUR),
        (axes[1], "United States", us, US_COLOUR),
    ]:
        values = [hourly.get(s, (0, 0))[1] for s in stamps]
        ax.bar(stamps, values, width=1 / 24, color=colour, linewidth=0)
        for s in stamps:
            if s not in hourly:
                ax.axvspan(s, s + dt.timedelta(hours=1), color="0.85", linewidth=0)
        ax.set_ylabel("Honeypot events per hour")
        ax.set_title(name, loc="left", fontsize=10)
    axes[1].set_xlabel("UTC, October 2026 (grey: no events recorded)")
    fig.tight_layout()
    fig.savefig(out_path, dpi=150)
    plt.close(fig)


def figure_local_hour(eu, us, out_path):
    overlap = [s for s in eu if s in us]
    fig, ax = plt.subplots(figsize=(10, 4))
    width = 0.4
    for offset, (name, hourly, region, colour) in enumerate([
        ("Europe", eu, "eu", EU_COLOUR),
        ("United States", us, "us", US_COLOUR),
    ]):
        counts = [0] * 24
        for stamp in overlap:
            local = (stamp.hour + local_offset(region, stamp)) % 24
            counts[local] += hourly[stamp][1]
        total = sum(counts)
        shares = [100 * c / total for c in counts]
        xs = [h + (offset - 0.5) * width for h in range(24)]
        ax.bar(xs, shares, width=width, color=colour, label=name)
    ax.set_xticks(range(24))
    ax.set_xlabel("Local hour of day (Europe: Netherlands time; United States: Central time)")
    ax.set_ylabel("Share of honeypot events (%)")
    ax.legend(frameon=False)
    fig.tight_layout()
    fig.savefig(out_path, dpi=150)
    plt.close(fig)


def figure_countries(eu_folder, us_folder, out_path):
    fig, axes = plt.subplots(1, 2, figsize=(10, 4.5))
    for ax, name, folder, colour in [
        (axes[0], "Europe", eu_folder, EU_COLOUR),
        (axes[1], "United States", us_folder, US_COLOUR),
    ]:
        with open(os.path.join(folder, "countries.csv")) as fh:
            rows = list(csv.DictReader(fh))
        rows.sort(key=lambda r: -int(r["unique_source_ips"]))
        top = rows[:10][::-1]
        ax.barh([r["country"] for r in top], [int(r["unique_source_ips"]) for r in top], color=colour)
        ax.set_title(name, loc="left", fontsize=10)
        ax.set_xlabel("Unique source addresses")
    fig.tight_layout()
    fig.savefig(out_path, dpi=150)
    plt.close(fig)


def read_service_shares(folder):
    """Return {(type, port): share of the honeypot events in %} for the ten largest services."""
    with open(os.path.join(folder, "summary.json")) as fh:
        total = json.load(fh)["honeypot_events"]
    with open(os.path.join(folder, "ports.csv")) as fh:
        rows = sorted(csv.DictReader(fh), key=lambda r: -int(r["events"]))[:TOP_SERVICES]
    return {(r["type"], r["dest_port"]): 100 * int(r["events"]) / total for r in rows}


def figure_services(folders, out_path):
    """Table 3 as grouped bars; a service outside an instance's ten largest has no bar."""
    shares = [read_service_shares(folder) for folder in folders]
    instances = [("Europe", EU_COLOUR), ("United States", US_COLOUR), ("Asia", ASIA_COLOUR)]
    height = 0.26
    with plt.rc_context(SMALL):
        fig, ax = plt.subplots(figsize=(6.26, 3.3))
        for k, (name, colour) in enumerate(instances):
            for row, (_, kind, port) in enumerate(SERVICES):
                y = row + (k - 1) * height
                value = shares[k].get((kind, port))
                if value is None:
                    ax.text(0.3, y, "-", va="center", color="0.5")
                    continue
                ax.barh(y, value, height=height * 0.92, color=colour, linewidth=0)
                ax.text(value + 0.3, y, "%.1f" % value, va="center", fontsize=6)
        ax.set_yticks(range(len(SERVICES)))
        ax.set_yticklabels([label for label, _, _ in SERVICES])
        ax.set_ylim(len(SERVICES) - 0.5, -0.5)
        ax.set_xlim(0, 29)
        ax.set_xlabel("Share of the instance's honeypot events over its whole recording window (%)")
        ax.xaxis.grid(True, color="0.9", linewidth=0.6)
        ax.set_axisbelow(True)
        for side in ("top", "right"):
            ax.spines[side].set_visible(False)
        ax.legend(handles=[Patch(color=colour, label=name) for name, colour in instances],
                  loc="lower right", frameon=False)
        fig.tight_layout()
        fig.savefig(out_path, dpi=300)
        plt.close(fig)


def read_csv_rows(folder, name):
    with open(os.path.join(folder, name)) as fh:
        return list(csv.DictReader(fh))


def figure_ssh(folder, out_path):
    """Key-writing sessions per day and fingerprint, and what each indicator flags."""
    sessions = read_csv_rows(folder, "ssh_sessions.csv")
    indicators = read_csv_rows(folder, "ssh_indicators.csv")
    per_day = collections.Counter((s["region"], s["day_utc"], s["hassh"]) for s in sessions)
    days = [("us", d) for d in sorted({s["day_utc"] for s in sessions if s["region"] == "us"})]
    days += [("asia", d) for d in sorted({s["day_utc"] for s in sessions if s["region"] == "asia"})]
    xs = [0, 1, 2, 3.7, 4.7][:len(days)]
    with plt.rc_context(SMALL):
        fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(6.26, 2.9), gridspec_kw={"width_ratios": [1, 1.25]})
        for x, (region, day) in zip(xs, days):
            bottom = 0
            for hassh, _, colour in FINGERPRINTS:
                n = per_day[(region, day, hassh)]
                ax1.bar(x, n, bottom=bottom, width=0.7, color=colour, linewidth=0)
                bottom += n
            ax1.text(x, bottom + 1, str(bottom), ha="center", fontsize=6.5)
        ax1.set_xticks(xs)
        ax1.set_xticklabels([str(int(day[-2:])) for _, day in days])
        ax1.text(1, -0.2, "United States", ha="center", transform=ax1.get_xaxis_transform())
        ax1.text(4.2, -0.2, "Asia", ha="center", transform=ax1.get_xaxis_transform())
        ax1.set_ylabel("Key-writing sessions")
        ax1.set_ylim(0, 75)
        ax1.set_title("(a) Sessions per day in October, by fingerprint", loc="left")
        ax1.legend(handles=[Patch(color=colour, label=label) for _, label, colour in FINGERPRINTS],
                   loc="upper left", frameon=False)
        height = 0.36
        for k, (region, colour, name) in enumerate([("us", US_COLOUR, "United States"), ("asia", ASIA_COLOUR, "Asia")]):
            recall = {r["indicator"]: float(r["recall_pct"]) for r in indicators if r["region"] == region}
            for row, (_, key) in enumerate(INDICATORS):
                value = recall.get(key, 0.0)
                y = row + (k - 0.5) * height
                ax2.barh(y, value, height=height * 0.92, color=colour, linewidth=0,
                         label=name if row == 0 else None)
                ax2.text(value + 1.5, y, "%.1f" % value, va="center", fontsize=6)
        ax2.set_yticks(range(len(INDICATORS)))
        ax2.set_yticklabels([label for label, _ in INDICATORS])
        ax2.set_ylim(len(INDICATORS) - 0.5, -0.5)
        ax2.set_xlim(0, 118)
        ax2.set_xlabel("Share of the key-writing sessions (%)")
        ax2.set_title("(b) Sessions that each indicator flags", loc="left")
        ax2.legend(loc="lower right", frameon=False)
        for ax in (ax1, ax2):
            for side in ("top", "right"):
                ax.spines[side].set_visible(False)
        fig.tight_layout()
        fig.savefig(out_path, dpi=300)
        plt.close(fig)


def figure_php(folder, out_path):
    """The 49 requests of one libredtail run, and the length of all 79 runs by instance."""
    example = read_csv_rows(folder, "php_example_run.csv")
    runs = read_csv_rows(folder, "php_runs.csv")
    colours = {key: colour for key, _, colour in PHASES}
    with plt.rc_context(SMALL):
        fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(6.26, 3.8), gridspec_kw={"height_ratios": [1, 1.6]})
        for row in example:
            ax1.vlines(float(row["seconds"]), 0, 1, color=colours[row["probe"]], linewidth=1.6)
        ax1.set_xlim(-0.5, 25.5)
        ax1.set_ylim(0, 1)
        ax1.set_yticks([])
        ax1.set_xlabel("Seconds from the first request")
        counts = collections.Counter(row["probe"] for row in example)
        ax1.legend(handles=[Patch(color=colour, label="%s (%d)" % (label, counts[key])) for key, label, colour in PHASES],
                   loc="lower center", bbox_to_anchor=(0.5, 1.04), ncol=3, frameon=False)
        ax1.text(0, 1.5, "(a) The 49 requests of one run, in the order sent", transform=ax1.transAxes,
                 fontsize=7.5, va="bottom")
        x, ticks, labels = 0, [], []
        for name, region in [("Europe", "eu"), ("United States", "us"), ("Asia", "asia")]:
            lengths = sorted((r for r in runs if r["region"] == region), key=lambda r: -int(r["requests"]))
            start = x
            for run in lengths:
                complete = run["relation_to_the_script"] == "complete"
                ax2.bar(x, int(run["requests"]), width=0.8, linewidth=0,
                        color="#34495e" if complete else "#b0b7c0")
                x += 1
            ticks.append((start + x - 1) / 2)
            labels.append("%s (%d runs)" % (name, len(lengths)))
            x += 3
        script = ax2.axhline(49, color="0.4", linewidth=0.7, linestyle="--")
        ax2.set_xticks(ticks)
        ax2.set_xticklabels(labels)
        ax2.tick_params(axis="x", length=0)
        ax2.set_ylim(0, 54)
        ax2.set_ylabel("Requests in the run")
        ax2.set_title("(b) Requests in each of the 79 runs", loc="left")
        ax2.legend(handles=[Patch(color="#34495e", label="complete (44 or more)"),
                            Patch(color="#b0b7c0", label="partial"), script],
                   labels=["complete (44 or more)", "partial", "the script (49)"],
                   loc="lower right", bbox_to_anchor=(1, 0.98), ncol=3, frameon=False)
        for ax in (ax1, ax2):
            for side in ("top", "right"):
                ax.spines[side].set_visible(False)
        fig.tight_layout()
        fig.savefig(out_path, dpi=300)
        plt.close(fig)


def main():
    parser = argparse.ArgumentParser(description="Draw the figures of the report.")
    parser.add_argument("eu_results")
    parser.add_argument("us_results")
    parser.add_argument("out_folder")
    parser.add_argument("--asia", help="results folder of the Asian instance (adds the services figure)")
    parser.add_argument("--investigations", help="folder of ssh_sessions.py and php_sequences.py (adds the campaign figures)")
    args = parser.parse_args()
    os.makedirs(args.out_folder, exist_ok=True)
    eu = read_hourly(args.eu_results)
    us = read_hourly(args.us_results)
    figure_hourly(eu, us, os.path.join(args.out_folder, "figure1_hourly_events.png"))
    figure_local_hour(eu, us, os.path.join(args.out_folder, "figure2_local_hour.png"))
    figure_countries(args.eu_results, args.us_results, os.path.join(args.out_folder, "figure3_source_countries.png"))
    if args.asia:
        figure_services([args.eu_results, args.us_results, args.asia], os.path.join(args.out_folder, "services_by_instance.png"))
    if args.investigations:
        figure_ssh(args.investigations, os.path.join(args.out_folder, "ssh_campaign.png"))
        figure_php(args.investigations, os.path.join(args.out_folder, "php_scanner.png"))
    print("figures written to", args.out_folder)


if __name__ == "__main__":
    main()
