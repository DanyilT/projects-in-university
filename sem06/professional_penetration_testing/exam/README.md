# Exam — the practical penetration test

**Module:** Professional Penetration Testing (`DFCS H3014`)  
**Semester:** 6 (Year 3), folder `sem06`

[Module README](../README.md)

## The exam

The exam is 80% of the module (20% theory, 60% practical). It was held on 18 and 19 May 2026 in four groups (9:00 to 13:00 and 14:00 to 18:00). The afternoon sitting of 18 May 2026 (14:00 to 18:00) had two parts:

| Part | Time | Weighting | Format | Mark |
|---|---|---|---|---|
| Theory | 14:00 - 15:00 | 20% | 50 multiple choice questions, based on the PTES book and PenTest+ | 18 out of 20 |
| Practical | 15:00 - 18:00 | 60% | a simulated penetration test of a small company network, wired and wireless | 56.7 out of 60 |

The practical had four sections: reconnaissance (15%), wireless (15%), scanning (15%) and access (55%: root access to three machines of increasing difficulty, an easy one for 15%, a medium one for 15% and a hard one for 25%). The marks written on the exam sheet add up to 93.5 of 99 (the parts of question 3 add up to 14 marks, although the section is listed as 15%), which is 56.7 of 60. The exam sheet, recreated from photographs of the printed sheets, is [`exam_sheet_with_answers.pdf`](exam_sheet_with_answers.pdf).

### Rules of engagement

The rules of engagement of the practical, from the exam sheet:

- The target network is 10.10.10.0/24. Every address from 10.10.10.150 upwards and every address from 10.10.10.100 downwards is out of bounds, so the in-scope targets are 10.10.10.101 to 10.10.10.149.
- Only targets on the target network may be scanned. Scanning or attacking any other part of the infrastructure gives zero for the practical exam, even if it is accidental.
- In the Wi-Fi part, de-authentication and packet injection are strictly not allowed; an attempt loses all the wireless marks.
- Each examinee had a static IP address for the practical, in the range 10.10.10.150 to 10.10.10.236; the one used in the exam work of this module was 10.10.10.174.

## What this folder is for

The work of the practical part of the exam and of the pre-exam session before it. [`notes.md`](notes.md) has the questions of the exam sheet with the commands used and the results, and the folders hold the evidence of each section: screenshots, the Nmap, Nessus and OpenVAS output and the wireless captures. The Nmap host discovery and scan and the OpenVAS scan are from the pre-exam session of 5 May 2026; the Nessus and OpenVAS reports and their screenshots are dated 15 May 2026; the reconnaissance, wireless and access files are dated 18 May 2026. The dates below are the dates of the files.

## Recordings

The screen recordings are too big for the repository, so they are stored on MEGA. They show the screen of the Kali virtual machine (3420 x 2146 pixels) during the pre-exam session and the practical. The files without "uncut" in the name leave out the stretches where the screen is black, with or without the mouse cursor (the virtual machine window was not on screen): 49 minutes of the exam recording and 98 seconds of the pre-exam recording. They are re-encoded (H.264), which makes them smaller; the uncut file is the exam recording as it was made. The recordings of the whole module are listed in [Screen recordings](../README.md#screen-recordings) of the module README.

| Recording (file name) | Date | Length | Size | Download |
|---|---|---|---|---|
| Exam (exam_recording_2026-05-18.mov) | 18 May 2026, 15:10 | 1h 19min | 594 MB | [MEGA](https://mega.nz/file/aoo21CQb#PoQL7mEmuLGYi57QVE3JQqABAX6sLKXQqviVGwSYk5A) |
| Exam, uncut (exam_recording_2026-05-18_uncut.mov) | 18 May 2026, 15:10 | 2h 8min | 1.66 GB | [MEGA](https://mega.nz/file/X5Qm2b6I#rr3EjXMUfIlXSfdprOnTU8WvjoL7QjhCw7V9L9rMfFQ) |
| Pre-exam session (pre_exam_recording_2026-05-05.mov) | 5 May 2026, 14:18 | 1h 7min | 619 MB | [MEGA](https://mega.nz/file/2kgnEZCI#UFPeLfvhvWbuVpocFiPVcAPDU-STLlc6vDgbP8qqZFI) |

## Files

### Notes

| File | What it contains |
|---|---|
| [`exam_sheet_with_answers.pdf`](exam_sheet_with_answers.pdf) | The exam sheet recreated from photographs of the five printed sheets (5 pages): the rules and the questions of the four sections as printed, the answers highlighted in yellow (corrected and extended in places afterwards), the marks of the instructor in the boxes with the total of each page, and two light blue notes that explain marks (1c and 3c). The answer to question 1d, the lecturer's personal social media handles, is left out, and the name and number lines at the top are blank. |
| [`notes.md`](notes.md) | The exam notes (253 lines): the questions of the exam sheet by section (theory, reconnaissance, wireless, scanning and access), with the commands used and the findings for each answer. |

### Reconnaissance

Five questions: the history of the domain eshopworld.com, its robots.txt, the operating system and web server of a website, the public social media profiles of the lecturer, and the IP address, hosting provider and DNS records of a university website. The evidence kept is the two Wayback Machine screenshots.

| File | What it contains |
|---|---|
| [`reconnaissance/eshopworld.com.png`](reconnaissance/eshopworld.com.png) | Screenshot (3420 x 2146) of the Wayback Machine capture of 3 January 2007 of www.eshopworld.com/shopping/shopplan.php (13 captures from 28 June 2006 to 3 January 2007): an online shop with Korean text, an earlier use of the domain. |
| [`reconnaissance/eshopworld.com_robots.txt.png`](reconnaissance/eshopworld.com_robots.txt.png) | Screenshot (3420 x 2146) of the Wayback Machine capture of 7 August 2025 of https://www.eshopworld.com/robots.txt (4,975 captures from 8 June 2002 to 7 August 2025): the crawler rules with the WordPress admin paths and a crawl delay of 10. |

### Wireless

Two questions: the security protocol of the network "Pentest Exam" (WEP, from a capture of initialisation vectors) and of a network in a handshake capture (WPA, cracked with a wordlist), and the key of each.

| File | What it contains |
|---|---|
| [`wireless/wep/capturefile/capturefile.cap`](wireless/wep/capturefile/capturefile.cap) | The capture of the WEP network "Pentest Exam" written by airodump-ng (38,159 packets, 37.8 MB), the input for the key recovery with aircrack-ng. |
| [`wireless/wep/screenshots/airodump_ng.png`](wireless/wep/screenshots/airodump_ng.png) | Screenshot (714 x 554) of airodump-ng on wlan0 capturing the network "Pentest Exam" into the file capturefile. |
| [`wireless/wep/screenshots/aircrack_ng.png`](wireless/wep/screenshots/aircrack_ng.png) | Screenshot (714 x 554) of aircrack-ng run on the capture. |
| [`wireless/wpa/capturefile/wireless.cap`](wireless/wpa/capturefile/wireless.cap) | The capture with the WPA handshake (4,308 packets, 183 KB, dated 11:22 on the day of the exam). |
| [`wireless/wpa/screenshots/aircrack_ng.png`](wireless/wpa/screenshots/aircrack_ng.png) | Screenshot (1136 x 906) of aircrack-ng run on the handshake capture. |
| [`wireless/wpa/screenshots/aircrack_ng_rockyou.png`](wireless/wpa/screenshots/aircrack_ng_rockyou.png) | Screenshot (1136 x 906) of aircrack-ng run on the handshake capture with the wordlist rockyou.txt. |

### Scanning

The scans were run against the three active machines of the range, 10.10.10.101, 10.10.10.102 and 10.10.10.109 (the in-scope addresses are 10.10.10.101 to 10.10.10.149).

| File | What it contains |
|---|---|
| [`scanning/nmap/host_discovery.png`](scanning/nmap/host_discovery.png) | Screenshot (714 x 554) of the Nmap host discovery of 10.10.10.100 to 10.10.10.149 on 5 May 2026 (14:25): 49 addresses scanned, 3 hosts up (10.10.10.101, 10.10.10.102 and 10.10.10.109). |
| [`scanning/nmap/version_vuln_scan/nmap_vuln_targets.nmap`](scanning/nmap/version_vuln_scan/nmap_vuln_targets.nmap) | The normal output of the Nmap 7.99 scan with service versions, default scripts and the vuln scripts (-sV -sC --script vuln) of 10.10.10.101, 10.10.10.102 and 10.10.10.109, started on 5 May 2026 at 14:37. |
| [`scanning/nmap/version_vuln_scan/nmap_vuln_targets.gnmap`](scanning/nmap/version_vuln_scan/nmap_vuln_targets.gnmap) | The same scan in the grepable format. |
| [`scanning/nmap/version_vuln_scan/nmap_vuln_targets.xml`](scanning/nmap/version_vuln_scan/nmap_vuln_targets.xml) | The same scan in the XML format. |
| [`scanning/nessus_report.png`](scanning/nessus_report.png) | Screenshot (1655 x 1032, 15 May 2026) of the Nessus report. |
| [`scanning/nessus_report/pentest_exam_list_of_vulnerabilities.pdf`](scanning/nessus_report/pentest_exam_list_of_vulnerabilities.pdf) | The Nessus report as a list of the vulnerabilities (11 pages, 15 May 2026). |
| [`scanning/nessus_report/pentest_exam_list_of_vulnerabilities.html`](scanning/nessus_report/pentest_exam_list_of_vulnerabilities.html) | The same report as an HTML page. |
| [`scanning/nessus_report/pentest_exam_detailed_vulnerabilities.pdf`](scanning/nessus_report/pentest_exam_detailed_vulnerabilities.pdf) | The Nessus report with the detail of each vulnerability (228 pages, 15 May 2026). |
| [`scanning/nessus_report/pentest_exam_detailed_vulnerabilities.html`](scanning/nessus_report/pentest_exam_detailed_vulnerabilities.html) | The same report as an HTML page. |
| [`scanning/openvas_report.png`](scanning/openvas_report.png) | Screenshot (1655 x 1032, 15 May 2026) of the OpenVAS report. |
| [`scanning/openvas_report/pentest_exam_report.pdf`](scanning/openvas_report/pentest_exam_report.pdf) | The OpenVAS (Greenbone) report of the scan that ran on 5 May 2026 from 13:37 to 14:19 UTC (44 pages). |
| [`scanning/openvas_report/pentest_exam_report.csv`](scanning/openvas_report/pentest_exam_report.csv) | The same report as a table: 34 results for the 3 hosts (8 critical, 4 high, 15 medium and 7 low), with the host, port, CVSS score, severity, test name and solution of each. |
| [`scanning/openvas_report/pentest_exam_report.xml`](scanning/openvas_report/pentest_exam_report.xml) | The same report in the XML format. |
| [`scanning/openvas_report/pentest_exam_report.txt`](scanning/openvas_report/pentest_exam_report.txt) | The same report as plain text. |

### Access

Machine 1 (the easy one) is 10.10.10.101. The notes describe the steps to root access on machine 1 and on the other two machines; the screenshots kept are in the folder of machine 1.

| File | What it contains |
|---|---|
| [`access/10.10.10.101/access_box_1.png`](access/10.10.10.101/access_box_1.png) | Screenshot (714 x 554) of the SSH login to machine 1, 10.10.10.101 (Ubuntu 14.04 LTS, host name metasploitable3-ub1404), with the default account of the machine (18 May 2026). |
| [`access/10.10.10.101/privesc_box_1.png`](access/10.10.10.101/privesc_box_1.png) | Screenshot (714 x 554) of the privilege escalation on machine 1 (18 May 2026). |
| [`access/10.10.10.101/openvas_ssh_brute_force_login_with_default_credentials_reporting.png`](access/10.10.10.101/openvas_ssh_brute_force_login_with_default_credentials_reporting.png) | Screenshot (949 x 151, 15 May 2026) of the OpenVAS result "SSH Brute Force Logins With Default Credentials Reporting" for machine 1. |
