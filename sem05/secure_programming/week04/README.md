# Week 04 — Lab: cross-site scripting (XSS)

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

The lab looks at reflected XSS and stored XSS against Coffeeshop: a script injected through the product page shows the cookie in an alert or sends it to the attacker, and the vulnerable code is then fixed. The attacker's server is the csthirdparty application (downloaded from Brightspace, a second web application for the cross-site labs), whose database shows the stolen cookies. The XSS lab is on two sheets: part 1 (reflected XSS) and the full lab (parts 1 and 2, with stored XSS).

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/secure_programming_week04_lab_part1.pdf`](lab/secure_programming_week04_lab_part1.pdf) | The lab sheet of part 1 (4 pages): XSS Lab, Reflected XSS. |
| [`lab/secure_programming_week04_lab.pdf`](lab/secure_programming_week04_lab.pdf) | The lab sheet of parts 1 and 2 (8 pages): XSS Lab, reflected and stored XSS. |
| [`lab/resources/csthirdparty.zip`](lab/resources/csthirdparty.zip) | The csthirdparty application (2.7 MB zip): the second web application used by the cross-site labs. |
| [`lab/solution/secure_programming_week04_lab_part1_report.pdf`](lab/solution/secure_programming_week04_lab_part1_report.pdf) | The answers of part 1 (3 pages): exploiting a reflected XSS vulnerability. |
| [`lab/solution/secure_programming_week04_lab_report.pdf`](lab/solution/secure_programming_week04_lab_report.pdf) | The answers of parts 1 and 2 (7 pages): the reflected and the stored XSS exploits and the fixes. |
