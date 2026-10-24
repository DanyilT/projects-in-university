# Week 04 — Lab 2: configure packet filter firewalls to mitigate attacks (Packet Tracer)

**Module:** Network Security (`DFCS H3015`)  
**Semester:** 6 (Year 3), folder `sem06`

[Module README](../README.md)

## What this week is for

Lecture 4 was authentication, authorisation and accounting. Lab 2 uses ACLs on the edge routers R1 and R3: access to the routers is only permitted from the Admin PC, which is also used to test connectivity to Server1 (DNS, SMTP, FTP and HTTPS services). The parts are: verify the connectivity among the devices before the firewall configuration; secure the access to the routers (ACL 10 applied to the VTY lines); a numbered ACL 105 on R1 (permit DNS, SMTP and FTP, deny HTTPS, permit SSH from the Admin PC to the WAN interface); a named extended ACL, ICMP_ACL, on R1 (permit echo replies and destination unreachable messages, deny other incoming ICMP, permit all other traffic); ACL 110 on R3 (only valid source addresses from the inside network); and ACL 100 on R3 (permit returning SSH, block the three private address ranges, 127.0.0.0/8 and 255.255.255.255). Five questions are answered in a Brightspace quiz while the lab is done, and the activity score has to reach 100%. The sheet ends with an appendix of port numbers. The FAQ answers the common problems of the lab: the ssh -l option, the order of the five rules of ACL 105, the four rules of ICMP_ACL and the rules of ACL 100.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.docx`](lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.docx) | The lab instructions (Word): Lab 2 - Configure Packet Filter Firewalls to Mitigate Attacks, with the topology, the addressing table, the objectives and the six parts. |
| [`lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.pka`](lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.pka) | The Packet Tracer activity of the lab: the starting network. Packet Tracer saves files in an encrypted format, so this file opens only in Cisco Packet Tracer and its contents are not shown in the repository. |
| [`lab/network_security_week04_lab_faq.pdf`](lab/network_security_week04_lab_faq.pdf) | The Lab 2 FAQ (1 page): questions and answers on the SSH command and on the ACL 105, ICMP_ACL and ACL 100 rules. |
