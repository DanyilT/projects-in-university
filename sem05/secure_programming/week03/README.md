# Week 03 — Lab: injection attacks (SQL injection) and the Coffeeshop installation

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

Lab 1 - Installation sets up the tools for the semester (Docker Desktop, Vagrant, Git, HTTP Toolkit, Windows Terminal for Windows, Chrome and Firefox), clones the Coffeeshop application from GitHub and starts it through Vagrant; the other sheets explain how to interact with the Vagrant machine and update the code and list useful troubleshooting commands. The lab of the week, Injection Attacks, shows that the search function of Coffeeshop is vulnerable to SQL injection: the backend code (the search function in views.py) builds its SQL query from the input, and a UNION SELECT query retrieves the users and credentials from the database. The deliverables are the answers to four questions, the task of creating a SQL injection query, and the fixed views.py code.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/secure_programming_week03_lab.pdf`](lab/secure_programming_week03_lab.pdf) | The lab sheet (8 pages): Secure Programming Lab, Injection Attacks. |
| [`lab/resources/Secure Programming Week3 Lab Installation.pdf`](lab/resources/Secure%20Programming%20Week3%20Lab%20Installation.pdf) | Lab 1 - Installation (6 pages): the tools, the Coffeeshop application, the Django framework and the installation through Vagrant. |
| [`lab/resources/Interacting_with_Vagrant_and_Updating_Code.pdf`](lab/resources/Interacting_with_Vagrant_and_Updating_Code.pdf) | Interacting with Vagrant and Updating Code (2 pages): where the application code is and how to work with the virtual machine. |
| [`lab/resources/Useful_Commands_for_Troubleshooting.pdf`](lab/resources/Useful_Commands_for_Troubleshooting.pdf) | Useful Commands for Troubleshooting (2 pages): Vagrant commands from the host and Apache and Postgres commands inside the container. |
| [`lab/solution/secure_programming_week03_lab_report.pdf`](lab/solution/secure_programming_week03_lab_report.pdf) | The answers (8 pages): the questions with the SQL injection queries and their results. |
