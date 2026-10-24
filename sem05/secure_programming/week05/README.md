# Week 05 — Labs: path traversal and brute-force authentication

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

The lecture of the week was access control. The path traversal lab adds a download function to Coffeeshop (a files folder with a secrets file and the download_file function in views.py) that is vulnerable to path traversal, and uses it to reach the config.env file with the site's usernames and passwords; the fix normalises the path and checks that it starts with the base directory. The second lab, Brute-Forcing Authentication and Privilege Escalation (marked as optional on the course page), uses Burp Suite to intercept the login request of Coffeeshop and brute-force the login form with the Intruder (a cluster bomb attack with username and password lists).

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/secure_programming_week05_lab.pdf`](lab/secure_programming_week05_lab.pdf) | The lab sheet (3 pages): Path Traversal Attack Lab. |
| [`lab/secure_programming_week05_lab_a.pdf`](lab/secure_programming_week05_lab_a.pdf) | The lab sheet of the optional lab (5 pages): Brute-Forcing Authentication and Privilege Escalation with Burp Suite. |
| [`lab/solution/secure_programming_week05_lab_report.pdf`](lab/solution/secure_programming_week05_lab_report.pdf) | The answers (2 pages): performing the path traversal attack. |
| [`lab/solution/source_code/download_file.py`](lab/solution/source_code/download_file.py) | The vulnerable download_file function of the lab, as added to views.py. |
| [`lab/solution/source_code/fixed_download_file.py`](lab/solution/source_code/fixed_download_file.py) | The fixed download_file function: the normalised path is checked against the base directory. |
| [`lab/teacher_solution/secure_programming_week05_lab_teacher_solution.txt`](lab/teacher_solution/secure_programming_week05_lab_teacher_solution.txt) | The lecturer's version of the fix (the fixed download function). |
