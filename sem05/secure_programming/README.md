# Secure Programming

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`  
**Lecturer:** Stephen O'Shaughnessy  
**Date:** September - December 2025  
**Matching project branch:** none

## What this module is for

Secure Programming is the third-year module on writing secure code and on securing web applications. It goes through security by design and threat modelling, the web application vulnerabilities (injection attacks, cross-site scripting, access control and path traversal, authentication and brute force, input validation and command injection, cross-site request forgery), code flaws, secure code frameworks and security code testing with static analysis. The labs use Coffeeshop, a purposely vulnerable Django web application (Python with a Postgres database) that runs in a container through Vagrant, and a second application, csthirdparty, for the cross-site and reverse shell labs: each week an exploit is carried out against the application and then the code is fixed. Week 10 was a bug bounty session hosted by an outside professional instead of a lecture. This folder holds the lab sheets and resources, the solutions (answers, source code and the threat model), the notes of the bug bounty session, the revision material, the screenshot of the MCQ test result, and Assessment 1, a group assignment to find, exploit and fix the vulnerabilities of a Flask web application.

## Grades Breakdown

| Assessment Type | Weighting |
|---|---|
| Assignment 1: identify, exploit and fix the vulnerabilities of a Flask web application (group of 2 to 3, due 16 November 2025) | 40% |

The brief gives 40% for Assignment 1. The other assessments of this edition are the weekly labs (the bug bounty session was graded as part of the lab assessment) and an MCQ test on 12 December 2025; their weights are not in the course files. The introduction lecture of the course page lists the split of the 2024-25 edition: Assignment 1 (web vulnerabilities) 30%, Assignment 2 (code analysis) 20%, Assignment 3 (lab exam) 30%, weekly labs 10% and MCQ 10%.

## All weeks

| Week | Title | Files | Screenshot |
|---|---|---|---|
| [Week 2](week02/) | Lab 1: threat modelling | [`lab/secure_programming_week02_lab.pdf`](week02/lab/secure_programming_week02_lab.pdf)<br>[`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (draft).png`](week02/lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28draft%29.png)<br>[`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model.png`](week02/lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model.png)<br>[`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (threats).png`](week02/lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28threats%29.png)<br>[`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model.json`](week02/lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model.json)<br>[`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (threats).json`](week02/lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28threats%29.json)<br>[`lab/solution/secure_programming_week02_lab_report.pdf`](week02/lab/solution/secure_programming_week02_lab_report.pdf) | — |
| [Week 3](week03/) | Lab: injection attacks (SQL injection) and the Coffeeshop installation | [`lab/secure_programming_week03_lab.pdf`](week03/lab/secure_programming_week03_lab.pdf)<br>[`lab/resources/Secure Programming Week3 Lab Installation.pdf`](week03/lab/resources/Secure%20Programming%20Week3%20Lab%20Installation.pdf)<br>[`lab/resources/Interacting_with_Vagrant_and_Updating_Code.pdf`](week03/lab/resources/Interacting_with_Vagrant_and_Updating_Code.pdf)<br>[`lab/resources/Useful_Commands_for_Troubleshooting.pdf`](week03/lab/resources/Useful_Commands_for_Troubleshooting.pdf)<br>[`lab/solution/secure_programming_week03_lab_report.pdf`](week03/lab/solution/secure_programming_week03_lab_report.pdf) | — |
| [Week 4](week04/) | Lab: cross-site scripting (XSS) | [`lab/secure_programming_week04_lab_part1.pdf`](week04/lab/secure_programming_week04_lab_part1.pdf)<br>[`lab/secure_programming_week04_lab.pdf`](week04/lab/secure_programming_week04_lab.pdf)<br>[`lab/resources/csthirdparty.zip`](week04/lab/resources/csthirdparty.zip)<br>[`lab/solution/secure_programming_week04_lab_part1_report.pdf`](week04/lab/solution/secure_programming_week04_lab_part1_report.pdf)<br>[`lab/solution/secure_programming_week04_lab_report.pdf`](week04/lab/solution/secure_programming_week04_lab_report.pdf) | — |
| [Week 5](week05/) | Labs: path traversal and brute-force authentication | [`lab/secure_programming_week05_lab.pdf`](week05/lab/secure_programming_week05_lab.pdf)<br>[`lab/secure_programming_week05_lab_a.pdf`](week05/lab/secure_programming_week05_lab_a.pdf)<br>[`lab/solution/secure_programming_week05_lab_report.pdf`](week05/lab/solution/secure_programming_week05_lab_report.pdf)<br>[`lab/solution/source_code/download_file.py`](week05/lab/solution/source_code/download_file.py)<br>[`lab/solution/source_code/fixed_download_file.py`](week05/lab/solution/source_code/fixed_download_file.py)<br>[`lab/teacher_solution/secure_programming_week05_lab_teacher_solution.txt`](week05/lab/teacher_solution/secure_programming_week05_lab_teacher_solution.txt) | — |
| [Week 8](week08/) | Lab: command injection | [`lab/secure_programming_week08_lab.pdf`](week08/lab/secure_programming_week08_lab.pdf)<br>[`lab/solution/secure_programming_week08_lab_report.pdf`](week08/lab/solution/secure_programming_week08_lab_report.pdf) | — |
| [Week 9](week09/) | Lab: cross-site request forgery (CSRF) | [`lab/secure_programming_week09_lab.pdf`](week09/lab/secure_programming_week09_lab.pdf)<br>[`lab/resources/Vagrantfile`](week09/lab/resources/Vagrantfile)<br>[`lab/solution/secure_programming_week09_lab_report.pdf`](week09/lab/solution/secure_programming_week09_lab_report.pdf) | — |
| [Week 10](week10/) | Bug bounty session | [`tud_session/README.md`](week10/tud_session/README.md)<br>[`tud_session/email.txt`](week10/tud_session/email.txt)<br>[`tud_session/notes.md`](week10/tud_session/notes.md)<br>[`tud_session/fis_subs.txt`](week10/tud_session/fis_subs.txt)<br>[`tud_session/screenshots/`](week10/tud_session/screenshots/) | — |
| [Week 11](week11/) | Lab: static code analysis (Snyk CLI) | [`lab/secure_programming_week11_lab.pdf`](week11/lab/secure_programming_week11_lab.pdf)<br>[`lab/solution/secure_programming_week11_lab_report.pdf`](week11/lab/solution/secure_programming_week11_lab_report.pdf) | — |
| [Week 12](week12/) | Revision | [`resoures/secure_programming_revision.pdf`](week12/resoures/secure_programming_revision.pdf)<br>[`resoures/secure_programming_sample_mcq.pdf`](week12/resoures/secure_programming_sample_mcq.pdf) | — |
| [Week 13](week13/) | MCQ test (12 December 2025) | [`test/score_screenshot.png`](week13/test/score_screenshot.png) | — |

## Assessments and other files

Assignment 1 is a group assignment (2 to 3 students, one submission per group, deadline 16 November 2025, 23:59, worth 40%): the given web application, a simple Python Flask application with an SQLite database, has to be analysed, its weaknesses exploited (with screenshots and a description), the code fixed (with comments where it was changed) and the exploit repeated to show that it no longer works. The report is a zip with the report and the corrected code, with at most about 2,500 to 3,000 words. The marking rubric is identifying and exploiting vulnerabilities (50%) and fixing them (50%), each split into lab vulnerabilities (20%) and non-lab vulnerabilities (30%): the aim is to find and fix 5 vulnerabilities covered in the labs and 5 that were not, and only one vulnerability and fix counts per location. The solution is in the project repository, https://github.com/DanyilT/SecureProgramming-trump (the initial application on the branch init, the fixed one on main, and the vulnerabilities tracked as pull requests).

| File | What it contains |
|---|---|
| [`assessment/01/secure_programming_assessment.pdf`](assessment/01/secure_programming_assessment.pdf) | The brief (3 pages): Secure Programming Assignment 1, worth 40%, deadline 16 November 23:59, the three parts (exploit, fix, show that the exploit no longer works), Section 1 (25%), Section 2 (25%), the deliverables and the marking rubric. |
| [`assessment/01/resources/secure_programming_assessment_installation.pdf`](assessment/01/resources/secure_programming_assessment_installation.pdf) | The installation instructions (2 pages): setting up a Python virtual environment, installing the requirements and running the application. |
| [`assessment/01/resources/trump.zip`](assessment/01/resources/trump.zip) | The web application of the assignment (1.0 MB zip): the Flask application "Donald Trump Appreciation Site" with its templates, static files, documents and the SQLite database. |
| [`assessment/01/submission/project_link.txt`](assessment/01/submission/project_link.txt) | One line: the GitHub link to the project repository, SecureProgramming-trump. |
| [`assessment/01/submission/secure_programming_assessment_report.pdf`](assessment/01/submission/secure_programming_assessment_report.pdf) | The submitted report (43 pages, 32 MB): the 14 vulnerabilities that were exploited and fixed (in-band SQL injection, reflected and stored XSS, path traversal, CSRF, insecure direct object reference, broken access control, open redirect, hard-coded secret key, plaintext password storage, a visible password field, sensitive data exposure of credit cards, the database configuration and debug mode in production), each with the exploit, the fix and screenshots, with the links to the repository, its two versions and the pull requests. |

---

## Syllabus

The syllabus of the introduction lecture (it may change): 1. Introduction; 2. Security by design; 3 to 7. Web application vulnerabilities; 8. Code flaws and vulnerabilities; 9. Secure code frameworks; 10. Security code testing; 11. Module wrap-up. The course page lists the lectures as Introduction, Secure by Design, SQL injection (injection attacks), XSS, Access Control, Input Validation, CSRF, Secure Code Analysis and Revision.

## Links

- The Coffeeshop application used in the labs: https://github.com/stephen-oshaughnessy/django-coffeeshop (the csthirdparty application is inside its root folder).
- Burp Suite Community Edition (the brute force lab): https://portswigger.net/burp/communitydownload
- Snyk (the static code analysis lab): https://app.snyk.io/login
- The tools of the bug bounty session: the Project Discovery Tool Manager, https://github.com/projectdiscovery/pdtm (Subfinder, Naabu, HTTPX and URLFinder), and Caido, https://caido.io
- The threat modelling tools of Lab 1: the Microsoft Threat Modeling Tool, https://www.microsoft.com/en-ie/download/details.aspx?id=49168, and the OWASP Threat Dragon user guide, https://owasp.org/www-project-threat-dragon/docs-2/getting-started/
