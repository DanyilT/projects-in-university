# Week 09 — Lab: cross-site request forgery (CSRF)

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

CSRF tokens, the SameSite attribute of cookies and POST instead of GET all defend against CSRF. The lab launches a CSRF attack against the Coffeeshop user Bob: the session cookie settings in the Django settings file are changed first (SameSite and Secure) so that the attack can work in Firefox, and then the defences are added. The Vagrantfile is the configuration of the Coffeeshop virtual machine.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/secure_programming_week09_lab.pdf`](lab/secure_programming_week09_lab.pdf) | The lab sheet (5 pages): CSRF Lab. |
| [`lab/resources/Vagrantfile`](lab/resources/Vagrantfile) | The Vagrantfile of the Coffeeshop virtual machine: the forwarded ports, the secrets folder, the provisioning scripts and the Docker provider. |
| [`lab/solution/secure_programming_week09_lab_report.pdf`](lab/solution/secure_programming_week09_lab_report.pdf) | The answers (6 pages): setting up the exploit and the defences. |
