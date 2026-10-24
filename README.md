# Network Security: Open Source Firewalls Assignment

**Module:** Network Security (`DFCS H3015`)  
**Programme:** BSc in Computing in Digital Forensics & Cyber Security, Year 3, TU Dublin Blanchardstown  
**Lecturer:** Peter Alexander  
**Group:** Danyil Tymchuk, Illia Stefanovskyi and Artem Surzhenko  
**Weight:** 35% of the continuous assessment (CA 1)  
**Mark:** 29.5 out of 35 (the weight of CA 1)  
**Given out:** 30 January 2026  
**Report due:** 23:59 on Saturday 28 February 2026, uploaded to Brightspace  
**Presentation and demo:** Monday and Tuesday 2 and 3 March 2026, in the assigned lab session  
**Brief:** [`assessment/01/network_security_assessment.pdf`](https://github.com/DanyilT/projects-in-university/blob/main/sem06/network_security/assessment/01/network_security_assessment.pdf) on `main`  
**Module folder on `main`:** [`sem06/network_security`](https://github.com/DanyilT/projects-in-university/tree/main/sem06/network_security)

## The assignment

CA 1 asks for research on two open source firewalls (three in a group of three), one of them nftables, their implementation and configuration in a realistic testbed, tests of their effectiveness, a comparison and an analysis of the results. The deliverables are a report, a presentation of 5 minutes and a demonstration of 7 minutes in the lab. The group tested three firewalls: nftables, pfSense and OPNsense.

## The project

The scenario is SmallCorp Inc., a fictional small company with public web services, internal workstations and a need for strict network segmentation. The testbed has four virtual machines: a WAN machine that plays the attacker (192.168.1.10), the firewall (192.168.1.1, 10.0.1.1 and 172.16.1.1), a DMZ web server (10.0.1.10) and a LAN client (172.16.1.10). The requirements are zone isolation (the DMZ and the WAN cannot reach the LAN), controlled access (the WAN can reach only the HTTP port of the DMZ server), internet access through NAT for the LAN and limited access for the DMZ, protection of the services, resistance to port scans, connection floods and reconnaissance, logging, and the default credentials of the firewall changed and its management limited to the LAN.

The same rules were built on the three firewalls. The nftables ruleset has a default-deny policy with input, forward and output chains, DNAT and SNAT, rate-limited SSH and logging; pfSense and OPNsense were configured with port forwarding, the WAN, LAN and DMZ rules, the anti-lockout rule and logging. The tests are in five groups: zone isolation, service access control, NAT, attack resistance (port scan, connection flood and anti-spoofing) and administrative access. The comparison finds the three firewalls mostly identical in the tests; the difference is the answer to an nmap SYN stealth scan, where pfSense hides the configuration by blocking the source address temporarily (the synproxy state), and nftables and OPNsense do not. The report also compares the learning curve, the base system, the management, the performance and the typical use of the three.

## Documents on Google Docs and Slides

The documents were written in Google Docs and Google Slides, and the PDF files of this branch are the exports.

| Document | Link |
|---|---|
| Report (Google Docs) | [Report](https://docs.google.com/document/d/1fFeqfK8LRe8g9JcCvHOjtCSHhAK_xKeRjkyIi6MCrdk) ([published version](https://docs.google.com/document/d/e/2PACX-1vQn-eL18elJUSO_6nXKJhFuctEQAM0yB_C1GYeSl26nXoeb-MWYmTtCejqD6nBke4RoDCXB9l9rzxMQ/pub)) |
| Presentation and demo (Google Slides) | [Slides](https://docs.google.com/presentation/d/1W5w1hv1JJR1bZmUUN6l4PD5dJ3CNlEgPWLc19jhpp-4) ([published version](https://docs.google.com/presentation/d/e/2PACX-1vQkcNyb_jWf0XWzwvy8czvnXIQBJ4po1PBxN1C8WK6RU10l5EnfS0QEyMFyIReQqQPQ-vLQP_iCun6v/pub)) |

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`network_security_report.pdf`](network_security_report.pdf) | The report (63 pages): the cover page, the submission coversheet and the declaration, the scenario and the network topology, the test plan, one chapter for each firewall (nftables, pfSense and OPNsense) with its configuration, tests and strengths and limitations, the firewall comparison, the references and two appendices: the comprehensive test plan with the commands of every test, and the commands and the configuration of nftables. |
| [`network_security_demo.pdf`](network_security_demo.pdf) | The presentation and demo (32 slides, 28 February 2026): the explanation of the setup and the constraints, the configuration of the three firewalls, the tests and their results (zone isolation, service access control, NAT, attack resistance and administrative access), the firewall comparison and the references. |
