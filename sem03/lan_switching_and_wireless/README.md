# LAN Switching and Wireless

**Module:** LAN Switching and Wireless (`COMP H2015`)  
**Semester:** 3 (Year 2), folder `sem03`  
**Lecturer:** Aoife Fox  
**Date:** September - December 2024  
**Credits:** 5 ECTS  

## What this module is for

LAN Switching and Wireless is the second-year Cisco networking module (Cisco NetAcad, Switching, Routing and Wireless Essentials). It covers switching technologies and router operations for small and medium business networks: VLANs and trunking, Spanning Tree Protocol, EtherChannel, LAN security threats and switch security (port security, DHCP snooping), wireless LANs with a wireless router and a wireless LAN controller, first-hop redundancy with HSRP, static and default routes (IPv4 and IPv6), troubleshooting routes, and single-area and advanced OSPFv2. Each week has a lecture and a lab, and each lab is either a Cisco Packet Tracer activity or a hands-on lab on real switches and routers (labs 0, 2, 4, 7 and 10). This folder has the lab sheets as PDFs, the Packet Tracer files (the starting activity and, for labs 1, 3, 5, 6, 8 and 9, the file after the lab), a Cisco command help sheet, the practice skills assessment for CA 2 and screenshots. Packet Tracer saves files in an encrypted format, so the .pka files open only in Packet Tracer. The grade is labs (30%), four grouped NetAcad exams (10%), CA 1, a theory test in week 12 (30%), and CA 2, a skills exam in January (30%); the tests and exams are not in the repository, only the practice skills assessment.

## Grades Breakdown

| Assessment Type | Weighting |
|---|---|
| Labs | 30% |
| Grouped NetAcad exams (4) | 10% |
| CA 1: theory test during the lecture (week 12) | 30% |
| CA 2: skills exam (January) | 30% |

## Assessments

There are no assessment files: the NetAcad exams, CA 1 and CA 2 are not in the repository; the practice skills assessment for CA 2 is in [`resources/sample_exams/`](resources/sample_exams/). CA 1 was a theory test in the lecture of week 12, Tuesday 10 December 2024 (30%), taken as a quiz in Brightspace with the LockDown Browser. It was a closed-book test with no access to online resources and no Brightspace or Internet materials, and Brightspace logs were checked. Mobile phones had to be locked away in bags. The test lasted one hour: 5 minutes to log in and 55 minutes to complete the exam, and there was only one opportunity to take it. CA 2 was a skills exam in January 2025 (30%, details given closer to the time).

## All weeks

| Week | Title | Files | Screenshot |
|---|---|---|---|
| [Week 1](week01/) | Lab 0: revision, configure VLANs and trunking (hardware) | [`lab/lan_switching_and_wireless_week01_lab_revision_configure_vlans_and_trunking.pdf`](week01/lab/lan_switching_and_wireless_week01_lab_revision_configure_vlans_and_trunking.pdf)<br>[`resources/cisco_basic_commands_help_sheet.pdf`](week01/resources/cisco_basic_commands_help_sheet.pdf) | <img src=".screenshots/week01/screenshot.png" width="160" alt="Week 1 screenshot"> |
| [Week 2](week02/) | Lab 1: investigate STP loop prevention (Packet Tracer) | [`lab/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention.pdf`](week02/lab/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention.pdf)<br>[`lab/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention.pka`](week02/lab/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention.pka)<br>[`lab/solution/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention_solution.pka`](week02/lab/solution/lan_switching_and_wireless_week02_lab_investigate_stp_loop_prevention_solution.pka) | <img src=".screenshots/week02/screenshot.png" width="160" alt="Week 2 screenshot"> |
| [Week 3](week03/) | Lab 2: implement EtherChannel (hardware, with a Packet Tracer activity) | [`lab/lan_switching_and_wireless_week03_lab_implementing_etherchannel.pdf`](week03/lab/lan_switching_and_wireless_week03_lab_implementing_etherchannel.pdf)<br>[`lab/lan_switching_and_wireless_week03_lab_configure_etherchannel.pka`](week03/lab/lan_switching_and_wireless_week03_lab_configure_etherchannel.pka) | <img src=".screenshots/week03/screenshot.png" width="160" alt="Week 3 screenshot"> |
| [Week 4](week04/) | Lab 3: implement port security (Packet Tracer) | [`lab/lan_switching_and_wireless_week04_lab_implement_port_security.pdf`](week04/lab/lan_switching_and_wireless_week04_lab_implement_port_security.pdf)<br>[`lab/lan_switching_and_wireless_week04_lab_implement_port_security.pka`](week04/lab/lan_switching_and_wireless_week04_lab_implement_port_security.pka)<br>[`lab/solution/lan_switching_and_wireless_week04_lab_implement_port_security_solution.pka`](week04/lab/solution/lan_switching_and_wireless_week04_lab_implement_port_security_solution.pka) | <img src=".screenshots/week04/screenshot.png" width="160" alt="Week 4 screenshot"> |
| [Week 5](week05/) | Lab 4: switch security configuration (hardware, with a Packet Tracer file) | [`lab/lan_switching_and_wireless_week05_lab_switch_security_configuration.pdf`](week05/lab/lan_switching_and_wireless_week05_lab_switch_security_configuration.pdf)<br>[`lab/lan_switching_and_wireless_week05_lab_switch_security_configuration.pka`](week05/lab/lan_switching_and_wireless_week05_lab_switch_security_configuration.pka) | <img src=".screenshots/week05/screenshot.png" width="160" alt="Week 5 screenshot"> |
| [Week 6](week06/) | Lab 5: configure a wireless network for SOHO (Packet Tracer) | [`lab/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho.pdf`](week06/lab/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho.pdf)<br>[`lab/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho.pka`](week06/lab/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho.pka)<br>[`lab/solution/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho_solution.pka`](week06/lab/solution/lan_switching_and_wireless_week06_lab_configure_a_wireless_network_for_soho_solution.pka) | <img src=".screenshots/week06/screenshot.png" width="160" alt="Week 6 screenshot"> |
| [Week 7](week07/) | Lab 6: configure a WLAN on the WLC (Packet Tracer) | [`lab/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc.pdf`](week07/lab/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc.pdf)<br>[`lab/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc.pka`](week07/lab/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc.pka)<br>[`lab/solution/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc_solution.pka`](week07/lab/solution/lan_switching_and_wireless_week07_lab_configure_a_wlan_on_the_wlc_solution.pka) | <img src=".screenshots/week07/screenshot.png" width="160" alt="Week 7 screenshot"> |
| [Week 8](week08/) | Lab 7: HSRP and static routes (hardware, with Packet Tracer files) | [`lab/lan_switching_and_wireless_week08_lab_configuring_hsrp_and_static_routing.pdf`](week08/lab/lan_switching_and_wireless_week08_lab_configuring_hsrp_and_static_routing.pdf)<br>[`lab/lan_switching_and_wireless_week08_lab_hot_standby_router_protocol_(hsrp)_configuration.pka`](week08/lab/lan_switching_and_wireless_week08_lab_hot_standby_router_protocol_%28hsrp%29_configuration.pka)<br>[`lab/lan_switching_and_wireless_week08_lab_configure_ipv4_and_ipv6_static_and_default_routes.pka`](week08/lab/lan_switching_and_wireless_week08_lab_configure_ipv4_and_ipv6_static_and_default_routes.pka) | <img src=".screenshots/week08/screenshot_1.png" width="160" alt="Week 8 screenshot"> |
| [Week 9](week09/) | Lab 8: troubleshoot static and default routes (Packet Tracer) | [`lab/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes.pdf`](week09/lab/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes.pdf)<br>[`lab/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes.pka`](week09/lab/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes.pka)<br>[`lab/solution/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes_solution.pka`](week09/lab/solution/lan_switching_and_wireless_week09_lab_troubleshoot_static_and_default_routes_solution.pka) | <img src=".screenshots/week09/screenshot.png" width="160" alt="Week 9 screenshot"> |
| [Week 10](week10/) | Lab 9: single-area OSPFv2 (Packet Tracer) | [`lab/lan_switching_and_wireless_week10_lab_single_area_ospfv2.pdf`](week10/lab/lan_switching_and_wireless_week10_lab_single_area_ospfv2.pdf)<br>[`lab/lan_switching_and_wireless_week10_lab_single_area_ospfv2.pka`](week10/lab/lan_switching_and_wireless_week10_lab_single_area_ospfv2.pka)<br>[`lab/solution/lan_switching_and_wireless_week10_lab_single_area_ospfv2_solution.pka`](week10/lab/solution/lan_switching_and_wireless_week10_lab_single_area_ospfv2_solution.pka) | <img src=".screenshots/week10/screenshot.png" width="160" alt="Week 10 screenshot"> |
| [Week 11](week11/) | Lab 10: advanced OSPFv2 (hardware, with a Packet Tracer activity) | [`lab/lan_switching_and_wireless_week11_lab_configure_single_area_ospfv2_using_cisco_hardware.pdf`](week11/lab/lan_switching_and_wireless_week11_lab_configure_single_area_ospfv2_using_cisco_hardware.pdf)<br>[`lab/lan_switching_and_wireless_week11_lab_advanced_ospfv2.pka`](week11/lab/lan_switching_and_wireless_week11_lab_advanced_ospfv2.pka) | <img src=".screenshots/week11/screenshot_1.png" width="160" alt="Week 11 screenshot"> |
| Week 12 | CA 1: theory test | None. CA 1 was a quiz in the lecture on Tuesday 10 December 2024 (30%); see the assessments above. | — |

## Resources

| File | What it contains |
|---|---|
| [`resources/sample_exams/lan_switching_and_wireless_practice_skills_assessment.pka`](resources/sample_exams/lan_switching_and_wireless_practice_skills_assessment.pka) | The Packet Tracer activity of the practice skills assessment, the practice for the January skills exam (CA 2). The tasks are in the instructions file below. |
| [`resources/sample_exams/lan_switching_and_wireless_practice_skills_assessment_instructions.pdf`](resources/sample_exams/lan_switching_and_wireless_practice_skills_assessment_instructions.pdf) | The instructions of the practice skills assessment (6 pages, converted from the Word file with pandoc, so the layout differs from the original; the text, the tables and the two pictures are the same): the topology and the addressing table (routers R1 to R3, switches S1 and S2, PC-A and PC-B) and five parts worth 100 points: basic device settings (52 points, 45 minutes), LAN redundancy and link aggregation with HSRP and an LACP EtherChannel (19 points, 10 minutes), OSPFv2 dynamic routing (20 points, 30 minutes), the verification of the network connectivity and the HSRP configuration, and the pilot wireless network on 2.4 GHz with WPA2 (9 points, 10 minutes). |

### Schedule

The course outline for Autumn 2024, by week. The weeks are the outline's teaching weeks, so weeks 1 to 11 link to the week folders; the reading week and the breaks have no week number. Its week commencing dates are Tuesdays (17 September, 24 September and so on up to 10 December, and 17 and 24 December for the Christmas break), apart from the reading week, which is printed "28h Oct" (a Monday). The table has the Mondays of the weeks, and the two CA 2 rows have the dates printed in the outline. The outline marks each lab PT or HW; the table writes them as Packet Tracer and hardware.

| Week | Session | Week Date |
|---|---|---|
| [Week 1](week01/) | Lecture 1: module introduction and revision<br>Lab 0: revision, VLANs (hardware) | 16 September 2024 |
| [Week 2](week02/) | Lecture 2: Spanning Tree Protocol (STP)<br>Lab 1: investigate STP operation (Packet Tracer) | 23 September 2024 |
| [Week 3](week03/) | Lecture 3: EtherChannel<br>Lab 2: implement EtherChannel (hardware) | 30 September 2024 |
| [Week 4](week04/) | Lecture 4: LAN security concepts<br>Lab 3: port security (Packet Tracer) | 7 October 2024 |
| [Week 5](week05/) | Lecture 5: switch security configuration<br>Lab 4: switch security (hardware) | 14 October 2024 |
| [Week 6](week06/) | Lecture 6: WLAN concepts<br>Lab 5: basic WLAN (Packet Tracer) | 21 October 2024 |
| No week | Reading / revision week | 28 October 2024 |
| [Week 7](week07/) | Lecture 7: WLAN configuration<br>Lab 6: advanced WLAN configuration (Packet Tracer) | 4 November 2024 |
| [Week 8](week08/) | Lecture 8: HSRP and static routes, IPv4 and IPv6<br>Lab 7: HSRP and static routes (hardware) | 11 November 2024 |
| [Week 9](week09/) | Lecture 9: troubleshoot static and default routes<br>Lab 8: troubleshoot static and default routes (Packet Tracer) | 18 November 2024 |
| [Week 10](week10/) | Lecture 10: single-area OSPFv2 concepts<br>Lab 9: single-area OSPFv2 (Packet Tracer) | 25 November 2024 |
| [Week 11](week11/) | Lecture 11: advanced OSPF<br>Lab 10: advanced OSPFv2 (hardware) | 2 December 2024 |
| Week 12 | CA 1: theory test during the lecture (30%), Tuesday 10 December | 9 December 2024 |
| No week | Christmas break | 16 and 23 December 2024 |
| No week | CA 2: skills exam (30%, details closer to the time) | 2 January 2025 |
| No week | CA 2: skills exam (30%, details closer to the time) | 10 January 2025 |

The four grouped NetAcad exams (10%) cover topics 5 and 6 (redundant networks), topics 10 to 13 (L2 security and WLANs), topics 14 to 16 (routing with static routes) and topics 1 and 2 of ENSA (OSPF concepts and configurations); the outline does not give their weeks.
