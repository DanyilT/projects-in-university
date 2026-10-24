# Network Security

**Module:** Network Security (`DFCS H3015`)  
**Semester:** 6 (Year 3), folder `sem06`  
**Lecturer:** Peter Alexander  
**Date:** January - May 2026  
**Matching project branch:** none

## What this module is for

Network Security is the third-year module that introduces the core network security technologies and shows how to develop security policies and mitigate risks: securing routers and switches and their networks, with the installation, troubleshooting and monitoring of network devices to maintain the integrity, confidentiality and availability of data and devices, and the technologies that underpin a secure network. The eleven lectures go through the introduction to network security, network threats and mitigation, firewall technologies, authentication, authorisation and accounting (AAA), device monitoring and management, secure device access (administrative roles), securing the local area network, intrusion prevention, cryptographic systems, virtual private networks and network security testing. The labs are Cisco Packet Tracer activities (labs 1 to 4, 5 part 2, 6 and 7), two hardware labs on real switches and routers (lab 5 in room E124 and lab 7 in room E125) and, first, a lab on virtual networking with VirtualBox virtual machines (lab 0). The week folders follow the lecture numbers: lecture N was in week N. This folder holds the lab instruction files (Word, and a PDF for lab 0 and the lab 2 FAQ), the Packet Tracer starting activities, the CA 1 brief and the course outline. Packet Tracer saves files in an encrypted format, so the .pka files open only in Packet Tracer. The module is continuous assessment: labs 15% and lectures 5%, CA 1 (the open source firewalls assignment, 35% of the CA), CA 2 (a theory test, 20%) and CA 3 (a lab test, 25%).

## Grades Breakdown

| Assessment Type | Weighting |
|---|---|
| Labs (labs 0 to 7) | 15% |
| Lectures | 5% |
| CA 1: open source firewalls assignment (group of 2 to 3, report due 28 February 2026, presentations and demonstrations on 2 and 3 March 2026) | 35% |
| CA 2: theory test (week 10) | 20% |
| CA 3: lab test (week 12) | 25% |

The weights are from the course outline in [`resources/network_security_learning_plan.xlsx`](resources/network_security_learning_plan.xlsx) (Spring 2026).

## All weeks

| Week | Title | Files | Screenshot |
|---|---|---|---|
| Week 1 | Introduction to the module (lecture 1) | None. No lab. | — |
| [Week 2](week02/) | Lab 0: networking VMs (VirtualBox) | [`lab/network_security_week02_lab.pdf`](week02/lab/network_security_week02_lab.pdf) | — |
| [Week 3](week03/) | Lab 1: revision of subnetting, routing and ACLs (Packet Tracer) | [`lab/network_security_week03_lab_revision_subnetting_routing_and_acls.pka`](week03/lab/network_security_week03_lab_revision_subnetting_routing_and_acls.pka) | — |
| [Week 4](week04/) | Lab 2: configure packet filter firewalls to mitigate attacks (Packet Tracer) | [`lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.docx`](week04/lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.docx)<br>[`lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.pka`](week04/lab/network_security_week04_lab_configure_packet_filter_firewalls_to_mitigate_attacks.pka)<br>[`lab/network_security_week04_lab_faq.pdf`](week04/lab/network_security_week04_lab_faq.pdf) | — |
| [Week 5](week05/) | Lab 3: zone-based firewalls and AAA authentication on routers (Packet Tracer) | [`lab/network_security_week05_lab_configuring_a_zone_based_policy_firewall_zpf.docx`](week05/lab/network_security_week05_lab_configuring_a_zone_based_policy_firewall_zpf.docx)<br>[`lab/network_security_week05_lab_configuring_a_zone_based_policy_firewall_zpf.pka`](week05/lab/network_security_week05_lab_configuring_a_zone_based_policy_firewall_zpf.pka)<br>[`lab/network_security_week05_lab_configuring_aaa_authentication_on_routers.docx`](week05/lab/network_security_week05_lab_configuring_aaa_authentication_on_routers.docx)<br>[`lab/network_security_week05_lab_configuring_aaa_authentication_on_routers.pka`](week05/lab/network_security_week05_lab_configuring_aaa_authentication_on_routers.pka) | — |
| Week 6 | Secure device access (lecture 6) and CA 1 presentations and demonstrations | None. See CA 1 below. | — |
| [Week 7](week07/) | Lab 4: OSPF authentication, NTP, syslog and SSH (Packet Tracer) | [`lab/network_security_week07_lab_configuring_ospf_authentication_ntp_syslog_and_ssh.docx`](week07/lab/network_security_week07_lab_configuring_ospf_authentication_ntp_syslog_and_ssh.docx)<br>[`lab/network_security_week07_lab_configuring_ospf_authentication_ntp_syslog_and_ssh.pka`](week07/lab/network_security_week07_lab_configuring_ospf_authentication_ntp_syslog_and_ssh.pka) | — |
| [Week 8](week08/) | Lab 5: LAN security (hardware) and STP and CAM table attacks (Packet Tracer) | [`lab/network_security_week08_lab_configure_lan_security_hardware_lab.docx`](week08/lab/network_security_week08_lab_configure_lan_security_hardware_lab.docx)<br>[`lab/network_security_week08_lab_mitigating_against_stp_manipulation_and_cam_table_attacks.docx`](week08/lab/network_security_week08_lab_mitigating_against_stp_manipulation_and_cam_table_attacks.docx)<br>[`lab/network_security_week08_lab_mitigating_against_stp_manipulation_and_cam_table_attacks.pka`](week08/lab/network_security_week08_lab_mitigating_against_stp_manipulation_and_cam_table_attacks.pka) | — |
| [Week 9](week09/) | Lab 6: intrusion prevention system using Cisco IOS (Packet Tracer) | [`lab/network_security_week09_lab_implementing_intrusion_prevention_system_ips_using_cisco_ios.docx`](week09/lab/network_security_week09_lab_implementing_intrusion_prevention_system_ips_using_cisco_ios.docx)<br>[`lab/network_security_week09_lab_implementing_intrusion_prevention_system_ips_using_cisco_ios.pka`](week09/lab/network_security_week09_lab_implementing_intrusion_prevention_system_ips_using_cisco_ios.pka) | — |
| Week 10 | Virtual private networks (lecture 10) and CA 2, the theory test | None. | — |
| [Week 11](week11/) | Lab 7: site-to-site VPN (hardware and Packet Tracer) | [`lab/network_security_week11_lab_configure_a_site_to_site_vpn_hardware_lab.docx`](week11/lab/network_security_week11_lab_configure_a_site_to_site_vpn_hardware_lab.docx)<br>[`lab/network_security_week11_lab_configuring_a_site_to_site_vpn.docx`](week11/lab/network_security_week11_lab_configuring_a_site_to_site_vpn.docx)<br>[`lab/network_security_week11_lab_configuring_a_site_to_site_vpn.pka`](week11/lab/network_security_week11_lab_configuring_a_site_to_site_vpn.pka) | — |
| Week 12 | Revision (no lecture) and CA 3, the lab test | None. | — |
| Week 13 | Revision week | None. | — |

## Assessments and other files

CA 1 is the Open Source Firewalls Assignment (35% of the CA, a group of 2 to 3, given out on 30 January 2026, report due at 23:59 on Saturday 28 February 2026 on Brightspace, presentations and demonstrations in the assigned lab session on Monday and Tuesday 2 and 3 March 2026): research and test two open source firewalls (three in a group of three), one of which must be nftables (iptables, UFW and firewalld are not accepted, nor any other front end of them), implement and configure them in a realistic testbed, design tests of their effectiveness, compare them and analyse the results. The deliverables are a report (at most 2,500 words for a group of two and 3,000 for a group of three, Harvard referencing), a presentation of 5 minutes and a demonstration of 7 minutes in the lab (possibly 5), and the three components are all mandatory. The marking scheme is background research 10%, effective configuration of the firewall rules and demonstration of tests 15%, analysis of the results 15%, extra relevant research 10%, references and overall quality of the report 10%, the presentation 20% and the demonstration 20%. AI is not allowed (level 1, not even to generate tests or firewall rules or for the background research). The assignment lists nftables, pfSense, OPNsense, Smoothwall, Endian, IPCop and IPFire as open source firewalls. CA 2, the theory test (week 10, 20%), and CA 3, the lab test (week 12, 25%), are not in the repository.

| File | What it contains |
|---|---|
| [`assessment/01/network_security_assessment.pdf`](assessment/01/network_security_assessment.pdf) | The brief (4 pages): the School of Informatics & Cybersecurity assessment brief coversheet (module, assessment title, type, weighting, deadline, submission mechanism, late penalty and the use of AI level) and the CA1 Open Source Firewalls Assignment Specification (the outline, the deliverables, the marking scheme and the common pitfalls). |
| [`resources/network_security_learning_plan.xlsx`](resources/network_security_learning_plan.xlsx) | The course outline, Network Security Y3, Spring 2026 (spreadsheet): for each of the 13 weeks the week commencing date, the lecture, the lab and the CA, with the weights of the CAs. |

---

## Schedule (Spring 2026)

From the course outline:

| Week | Week commencing | Lecture | Lab | CA |
|---|---|---|---|---|
| 1 | 26 January | L1 - Introduction to Module | No lab | Labs 15%, lectures 5% |
| 2 | 2 February | L2 - Network Threats & Mitigation | Lab 0 - Virtual Networking Tutorial | CA 1 - OS FW Assignment, 35% of the CA (weeks 2 to 5) |
| 3 | 9 February | L3 - Firewall Technologies | Lab 1 - Revision | |
| 4 | 16 February | L4 - Authentication, Authorisation & Accounting (AAA) | Lab 2 - Configure ACLs to Mitigate Attacks | |
| 5 | 23 February | L5 - Device Monitoring and Management | Lab 3 - Zone-Based Firewalls & Configuring AAA Authentication on Routers | |
| 6 | 2 March | L6 - Secure Device Access | CA 1 Presentations/Demonstrations | |
| 7 | 9 March | L7 - Securing the Local Area Network | Lab 4 - Configuring OSPF Authentication, NTP, Syslog & SSH | |
| 8 | 16 March | L8 - Implementing Intrusion Prevention | Lab 5 - Configure LAN Security | |
| 9 | 23 March | L9 - Cryptographic Systems | Lab 6 - Configure an Intrusion Prevention System (IPS) | |
| | 30 March, 6 April | Student project, reading and spring break | | |
| 10 | 13 April | L10 - Implementing Virtual Private Networks | CA 2 - Theory Test | 20% of the CA |
| 11 | 20 April | L11 - Network Security Testing | Lab 7 - Configuring a Site-to-Site VPN | |
| 12 | 27 April | Revision (no lecture) | CA 3 - Lab Test | 25% of the CA |
| 13 | 4 May | Revision week | | |

## Links

- The VirtualBox and Xubuntu downloads of Lab 0: https://www.virtualbox.org and https://xubuntu.org/download/
