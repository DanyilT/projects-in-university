# Week 04 — Practical 4: ThreadMentor set-up for the project

**Module:** Operating Systems (`COMP H2014`)  
**Semester:** 4 (Year 2), folder `sem04`

[Module README](../README.md)

## What this week is for

Practical 4 sets up the ThreadMentor software for the team project: install the two dependency libraries from their rpm packages (as root with urpmi), install ThreadMentor, set the PATH environment variable, download the code of the chosen dining philosophers solution, then compile and run it. The folder has the ThreadMentor package and the two libraries, and the code of the solution that was chosen, the mutual exclusion lock solution: five Philosopher threads, each of which thinks, locks its left and then its right chopstick (a mutex lock for each chopstick), eats and unlocks them. The program description says that this solution could cause deadlock.

## Screenshots

![Week 04 screenshot](../.screenshots/week04/screenshot.png)

*The title page of the Practical 4 sheet.*

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/operating_systems_week04_lab.pdf`](lab/operating_systems_week04_lab.pdf) | The practical sheet (14 pages): ThreadMentor Set-up (March 2025). |
| [`lab/resources/ThreadMentor-fedora4.tgz`](lab/resources/ThreadMentor-fedora4.tgz) | The ThreadMentor package (a tarball): the visual and no-visual versions of the thread library, its include files and its bin folder. |
| [`lab/resources/libglib1.2-1.2.10-24mdv2011.0.i586.rpm`](lab/resources/libglib1.2-1.2.10-24mdv2011.0.i586.rpm) | The glib 1.2 library package (a 32-bit rpm), the first dependency of ThreadMentor. |
| [`lab/resources/libgtkPLUS1.2-1.2.10-51mdv2011.0.i586.rpm`](lab/resources/libgtkPLUS1.2-1.2.10-51mdv2011.0.i586.rpm) | The GTK+ 1.2 library package (a 32-bit rpm), the second dependency of ThreadMentor. |
| [`lab/resources/diningphil/Makefile`](lab/resources/diningphil/Makefile) | The Makefile of the mutex lock solution: it builds the program Philosopher from Philosopher.cpp and Philosopher-main.cpp with the visual ThreadMentor library. |
| [`lab/resources/diningphil/Philosopher.h`](lab/resources/diningphil/Philosopher.h) | The header of class Philosopher, a ThreadMentor thread, with 5 philosophers. |
| [`lab/resources/diningphil/Philosopher.cpp`](lab/resources/diningphil/Philosopher.cpp) | The philosopher thread: each philosopher locks his left and then his right chopstick (mutex locks), eats and unlocks them. |
| [`lab/resources/diningphil/Philosopher-main.cpp`](lab/resources/diningphil/Philosopher-main.cpp) | The main program: it reads the number of iterations from the command line, creates the 5 chopstick mutex locks and the 5 philosopher threads, starts them and waits for them. |
