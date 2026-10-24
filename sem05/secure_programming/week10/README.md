# Week 10 — Bug bounty session

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

The lecture of the week was replaced by a hands-on bug bounty lab on Friday 21 November 2025, hosted by Ciarán Cotter, who was returning to the module: the groups hunted for security bugs through the Bord Gáis bug bounty programme, using the tools to dissect the programme's scope. The sessions were in lab A11 and lasted about two to two and a half hours (groups 1 and 3 from 11:00 to 13:30, groups 2 and 4 from 14:00 to 16:30), and attendance and participation were graded as part of the lab assessment. The preparation was to install the Project Discovery Tool Manager (pdtm) with Subfinder, Naabu, HTTPX and URLFinder, and Caido. The notes are from the 14:00 session: finding the subdomains of a website with Subfinder and checking which of them are in use with HTTPX.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`tud_session/README.md`](tud_session/README.md) | The README of the session folder: the date and time of the session and the host, with a pointer to the e-mail. |
| [`tud_session/email.txt`](tud_session/email.txt) | The e-mail that announced the session: the change of the schedule, the groups and times, and the tools to install. |
| [`tud_session/notes.md`](tud_session/notes.md) | The notes of the session: the commands for Subfinder (subdomains of a website, saved to a file) and HTTPX (the hosts in use), with a note to look for suspicious hosts and a tip about SecLists for brute force. |
| [`tud_session/fis_subs.txt`](tud_session/fis_subs.txt) | The output of Subfinder for the domain fisglobal.com: the list of subdomains found (191 KB). |
| [`tud_session/screenshots/`](tud_session/screenshots/) | Two screenshots of the commands run in the session: the Subfinder run and the HTTPX run over the subdomain list. |
