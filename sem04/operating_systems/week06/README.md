# Week 06 — Practical 6: monitoring processes

**Module:** Operating Systems (`COMP H2014`)  
**Semester:** 4 (Year 2), folder `sem04`

[Module README](../README.md)

## What this week is for

Practical 6 is a workshop on monitoring processes in Linux: install the xeyes program, type in and compile parentchild.c, which creates a child process with fork() and replaces it with xeyes by execlp() while the parent waits, and use it to study foreground and background jobs (CTRL-Z, jobs, bg and fg) and the process listings of ps, ps a and ps au, then research the process monitoring tools of Linux. The practical builds on lecture 3 (processes), slides 23 to 30. The reflective journal is for the session of 3 April 2025 and records what the program prints and the output of the commands. The folder also has an empty backup file that Emacs left next to the program.

## Screenshots

![Week 06 screenshot](../.screenshots/week06/screenshot.png)

*The first page of the reflective journal for Practical 6.*

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/operating_systems_week06_lab.pdf`](lab/operating_systems_week06_lab.pdf) | The practical sheet (12 pages): Monitoring Processes Workshop (March 2025). |
| [`lab/resources/operating_systems_reflective_journal_template.odt`](lab/resources/operating_systems_reflective_journal_template.odt) | The Reflective Journal template (an OpenDocument text file). |
| [`lab/solution/operating_systems_week06_lab_reflective_journal.odt`](lab/solution/operating_systems_week06_lab_reflective_journal.odt) | The completed reflective journal (an OpenDocument text file). |
| [`lab/solution/operating_systems_week06_lab_reflective_journal.pdf`](lab/solution/operating_systems_week06_lab_reflective_journal.pdf) | The completed reflective journal as a PDF (5 pages). |
| [`lab/solution/practical6/parentchild.c`](lab/solution/practical6/parentchild.c) | The parent and child program: fork() makes a child, which prints a message and runs xeyes through execlp(), while the parent sleeps for 5 seconds, prints two messages, waits for the child with wait() and prints a final message. |
| [`lab/solution/practical6/parentchild`](lab/solution/practical6/parentchild) | parentchild.c compiled (a Linux executable). |
