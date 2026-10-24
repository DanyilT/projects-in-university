# Professional Penetration Testing

**Module:** Professional Penetration Testing (`DFCS H3014`)  
**Semester:** 6 (Year 3), folder `sem06`  
**Lecturer:** Phillip Fitzpatrick  
**Date:** January - May 2026  
**Credits:** 10 ECTS  
**Matching project branch:** none

## What this module is for

Professional Penetration Testing is the third-year penetration testing module. It prepares for penetration testing and ethical hacking projects and is mapped to the syllabus of the CompTIA PenTest+ certification: planning and scoping, reconnaissance and footprinting, scanning and enumeration (Nmap), vulnerability scanning (Nessus and OpenVAS), exploitation with Metasploit, social engineering, password attacks, wireless attacks, attacks on the local host and privilege escalation, web and database attacks, and communication and reporting. The labs are done on a Kali Linux virtual machine in VirtualBox and on the TryHackMe platform. The lab sheets are markdown pages with an estimated time (the lecturer's lab pages), and every lab is submitted as a report with a cover page (lab, duration, module, instructor, date and submission date). The lectures were on Fridays (13:00 to 15:00), the labs on Mondays and Wednesdays in groups, and there was a drop-in tutorial each week. The week folders start at 0: week00 is the first teaching week (26 January 2026), and week09 is the week of 13 April, after the spring break. This folder holds the lab sheets, the lab reports (and the penetration test report of Lab 2b), the lab resources and the module resources (the Nmap guides and the NIST guide to security testing). The main assessment is a large practical test in exam week, a simulated penetration test on a small company network, wired and wireless: the module is 10% weekly lecture MCQ and engagement, 10% labs and 80% exam (20% theory, 60% practical). The exam is described in [The exam](#the-exam) and in [`exam/README.md`](exam/README.md), the target virtual machines of the labs are in [Target virtual machines](#target-virtual-machines) and the screen recordings in [Screen recordings](#screen-recordings).

The learning outcomes of the module: describe each of the steps in the penetration testing methodology; recognise security vulnerabilities (weak configurations, unpatched systems) and the limitations of penetration testing techniques; develop tailored scoping and rules of engagement; conduct detailed reconnaissance with document metadata, search engines and other public sources; use a scanning tool such as Nmap for network sweeps, port scans, OS fingerprinting and version scanning; configure and launch a vulnerability scanner such as Nessus safely; explore target systems for information that furthers the test, establishes pivots and shows business risk; conduct password attacks (automated guessing, traditional and rainbow table cracking, pass-the-hash); and use wireless attack tools to discover access points and clients, crack WEP, WPA and WPA2 keys and exploit client machines in scope.

The expectations: a quick pace, about 6 to 8 hours of work a week on top of the lectures and labs, and a mostly practical module. The required textbook is CompTIA PenTest+ (PT0-002), second edition, by Ray Nutting (McGraw Hill, ISBN 978-1-264-27489-5). The PenTest+ exam (version PT0-003) is 165 minutes with 85 multiple choice questions and a pass mark of 750 out of 900.

## Grades Breakdown

| Assessment Type | Weighting |
|---|---|
| Weekly lecture MCQ and engagement | 10% |
| Labs | 10% |
| Exam: theory (end-of-semester MCQ exam) | 20% |
| Exam: practical (pentest exam) | 60% |

## The exam

The exam is 80% of the module (20% theory, 60% practical) and was held on 18 and 19 May 2026. The sittings, the marks, the rules of engagement of the practical, the notes, the evidence and the screen recordings are described in [`exam/README.md`](exam/README.md).

## All weeks

| Week | Title | Files | Screenshot |
|---|---|---|---|
| [Week 0](week00/) | Lab 1: configuring the lab environment | [`lab/professional_penetration_testing_week00_lab.md`](week00/lab/professional_penetration_testing_week00_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2001%20-%20Creating%20our%20lab%20environment.md))<br>[`lab/solution/professional_penetration_testing_week00_lab_report.pdf`](week00/lab/solution/professional_penetration_testing_week00_lab_report.pdf) | — |
| [Week 1](week01/) | Labs 2 and 2a: TryHackMe and planning and engagement | [`lab/professional_penetration_testing_week01_lab.md`](week01/lab/professional_penetration_testing_week01_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2002%20-%20Getting%20started%20with%20TryHackMe%28THM%29.md))<br>[`lab/professional_penetration_testing_week01_lab_a.md`](week01/lab/professional_penetration_testing_week01_lab_a.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2002a%20-%20Planning%20and%20Engagement.md))<br>[`lab/solution/professional_penetration_testing_week01_lab_report.pdf`](week01/lab/solution/professional_penetration_testing_week01_lab_report.pdf) | — |
| [Week 2](week02/) | Lab 2b: a simulated penetration test | [`lab/professional_penetration_testing_week02_lab.md`](week02/lab/professional_penetration_testing_week02_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2002b%20-%20Basic%20Pen%20Testing%20-%20A%20Simulated%20Pen%20Test.md))<br>[`lab/solution/professional_penetration_testing_week02_lab_report.md`](week02/lab/solution/professional_penetration_testing_week02_lab_report.md)<br>[`lab/solution/professional_penetration_testing_week02_lab_report_pandoc.md`](week02/lab/solution/professional_penetration_testing_week02_lab_report_pandoc.md)<br>[`lab/solution/professional_penetration_testing_week02_lab_report.pdf`](week02/lab/solution/professional_penetration_testing_week02_lab_report.pdf)<br>[`lab/solution/img/`](week02/lab/solution/img/)<br>[`resources/running_ova_on_virtualbox.pdf`](week02/resources/running_ova_on_virtualbox.pdf) | — |
| [Week 3](week03/) | Lab 3: planning and scoping a penetration test | [`lab/professional_penetration_testing_week03_lab.pdf`](week03/lab/professional_penetration_testing_week03_lab.pdf)<br>[`lab/solution/professional_penetration_testing_week03_lab_report.pdf`](week03/lab/solution/professional_penetration_testing_week03_lab_report.pdf) | — |
| [Week 4](week04/) | Labs 4 and 5: footprinting and reconnaissance, host discovery | [`lab/professional_penetration_testing_week04_lab_footprinting_and_reconnaissance.md`](week04/lab/professional_penetration_testing_week04_lab_footprinting_and_reconnaissance.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2004%20-%20Footprinting%20%26%20Reconnaissance.md))<br>[`lab/professional_penetration_testing_week04_lab_host_discovery.md`](week04/lab/professional_penetration_testing_week04_lab_host_discovery.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2005%20-%20Host%20Discovery.md))<br>[`lab/solution/professional_penetration_testing_week04_lab_report.pdf`](week04/lab/solution/professional_penetration_testing_week04_lab_report.pdf) | — |
| [Week 5](week05/) | Lab 6: vulnerability scanners | [`lab/professional_penetration_testing_week05_lab.md`](week05/lab/professional_penetration_testing_week05_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2006%20-%20Vulnerability%20Scanners.md))<br>[`lab/solution/professional_penetration_testing_week05_lab_report.pdf`](week05/lab/solution/professional_penetration_testing_week05_lab_report.pdf)<br>[`resources/gvm_feed_owner_fix.pdf`](week05/resources/gvm_feed_owner_fix.pdf)<br>[`resources/nessus_installation_lab_guide_kali.pdf`](week05/resources/nessus_installation_lab_guide_kali.pdf)<br>[`resources/nessus_installation_lab_guide_windows.pdf`](week05/resources/nessus_installation_lab_guide_windows.pdf)<br>[`resources/openvas_installation_lab_guide.pdf`](week05/resources/openvas_installation_lab_guide.pdf) | — |
| [Week 7](week07/) | Lab 7: introduction to Metasploit | [`lab/professional_penetration_testing_week07_lab.md`](week07/lab/professional_penetration_testing_week07_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2007%20-%20Introduction%20to%20Metasploit.md))<br>[`lab/professional_penetration_testing_week07_lab_metasploitable1_instructions.pdf`](week07/lab/professional_penetration_testing_week07_lab_metasploitable1_instructions.pdf)<br>[`lab/professional_penetration_testing_week07_lab_metasploitable1_additional_exploration.html`](week07/lab/professional_penetration_testing_week07_lab_metasploitable1_additional_exploration.html)<br>[`lab/solution/professional_penetration_testing_week07_lab_report.pdf`](week07/lab/solution/professional_penetration_testing_week07_lab_report.pdf) | — |
| [Week 8](week08/) | Lab 8: attacking passwords | [`lab/professional_penetration_testing_week08_lab.md`](week08/lab/professional_penetration_testing_week08_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2008%20-%20Attacking%20Passwords.md))<br>[`lab/professional_penetration_testing_week08_lab_quick_reference.md`](week08/lab/professional_penetration_testing_week08_lab_quick_reference.md)<br>[`lab/resources/password_cracking_resources.zip`](week08/lab/resources/password_cracking_resources.zip)<br>[`lab/solution/professional_penetration_testing_week08_lab_report.pdf`](week08/lab/solution/professional_penetration_testing_week08_lab_report.pdf) | — |
| [Week 9](week09/) | Lab 9: cracking wireless passwords | [`lab/professional_penetration_testing_week09_lab.md`](week09/lab/professional_penetration_testing_week09_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2009%20-%20Cracking%20Wireless%20passwords.md))<br>[`lab/resources/capturefile.zip`](week09/lab/resources/capturefile.zip)<br>[`lab/solution/professional_penetration_testing_week09_lab_report.pdf`](week09/lab/solution/professional_penetration_testing_week09_lab_report.pdf)<br>[`resources/microsoft_network_monitor_student_lab.pdf`](week09/resources/microsoft_network_monitor_student_lab.pdf) | — |
| [Week 10](week10/) | Lab 10: privilege escalation | [`lab/professional_penetration_testing_week10_lab.md`](week10/lab/professional_penetration_testing_week10_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2010%20-%20Privilege_Escalation.md))<br>[`lab/solution/professional_penetration_testing_week10_lab_report.pdf`](week10/lab/solution/professional_penetration_testing_week10_lab_report.pdf) | — |
| [Week 11](week11/) | Lab 11: web app pentesting | [`lab/professional_penetration_testing_week11_lab.md`](week11/lab/professional_penetration_testing_week11_lab.md) ([on GitHub](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/blob/cd46c585be3deaa403e11a223529b4822e97fc3a/Lab%2011%20-%20Web%20App%20Pentesting.md))<br>[`lab/solution/professional_penetration_testing_week11_lab_report.pdf`](week11/lab/solution/professional_penetration_testing_week11_lab_report.pdf) | — |

## Resources

The weekly lecture MCQs and the end-of-semester MCQ exam are not in the repository. The practical exam is in [`exam/`](exam/) (the notes and the evidence; its screen recordings are on MEGA, see [Screen recordings](#screen-recordings)). The resources of the module are an introduction to Nmap, two Nmap cheat sheets and the NIST guide to security testing. The installation guides of the vulnerability scanners are in the resources of [week 5](week05/resources/), and the guide to running an OVA file in the resources of [week 2](week02/resources/).

| File | What it contains |
|---|---|
| [`resources/introduction_to_nmap.pdf`](resources/introduction_to_nmap.pdf) | Introduction to Nmap (23 pages, 4.0 MB): slides that introduce Nmap, the free and open source network discovery and security auditing utility. |
| [`resources/nmap_cheat_sheet.pdf`](resources/nmap_cheat_sheet.pdf) | Nmap Cheat Sheet (7 pages): basic scanning techniques and options. |
| [`resources/nmap_cheat_sheet_v7_stationx.pdf`](resources/nmap_cheat_sheet_v7_stationx.pdf) | Nmap Cheat Sheet (6 pages): scan techniques and target specification, from StationX. |
| [`resources/nist_special_publication_800_115.pdf`](resources/nist_special_publication_800_115.pdf) | NIST Special Publication 800-115, Technical Guide to Information Security Testing and Assessment (80 pages). |

### Target virtual machines

The target virtual machines of the labs are too big for the repository, so they are stored on MEGA:

| Target virtual machine | Used in | Size | Download |
|---|---|---|---|
| Basic Pentesting 2 (a VirtualBox appliance in the OVA format; [`week02/resources/running_ova_on_virtualbox.pdf`](week02/resources/running_ova_on_virtualbox.pdf) shows how to import it) | [Lab 2b](week02/) | 1.4 GB | [MEGA](https://mega.nz/file/y1B2RYBB#2fSzXBIqA1OvdGOvucRdeZiVDx0LYEph_FLYQfOxrSE) |
| Metasploitable 1 (a zip archive of the virtual machine) | [Lab 6](week05/) and [Lab 7](week07/) | 1.3 GB | [MEGA](https://mega.nz/file/fgBFgCJa#hTM2dmGni1YbDr2HXRYAcH0LPe-D6eOCLNb0fDKTnbA) |
| Windows XP (the target of the Metasploit demo) | [Lab 7](week07/) | 0.5 GB | [MEGA](https://mega.nz/file/mwQlySZa#raa664ugzCa7tmdCYVAA-vVbxC08SFrDHO9WZjlgbAA) |

### Screen recordings

The screen recordings are too big for the repository, so they are stored on MEGA. They show the screen of the Kali virtual machine (3420 x 2146 pixels, lab practice 3420 x 2226). The files without "uncut" in the name leave out the stretches where the screen is black, with or without the mouse cursor (the virtual machine window was not on screen), and are re-encoded (H.264), which makes them smaller; the uncut file is the exam recording as it was made. The lab practice recording is from the drop-in tutorial of 23 April 2026, where pentesting was practised on target machines to prepare for the exam.

| Recording (file name) | Date | Length | Size | Download |
|---|---|---|---|---|
| Exam (exam_recording_2026-05-18.mov) | 18 May 2026, 15:10 | 1h 19min | 594 MB | [MEGA](https://mega.nz/file/aoo21CQb#PoQL7mEmuLGYi57QVE3JQqABAX6sLKXQqviVGwSYk5A) |
| Exam, uncut (exam_recording_2026-05-18_uncut.mov) | 18 May 2026, 15:10 | 2h 8min | 1.66 GB | [MEGA](https://mega.nz/file/X5Qm2b6I#rr3EjXMUfIlXSfdprOnTU8WvjoL7QjhCw7V9L9rMfFQ) |
| Pre-exam session (pre_exam_recording_2026-05-05.mov) | 5 May 2026, 14:18 | 1h 7min | 619 MB | [MEGA](https://mega.nz/file/2kgnEZCI#UFPeLfvhvWbuVpocFiPVcAPDU-STLlc6vDgbP8qqZFI) |
| Lab practice, drop-in tutorial (lab_practice_recording_2026-04-23.mov) | 23 April 2026, 14:02 | 41min | 425 MB | [MEGA](https://mega.nz/file/Twh1DIgQ#LAlxsrFbH1D_bXpY3p7GmijtLVeYrW6x__Wkf1LdZ88) |

### Schedule

| Week | Session | Week Date |
|---|---|---|
| [Week 0](week00/) | Lecture 1: Introduction<br>Lab 1: configuring the lab environment | 26 January 2026 |
| [Week 1](week01/) | Lecture 2: Planning<br>Labs 2 and 2a: TryHackMe and planning and engagement | 2 February 2026 |
| [Week 2](week02/) | Lecture 3: Getting to Know Your Targets<br>Lab 2b: a simulated penetration test | 9 February 2026 |
| [Week 3](week03/) | Lecture 4: Scanning and Enumeration<br>Lab 3: planning and scoping a penetration test | 16 February 2026 |
| [Week 4](week04/) | Lecture 5: Methodologies<br>Labs 4 and 5: footprinting and reconnaissance, host discovery | 23 February 2026 |
| [Week 5](week05/) | Lecture 6: Vulnerability Scanning and Analysis<br>Lab 6: vulnerability scanners | 2 March 2026 |
| Week 6 | Lecture 7: Vulnerabilities | 9 March 2026 |
| [Week 7](week07/) | Lecture 8: Social Engineering<br>Lab 7: introduction to Metasploit | 16 March 2026 |
| [Week 8](week08/) | Lecture 9: Password Cracking<br>Lecture 11: Wireless Standards & Scanning (WiFi), 26 March<br>Lecture 10: Attacking Local Host Vulnerabilities, 27 March<br>Lab 8: attacking passwords | 23 March 2026 |
| [Week 9](week09/) | Guest speakers, 17 April<br>Lab 9: cracking wireless passwords<br>Drop-in tutorial, 16 April | 13 April 2026 |
| [Week 10](week10/) | Lecture 12: Web and DB Attacks, 24 April<br>Lab 10: privilege escalation<br>Drop-in tutorial, 23 April: lab practice on target machines (recorded, see [Screen recordings](#screen-recordings)) | 20 April 2026 |
| [Week 11](week11/) | Lecture 13: Communication & Reporting, 1 May<br>Lab 11: web app pentesting<br>Drop-in tutorial, 30 April | 27 April 2026 |
| Week 12 | Pre-exam session, 5 May (recorded, see [Screen recordings](#screen-recordings)) | Week of 4 May 2026 |
| Exams | Theory exam, 14:00 to 15:00: 50 multiple choice questions<br>Practical exam, 15:00 to 18:00: a simulated penetration test ([`exam/`](exam/)) | 18 May 2026 |

### Links

- The lecturer's lab pages (the source of the lab sheets): https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs
- The "on GitHub" links in [All weeks](#all-weeks) and the links in the week READMEs point to the lecturer's lab pages at one fixed commit, [`cd46c58`](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/commit/cd46c585be3deaa403e11a223529b4822e97fc3a) (28 March 2026), the latest commit of the repository; the lab sheets in the weeks are identical to those versions, except that the ten pictures of the pages of weeks 4 and 8 are linked from [`images/`](https://github.com/PhillipFitzpatrick/Prof-Penetration-Testing-Labs/tree/cd46c585be3deaa403e11a223529b4822e97fc3a/images) of that commit instead of by relative path.
- Labs: https://www.virtualbox.org/wiki/Downloads (VirtualBox), https://www.kali.org/get-kali/ (Kali Linux), https://tryhackme.com and https://hackthebox.com (the platforms of Labs 2 and 2a), https://nmap.org/book (Nmap).
