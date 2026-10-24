# Week 02 — Lab 1: threat modelling

**Module:** Secure Programming (`DFCS H3017`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

The lecture of week 2 was security by design. Lab 1 is a threat modelling exercise with Microsoft's Threat Modelling Tool or OWASP Threat Dragon. The given application is EduPay, a payroll portal for schools and universities: staff register with personal information (name, e-mail, staff ID, password, bank account details, tax number), the system validates them against the HR database and stores them in a payroll database, and logged-in users view and download payslips, update their personal information and access tax forms. The threat analysis follows five steps: identify the security objectives, create an application overview, decompose the application (trust boundaries, entry and exit points, data flows and a data flow diagram), identify threats and identify vulnerabilities. The solution is the threat model in OWASP Threat Dragon (the draft diagram, the diagram with the trust boundary and the diagram with the threats, each as an image and as JSON) and a report with the five steps.

## Files

| File | What it contains | Screenshot |
|---|---|---|
| [`README.md`](README.md) | This README. | — |
| [`lab/secure_programming_week02_lab.pdf`](lab/secure_programming_week02_lab.pdf) | The lab sheet (2 pages): Secure Programming Lab 1 - Threat Modelling, the EduPay scenario, the five steps and the links to the tools. | — |
| [`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (draft).png`](lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28draft%29.png) | The first draft of the data flow diagram: the staff member, the HR administrator, the payroll web application, the payroll database and the HR system database, without a trust boundary. | <img src="lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28draft%29.png" alt="Week 02 EduPay Payroll Threat Model (draft)" width="400"><br>*The draft data flow diagram.* |
| [`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model.png`](lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model.png) | The data flow diagram with the trust boundary (the EduPay internal network or trusted zone) around the web application, the two databases and the HR administrator. | <img src="lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model.png" alt="Week 02 EduPay Payroll Threat Model" width="400"><br>*The data flow diagram with the trust boundary.* |
| [`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (threats).png`](lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28threats%29.png) | The same diagram with the elements that have threats drawn in red. | <img src="lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28threats%29.png" alt="Week 02 EduPay Payroll Threat Model (threats)" width="400"><br>*The diagram with the threatened elements in red.* |
| [`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model.json`](lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model.json) | The threat model in OWASP Threat Dragon format: the diagram (12 elements), without threats. | — |
| [`lab/solution/EduPay Payroll Threat Model/EduPay Payroll Threat Model (threats).json`](lab/solution/EduPay%20Payroll%20Threat%20Model/EduPay%20Payroll%20Threat%20Model%20%28threats%29.json) | The threat model in OWASP Threat Dragon format with the threats (35 threats). | — |
| [`lab/solution/secure_programming_week02_lab_report.pdf`](lab/solution/secure_programming_week02_lab_report.pdf) | The report (7 pages): the five steps of the threat model, from the security objectives to the vulnerabilities. | — |
