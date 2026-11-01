# Reproduce the findings

These steps produced the data in the report. Values in angle brackets come from your own setup. Do not commit them to the repository.

| Placeholder | Meaning |
|---|---|
| `<vm-ip>` | External IP address of one T-Pot VM |
| `<os-user>` | The Linux user that the T-Pot installer ran as |
| `<admin-ip>` | The public IP address you use for administration |
| `<region>` | `eu`, `us` or `asia` |

## 1. Create each instance

1. Create a Google Cloud VM with the e2-standard-4 machine type (4 vCPUs, 16 GB memory) and a 128 GB boot disk. Record the zone and the operating system image.
2. Add two firewall rules and apply them to the VM, for example through a network tag:
   - `tpot-admin-access`: allow TCP 64295 and 64297 from `<admin-ip>/32` only.
   - `tpot-honeypot-catchall`: allow TCP 1-64000 and UDP 1-64000 from anywhere.
3. Stop and disable the preinstalled mail server, which holds port 25 that the Mailoney honeypot needs:

   ```bash
   sudo systemctl stop exim4
   sudo systemctl disable exim4
   ```

4. Install T-Pot as `<os-user>` and choose the Hive installation type (`h`):

   ```bash
   env bash -c "$(curl -sL https://github.com/telekom-security/tpotce/raw/master/install.sh)"
   ```

   The installer's clock-synchronisation task fails on a VM without a hardware clock (`hwclock: not found`). The playbook continues after that error, so it can be ignored.
5. Reboot the VM:

   ```bash
   sudo reboot
   ```

## 2. Connect

- Administration is on port 64295, not 22. Port 22 belongs to the Cowrie honeypot, so `gcloud compute ssh` without a port option connects to the honeypot:

  ```bash
  ssh -i ~/.ssh/google_compute_engine -p 64295 <os-user>@<vm-ip>
  ```

  `-i` names the key that gcloud created on your Mac. Without it, ssh offers only the default key names, such as `~/.ssh/id_ed25519`, and the VM rejects them with `Permission denied (publickey)`.

  Or let gcloud manage the key and the port:

  ```bash
  gcloud compute ssh <os-user>@<vm-name> --zone <zone> --ssh-flag="-p 64295"
  ```

- The T-Pot landing page is at `https://<vm-ip>:64297`. Kibana opens from that page.

## 3. Record the instance

Run these on the VM. Add `sudo` if Docker needs it. Keep the output for the report.

```bash
docker ps --format '{{.Names}}' | sort                 # honeypots and tools that are running
git -C ~/tpotce describe --tags --always               # T-Pot version
docker ps --format '{{.Names}}: {{.Status}}' | head -3 # container uptime, which gives the start time
timedatectl status | grep -i synchronized              # clock check
```

## 4. Check Elasticsearch (read only)

Elasticsearch is published on `127.0.0.1:64298` on the VM. These commands only read.

```bash
curl -s 'http://127.0.0.1:64298/_cat/indices?v'
curl -s 'http://127.0.0.1:64298/logstash-*/_search?size=1&pretty'
```

Send the index list and one sample event for checking. If the first command returns HTTP 401, Elasticsearch needs a login. Export `ES_USER` and `ES_PASSWORD` in the shell and send only the error, not the password.

## 5. Export the events

Copy the exporter to the VM from the laptop:

```bash
scp -i ~/.ssh/google_compute_engine -P 64295 analysis/export_es.py <os-user>@<vm-ip>:~/
```

Test the script on one finished day first. The counted and written numbers must match:

```bash
python3 ~/export_es.py --start 2026-10-25 --end 2026-10-26 --out ~/tpot-test
```

Start the full export inside `tmux`, so that it keeps running if your SSH connection drops. The end date is exclusive: `2026-10-29` exports up to and including 28 October. Use `--start 2026-10-15` for the Asian instance.

```bash
tmux new -s export
```

Inside the session, run:

```bash
python3 ~/export_es.py --start 2026-10-01 --end 2026-10-29 --out ~/tpot-export
```

Detach with `Ctrl-b`, then `d`. Reattach later with:

```bash
tmux attach -t export
```

If the export stops, restart it from the first missing day. A rerun overwrites only the days it exports:

```bash
python3 ~/export_es.py --start 2026-10-19 --end 2026-10-29 --out ~/tpot-export
```

The script writes one `YYYY-MM-DD.ndjson.gz` file per UTC day and a `manifest.json` with the count for each day. For a finished day the counted and written numbers must match. A day marked `counts differ` needs a second export before it is used.

Copy the folder to the laptop, outside the repository:

```bash
scp -i ~/.ssh/google_compute_engine -P 64295 -r <os-user>@<vm-ip>:~/tpot-export ~/Projects/tpot-data/<region>/
```

Export before 31 October. T-Pot keeps Elasticsearch indices for 30 days by default, and the oldest days are removed after that.

If the export fails, copy the raw persistent logs instead. The T-Pot documentation stores them in `~/tpotce/data`:

```bash
sudo tar -czf ~/tpot-raw.tgz -C ~/tpotce data && sudo chown "$USER" ~/tpot-raw.tgz
scp -i ~/.ssh/google_compute_engine -P 64295 <os-user>@<vm-ip>:~/tpot-raw.tgz ~/Projects/tpot-data/<region>/
```

## 6. Collection window

| Instance | Start | End | Note |
|---|---|---|---|
| Europe | 1 October 2026 | 29 October 2026, at the start time of day | Four weeks, planned to offset the gaps |
| United States | 1 October 2026 | 29 October 2026, at the start time of day | Four weeks, planned to offset the gaps |
| Asia (optional) | 15 October 2026 | 29 October 2026, at the start time of day | Two weeks; not part of the required comparison |

Compare Europe and the United States over the hours in which both recorded events, and give rates per recorded hour. The gaps are in the report, Section 2 and Table D1.

## 7. Export the raw files

The honeypot folders hold the files that the events refer to: downloaded files, SSH session recordings, Dionaea binaries and streams, and Honeytrap attack captures. The Elasticsearch export does not include them. Treat every file as hostile: hash it and analyse it, but never run it.

1. On the VM, check the sizes:

   ```bash
   cd ~/tpotce/data && du -sh cowrie/downloads cowrie/log/tty dionaea/binaries dionaea/bistreams honeytrap/attacks
   ```

2. Archive the folders with their rotated archives. The archives hold older files, so they are included:

   ```bash
   cd ~/tpotce/data && tar -czf ~/tpot-raw-files.tgz cowrie/downloads cowrie/downloads.tgz* cowrie/log/tty dionaea/binaries dionaea/binaries.tgz* dionaea/bistreams dionaea/bistreams.tgz* honeytrap/attacks honeytrap/attacks.tgz* honeytrap/downloads
   ```

   If `tar` reports `Permission denied`, run it with `sudo`, then run `sudo chown "$USER" ~/tpot-raw-files.tgz`.

3. Record the hash and the number of entries on the VM:

   ```bash
   sha256sum ~/tpot-raw-files.tgz
   ```

   ```bash
   tar -tzf ~/tpot-raw-files.tgz | wc -l
   ```

4. Copy the archive to the laptop, outside the repository:

   ```bash
   scp -i ~/.ssh/google_compute_engine -P 64295 <os-user>@<vm-ip>:~/tpot-raw-files.tgz ~/Projects/tpot-data/<region>/
   ```

5. On the laptop, check that the hash matches step 3:

   ```bash
   shasum -a 256 ~/Projects/tpot-data/<region>/tpot-raw-files.tgz
   ```

6. Extract into a new, empty folder. Do not run anything from it:

   ```bash
   mkdir ~/Projects/tpot-data/<region>/raw && tar -xzf ~/Projects/tpot-data/<region>/tpot-raw-files.tgz -C ~/Projects/tpot-data/<region>/raw
   ```

## 8. Analyse the exports

Run these from the repository root on the laptop. Put the addresses to leave out, one per line, in one file for all regions, `exclude-ips.txt`. Include the addresses you used to reach the administration ports and any address that logged in with your own username (Section 2 of the report describes the case).

```bash
python3 analysis/analyse_instance.py ~/Projects/tpot-data/<region>/final/tpot-export ~/Projects/tpot-data/<region>/final/results --exclude-ips ~/Projects/tpot-data/eu/exclude-ips.txt
```

The script reads every daily file and writes CSV tables and `summary.json` to the results folder. It uses only the Python standard library. Honeypot-level events from the excluded addresses are left out of the honeypot counts. Sensor events from them stay in the totals.

For the PHP counts of Table D7, run the second script on the same export. It writes `php_probes.csv`, `php_summary.json` and `eval_stdin_paths.txt` to the results folder:

```bash
python3 analysis/php_probes.py ~/Projects/tpot-data/<region>/final/tpot-export ~/Projects/tpot-data/<region>/final/results --exclude-ips ~/Projects/tpot-data/eu/exclude-ips.txt
```

The two investigations (Sections 3.2 and 3.3 of the report) read all three exports in one run and write to one results folder outside the repository:

```bash
python3 analysis/ssh_sessions.py ~/Projects/tpot-data/investigations eu=~/Projects/tpot-data/eu/final/tpot-export us=~/Projects/tpot-data/us/final/tpot-export asia=~/Projects/tpot-data/asia/final/tpot-export --exclude-ips ~/Projects/tpot-data/eu/exclude-ips.txt
python3 analysis/php_sequences.py ~/Projects/tpot-data/investigations eu=~/Projects/tpot-data/eu/final/tpot-export us=~/Projects/tpot-data/us/final/tpot-export asia=~/Projects/tpot-data/asia/final/tpot-export --exclude-ips ~/Projects/tpot-data/eu/exclude-ips.txt
```

`ssh_sessions.py` finds the Cowrie sessions in which the attacker typed the key comment `mdrfckr` and writes `ssh_sessions.csv`, `ssh_fingerprints.csv`, `ssh_indicators.csv`, `ssh_example_session.csv` and `ssh_summary.json` (Tables 4 and 5). It compares the stored key file and the SSH client fingerprints with the values that the SANS ISC guest diary of 15 May 2026 publishes (constants at the top of the script). `php_sequences.py` groups the requests with the `libredtail` user agent into runs, finds the request sequence that most runs share and writes `php_runs.csv`, `php_example_run.csv` and `php_sequence_summary.json` (Tables 6 and 7). Neither script writes an address, the key or the body of a request.

## 9. Local Elastic stack and figures

To load an export into the local Elasticsearch for Kibana, use the same exclusion file:

```bash
python3 analysis/load_local_es.py ~/Projects/tpot-data/<region>/final/tpot-export --prefix tpot-<region> --exclude-ips ~/Projects/tpot-data/eu/exclude-ips.txt
```

The figures need matplotlib (`pip install matplotlib`). From the repository root:

```bash
python3 analysis/make_figures.py ~/Projects/tpot-data/eu/final/results ~/Projects/tpot-data/us/final/results figures --asia ~/Projects/tpot-data/asia/final/results --investigations ~/Projects/tpot-data/investigations
```

Without `--asia` the services figure (Figure 2) is skipped, and without `--investigations` the two campaign figures (Figures 4 and 5). Figure 3 is the Kibana dashboard screenshot [`screenshots/ssh-credentials-commands-dashboard.png`](screenshots/ssh-credentials-commands-dashboard.png) without the Kibana toolbar:

```bash
magick screenshots/ssh-credentials-commands-dashboard.png -crop 3420x1768+0+378 +repage -colors 256 -dither None PNG8:figures/dashboard_credentials_commands.png
```

## 10. Kibana screenshots and links

The screenshots in [`screenshots/`](screenshots/) come from a local Kibana 8.17 that reads the indices from Section 9. Create one data view for each pattern, `tpot-eu-*`, `tpot-us-*` and `tpot-asia-*`, with `@timestamp` as the time field. Set the time range to 1 October 2026 00:00:00.000 to 28 October 2026 23:59:59.999 in UTC (Advanced settings, "Timezone for date formatting"). Appendix A of the report shows each screenshot with a caption and a link to the page.

A file is named `<area>-<topic>[-<detail>]-<region>.png`. The area is `overview`, `ssh`, `php`, `sources` or `suricata`, and the region (`eu`, `us` or `asia`) is the instance whose data the page shows; a file without a region covers all three instances. In five screenshots (`php-requests-eu.png`, `php-requests-asia.png` and the three `php-wordpress-*.png`) black bars cover the `url` values of the Wordpot rows, because they hold the external address of the instance. The pages that the links open do not show that column.

The dashboard of Figure 3 is the saved Kibana dashboard `Default`: three pie charts of the six most common username and password pairs and three word clouds of the eight most typed commands, one of each for every instance. Every panel is an ES|QL query, printed under Figure 3 of the report, and the time range is the one above. The screenshot is `ssh-credentials-commands-dashboard.png`, shown as Figure A74.

The local index leaves out the web-interface records and the records from the excluded addresses, so Kibana's totals are lower than the Events column of Table 1. The honeypot counts are equal.

Kibana's default query language, KQL, is case-sensitive. The rows of Table D7 that ignore case (phpinfo and phpMyAdmin) need the Lucene language with character classes such as `[pP][hH][pP]`. Switch the language in the Query menu, the icon to the left of the "+" beside the data view picker.

### Kibana pages behind the links

Each table of the report has a line below it with the search queries, and each caption in Appendix A links to the Kibana page of its screenshot. The links are short URLs (`/goto/<id>`) to Discover with the time range 1 to 28 October 2026. Create one in Discover with Share, Copy link and Short URL, or with the short-URL API of Kibana 8.17: send `POST /api/short_url` with the header `kbn-xsrf: true` and the body `{"locatorId": "LEGACY_SHORT_URL_LOCATOR", "params": {"url": "<Discover path>"}}`. The response holds the id; `/goto/<id>` opens the page. In an ES|QL page, quote a column name that contains `@` or a hyphen with Rison quotes in the URL.

Table 1, Appendix A and Table D7 use a Discover page with the data view of the region. The Table D7 rows replace `.php` in this KQL query:

```
type:(Tanner or H0neytr4p or Honeyaml or Wordpot) and (path:*.php* or request_uri:*.php* or url:*.php*)
```

Use `eval-stdin` for the PHPUnit row, `allow_url_include` for the PHP-CGI row and `.env` for the `.env` rows, whose last row also sets the time range to 26 to 28 October. The WordPress row matches `wp-login.php` and `xmlrpc.php` in each of the three fields. The phpMyAdmin and phpinfo rows use the Lucene language with the character-class pattern of Appendix A, Evidence 3, and the needles `phpmyadmin` and `/pma/` (phpMyAdmin) or `phpinfo` and `info.php` (phpinfo). The other Appendix A pages use `eventid:cowrie.command.input and input:*mdrfckr*`, `hassh:03a80b21afa810682a776a7d42e5e6fb` and `headers.user-agent:"libredtail-http" or user-agent:"libredtail-http"`.

The tables of Sections 3.1 to 3.3, the tables of Appendix D and the hourly chart use Discover in ES|QL mode, which counts exactly. `776714` is the honeypot events of the European instance in Table 1; the United States has 982,407 and Asia 339,021. Replace `eu` with `us` or `asia` for the other regions.

- Table 3, services and ports.

  ```
  FROM tpot-eu-* | WHERE NOT type IN ("P0f","Fatt","Suricata") AND dest_port IS NOT NULL | STATS n = COUNT(*) BY type, dest_port | SORT n DESC, type ASC, dest_port ASC | LIMIT 10 | EVAL share = ROUND(n * 100.0 / 776714, 1)
  ```

- Table 4, one key-writing session (`fe6c39bd67f6` is the session of the example). The query masks the key and the new password.

  ```
  FROM tpot-us-* | WHERE session == "fe6c39bd67f6" AND eventid IN ("cowrie.session.connect", "cowrie.client.version", "cowrie.client.kex", "cowrie.login.success", "cowrie.command.input", "cowrie.session.file_download", "cowrie.session.closed") | EVAL detail = CASE(input LIKE "*mdrfckr*", "[key write]", input LIKE "*passwd*", "[password change]", input IS NOT NULL, input, version IS NOT NULL, version, hassh IS NOT NULL, hassh, shasum IS NOT NULL, shasum, username IS NOT NULL, CONCAT(username, " / ", password), "") | KEEP @timestamp, eventid, detail | SORT @timestamp
  ```

- Table 5, the SSH client fingerprints. The page of the European instance has no rows.

  ```
  FROM tpot-us-* | WHERE type == "Cowrie" | STATS n_login = COUNT(CASE(eventid == "cowrie.login.success", 1)), n_typed = COUNT(CASE(eventid == "cowrie.command.input", 1)), n_key = COUNT(CASE(input LIKE "*mdrfckr*", 1)), hassh = MAX(hassh) BY session | WHERE hassh IN ("f555226df1963d1d3c09daf865abdc9a", "03a80b21afa810682a776a7d42e5e6fb", "af8223ac9914f509afdadfaf5f7ee94e") | STATS sessions = COUNT(*), logged_in = COUNT(CASE(n_login > 0, 1)), typed_commands = COUNT(CASE(n_typed > 0, 1)), key_writing = COUNT(CASE(n_key > 0, 1)) BY hassh | SORT sessions DESC
  ```

- Table 5, the stored files of the United States and Asian instances.

  ```
  FROM tpot-us-* | WHERE eventid == "cowrie.session.file_download" | STATS sessions = COUNT_DISTINCT(session) BY shasum | SORT sessions DESC | LIMIT 5
  ```

- Table 6, the requests of one libredtail run. The time window holds the 49 requests of one address and the page shows no address.

  ```
  FROM tpot-eu-* | WHERE type == "Tanner" AND `headers.user-agent` == "libredtail-http" AND @timestamp >= "2026-10-02T01:14:40Z" AND @timestamp <= "2026-10-02T01:15:30Z" | KEEP @timestamp, method, path, response_msg.response.message.detection.name | SORT @timestamp
  ```

- Table 7, the paths of the libredtail requests with the number of requests and of addresses, and the sizes of the CVE-2024-4577 bodies.

  ```
  FROM tpot-eu-*, tpot-us-*, tpot-asia-* | WHERE type == "Tanner" AND `headers.user-agent` == "libredtail-http" | STATS requests = COUNT(*), addresses = COUNT_DISTINCT(src_ip) BY path | SORT addresses DESC, requests DESC | LIMIT 60
  FROM tpot-eu-*, tpot-us-*, tpot-asia-* | WHERE type == "H0neytr4p" AND request_uri LIKE "*allow_url_include*" | STATS requests = COUNT(*), addresses = COUNT_DISTINCT(src_ip) BY `header_content-length` | SORT addresses DESC
  ```

- Table D3, countries. Use `geoip.as_org` instead of `geoip.country_name` for the autonomous systems.

  ```
  FROM tpot-eu-* | WHERE NOT type IN ("P0f","Fatt","Suricata") | STATS n = COUNT(*) BY geoip.country_name | SORT n DESC | LIMIT 5 | EVAL share = ROUND(n * 100.0 / 776714, 1)
  ```

- Table D4, password pairs. The query leaves out empty passwords, as the table does.

  ```
  FROM tpot-eu-* | WHERE type == "Cowrie" AND password != "" | STATS n = COUNT(*) BY username, password | SORT n DESC, username ASC, password ASC | LIMIT 6
  ```

- Table D5, typed commands. The query replaces the key-writing command with a label, so that the key does not appear on the page.

  ```
  FROM tpot-eu-* | WHERE eventid == "cowrie.command.input" | EVAL command = CASE(input LIKE "*mdrfckr*", "[key write]", input) | STATS n = COUNT(*) BY command | SORT n DESC, command ASC | LIMIT 8
  ```

- Table D6, attack signatures. The query leaves out the engine notices, whose names start with SURICATA.

  ```
  FROM tpot-eu-* | WHERE type == "Suricata" AND alert.signature IS NOT NULL AND NOT alert.signature LIKE "SURICATA*" | STATS n = COUNT(*) BY alert.signature | SORT n DESC, alert.signature ASC | LIMIT 5
  ```

- Table D6, CVE-named alerts.

  ```
  FROM tpot-eu-* | WHERE type == "Suricata" AND alert.signature LIKE "*CVE-*" | STATS n = COUNT(*) BY alert.signature | SORT n DESC, alert.signature ASC | LIMIT 5
  ```

- Hourly chart of the three instances (Figure A7). The chart above the rows stacks the instances.

  ```
  FROM tpot-eu-*, tpot-us-*, tpot-asia-* METADATA _index | WHERE NOT type IN ("P0f","Fatt","Suricata") | EVAL region = CASE(_index LIKE "tpot-eu-*", "Europe", _index LIKE "tpot-us-*", "United States", "Asia") | STATS n = COUNT(*) BY hour = BUCKET(@timestamp, 1 hour), region | SORT hour | LIMIT 5000
  ```
