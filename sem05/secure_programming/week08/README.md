# Week 08 — Lab: command injection

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

The lab shows how an insecure function leads to command injection and a reverse shell, an entry point that was not intended by the developer. A netcat listener is started on port 9000 on the csthirdparty machine, and a payload entered in the contact form of Coffeeshop opens a Bash session back to it; the vulnerable code is the contact function in views.py, which builds a command by concatenating the user's input. The fix filters the input with a regular expression.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/secure_programming_week08_lab.pdf`](lab/secure_programming_week08_lab.pdf) | The lab sheet (5 pages): Command Injection. |
| [`lab/solution/secure_programming_week08_lab_report.pdf`](lab/solution/secure_programming_week08_lab_report.pdf) | The answers (6 pages): setting up the reverse shell exploit, the output of the commands run through it and the fix. |
