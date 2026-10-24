# Group Project: Secure Documents Vault Mobile Application (SecDocVault) and Privacy & Security Research

**Module:** Group Project (`DFCS H3018`)  
**Programme:** BSc in Computing in Digital Forensics & Cyber Security, Year 3, TU Dublin Blanchardstown  
**Group:** Danyil Tymchuk, Illia Stefanovskyi and Artem Surzhenko  
**Source code:** [DanyilT/SecDocVault](https://github.com/DanyilT/SecDocVault) (its own repository)  
**Module folder on `main`:** [`sem06/group_project`](https://github.com/DanyilT/projects-in-university/tree/main/sem06/group_project)

| | Original project | Extension to the project (the repeat) |
|---|---|---|
| Title | Secure Documents Vault Mobile Application | SecDocVault: Privacy & Security Research |
| Supervisor | Dr. Assem Abdel Hak | Peter Alexander |
| Thesis due | 23:59 on Sunday 10 May 2026 | 23:59 on Sunday 30 August 2026 |
| Presentation and demo | Thursday 14 May 2026, on campus | Friday 4 September 2026, on campus |
| Other dates | Proposal 26 December 2025, thesis declaration 5 May 2026 | Work from 30 June 2026 (about nine weeks) |
| Source code | Releases [v0.1.0](https://github.com/DanyilT/SecDocVault/releases/tag/v0.1.0) and [v0.1.1](https://github.com/DanyilT/SecDocVault/releases/tag/v0.1.1) | Up to the commit [b598dc3](https://github.com/DanyilT/SecDocVault/tree/b598dc397f56882d51e6a8a8d62acf15964fb612) |
| Mark | 26% (fail) | 83% |
| Files | [`original/`](original/) | [`extension/`](extension/) |

## The application

SecDocVault is a mobile application (React Native with TypeScript, run and demonstrated on Android) that keeps sensitive documents, such as identity cards, medical records and bank statements, encrypted on the phone instead of in the camera roll. Every file is encrypted on the device with AES-256-GCM (a random key for each document and a unique IV for each file), and the keys are protected with the Android Keystore. A recovery passphrase (PBKDF2 and AES-256-CBC) can back the keys up, so that an account can be used from another device. The backend is Firebase (Authentication, Firestore, Storage and Hosting) and holds only encrypted data. For each document the user chooses where it is stored: on the device only, in the cloud only, or both.

The other features are email verification at registration, unlock with a PIN or biometrics and an automatic lock after inactivity, document censoring (OCR with Tesseract and detector rules for card numbers, IBANs, dates of birth and passport MRZ lines), sharing with another registered user with an expiry or a revocation, editing of the document metadata, a guest mode that stores locally only, and a privacy screen that hides the content in the app switcher and blocks screenshots. The tests are Jest unit tests.

## Original project (May 2026)

The proposal of 26 December 2025 describes an Android application with Firebase services and the Android Keystore for the master key, its scope, its functional requirements and five risks with their mitigations. The thesis of May 2026 (18 pages) describes the finished application: the research questions, a short literature review, the architecture and the cryptographic specification, the data design, the additional features, the security analysis with a STRIDE threat model, the known limitations and the future work. The presentation and demo of 14 May 2026 (37 slides) walks through the application and shows the document lifecycle and the features with the [demo recordings](#demo-recordings). The diagrams of the proposal and of the global design and structure were drawn by Illia Stefanovskyi. The code of the original project is the releases [v0.1.0](https://github.com/DanyilT/SecDocVault/releases/tag/v0.1.0) (13 April 2026, a pre-release) and [v0.1.1](https://github.com/DanyilT/SecDocVault/releases/tag/v0.1.1) (10 May 2026) of the SecDocVault repository, each with a debug APK. Each group had 12 minutes for the demo, followed by 4-5 minutes of questions, with the time limit strictly enforced; the demo was assessed by the supervisor and at least one other lecturer, and every member was expected to contribute to it. The project was marked 26%.

> [!WARNING]
> The original project was not passed. The main reason was the documentation: the application worked well, but the thesis documented it weakly. Most of the application and the first thesis were written by one member (me) of the group, and the amount of work was small for a project of three people.

## Extension to the project: the repeat (July-August 2026)

The original project was not passed, so the Group Project was repeated over the summer as an extension to the project. The Group Project cannot normally be repeated over the summer (the next regular sitting is January 2027); an exception was approved, with about nine weeks for the work instead of the about 15 weeks of the semester.

The extension takes the same application further as research: does an encrypted vault keep its promises? The application was extended (more file formats and more unit tests) and then assessed with a threat model (STRIDE, and LINDDUN for privacy), OWASP MASVS and MASTG checks, CVSS v3.1 for the severity of the findings, and GDPR articles and the HIPAA technical safeguards as the compliance criteria. The tests are the functional and non-functional tests, eleven anonymity and fingerprinting procedures (TA-01 to TA-11: identifiers, cross-session linkability, account enumeration, metadata that survives, data that remains after deletion), the MASVS assessment and the data-protection assessment. The thesis finds that SecDocVault chose and implemented its cryptographic primitives correctly but does not keep several of its promises, because of the configuration, the metadata handling, the third-party dependencies and the data lifecycle, and it ends with seven remediations in order of severity.

The work was split by theme (the [work plan](extension/resources/group_project_extension_work_plan.pdf)): Danyil Tymchuk (me) took anonymity and digital fingerprinting, Artem Surzhenko privacy and data protection and Illia Stefanovskyi cryptography and implementation, and the three together took the application security and testing, the introduction, the discussion, the conclusions and the presentation. The last changes of the extension to the application are in the commit [b598dc3](https://github.com/DanyilT/SecDocVault/commit/b598dc397f56882d51e6a8a8d62acf15964fb612) of 18 August 2026 (the merge of the pull request "unit tests"). The extension (the repeat) was marked 83%.

## Documents on Google Docs and Slides

The documents were written in Google Docs and Google Slides, and the PDF files of this branch are the exports. The presentations are not kept as PowerPoint files, because the slide transitions and the speaker notes are in the Google Slides versions below, which are view-only.

| Document | Original project | Extension (the repeat) |
|---|---|---|
| Presentation (Google Slides) | [Slides](https://docs.google.com/presentation/d/1sUgMd-E_bwqgsSL7vbiI7sTbMXfcYbDFPvNs6DiF38s) ([published version](https://docs.google.com/presentation/d/e/2PACX-1vRv1Sf6hlji7lMislYrcWzvqsWngoUy7O2NZvuFUvIqOPd_qAqp26TQQ4FXlvwmhtqxyTpQrLkp3nD9/pub)) | [Slides](https://docs.google.com/presentation/d/1UC5EUAw6M-wIOFokvhE6sCY2t25_snUDYcorPeyhpaE) ([published version](https://docs.google.com/presentation/d/e/2PACX-1vQwIZGbJwVqfiu8kUp0mJWNCBWgeHb8Hc1Euwl-JsFJOByK7Mp2FrWjDo4oytSsuznJ_rHNAHk5Z9AW/pub)) |
| Proposal and draft idea (Google Docs) | [Proposal](https://docs.google.com/document/d/1a5h0cj-3YfZbyHMLaxwaeuMebBPtptTLzw0YTKcu9nY) ([published version](https://docs.google.com/document/d/e/2PACX-1vSW59JqGmW93RDQuZFBdjPXOY2843ZTiFR1zkZ2B_afTJMm9Jy2hJk6QjHyshdLNPJ-logOSosDD80O/pub)) | [Draft idea](https://docs.google.com/document/d/17wlvLNTYxKkuFvYoMlGIzm9D3D7qvv4rFeMqKXIDVlM) ([published version](https://docs.google.com/document/d/e/2PACX-1vSNJ3qHJiJRehUHv6YGhGR_bUh1rpU5_0mv4k2_mNTUPmDSSxhzqsovLcnC3sMsuaCBV8oExNTb3J00/pub)) |
| Thesis (Google Docs) | [Thesis](https://docs.google.com/document/d/1WAj044BChOyFGJSUzg3KszkHjlPfrwdSWS0TeSzKck8) ([published version](https://docs.google.com/document/d/e/2PACX-1vSjvWeF0B4D-PlKXaR7L-09Uw69qxxYfDX5KZZsyWaQcrxzzdwgtgvCEFFWe7Nitk8dF517WG3DiQ4Q/pub)) | [Thesis](https://docs.google.com/document/d/1RHvztmWQ9cuDwa3_IrcP4aKr8DMU9VYCZCkj6fMz4ho) ([published version](https://docs.google.com/document/d/e/2PACX-1vR9GDpECDaOg0B6ZrtTQaBWYrN6-EwlsxQNHvl2U0mnjS6mLImTJ8RzCM-9K4CWYKuvYkCWnDKomT33/pub)) |
| Work plan (Google Sheets) | — | [Sheet](https://docs.google.com/spreadsheets/d/160Zj4EUQ5wzKSH7MFjzNsd9UKH7467Ghm7f6TuXmCDw) ([published version](https://docs.google.com/spreadsheets/d/e/2PACX-1vSvy8xfv0D3gDqoolFjcbo9-xt4WVzoB0czIvEinw-GAi0HGwZTz0XJEDg1CKxlrrfkWXnIjwyXMJyN/pub)) |

## Demo recordings

The five screen recordings of the original project (1280 x 2856 pixels) are in the SecDocVault repository, in [`demo/android/v0.1.1`](https://github.com/DanyilT/SecDocVault/tree/main/demo/android/v0.1.1).

| Recording | What it shows |
|---|---|
| [`BackgroundPrivacyScreen.gif`](https://github.com/DanyilT/SecDocVault/blob/main/demo/android/v0.1.1/BackgroundPrivacyScreen.gif) | 152 frames: the preview of a document, the phone's home screen and app switcher, where the application shows a blank card, and the unlock screen when the application is opened again. |
| [`DisabledScreenShots.gif`](https://github.com/DanyilT/SecDocVault/blob/main/demo/android/v0.1.1/DisabledScreenShots.gif) | 136 frames: the Screenshot button of the app switcher answering "Disabled by your admin" for the application. |
| [`DocumentCensoringFlow.gif`](https://github.com/DanyilT/SecDocVault/blob/main/demo/android/v0.1.1/DocumentCensoringFlow.gif) | 147 frames: a document with an email address, a phone number and a card number (test data) censored with black boxes, and the buttons to save the censored version, save offline, delete from the cloud and enable the key backup. |
| [`PreviewDocumentFlow.gif`](https://github.com/DanyilT/SecDocVault/blob/main/demo/android/v0.1.1/PreviewDocumentFlow.gif) | 337 frames: a document with two images, decrypted on tap, with the switch between the files and the export of the file. |
| [`UploadDocumentFlow.gif`](https://github.com/DanyilT/SecDocVault/blob/main/demo/android/v0.1.1/UploadDocumentFlow.gif) | 635 frames: adding two images from the gallery, naming the document, setting the options (key recovery, upload to the cloud, local encrypted copy) and uploading it. |

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`original/group_project_proposal.pdf`](original/group_project_proposal.pdf) | The proposal (5 pages, 26 December 2025): the introduction, the description and architecture (Firebase services, the Android Keystore for the master key, client-side encryption), the scope, the functional requirements, five risks with mitigations (encryption implementation errors, master key compromise, unauthorised device access, weak authentication, data exposure in transmission) and the conclusion. |
| [`original/diagrams/group_project_proposal_diagram.drawio`](original/diagrams/group_project_proposal_diagram.drawio) | The diagram of the proposal (draw.io), drawn by Illia Stefanovskyi: the client, Firestore and Firebase Storage with the numbered steps of the login and the document decryption, and the logical data schema (users, devices, documents and encrypted files). |
| [`original/diagrams/group_project_proposal_diagram.drawio.png`](original/diagrams/group_project_proposal_diagram.drawio.png) | The diagram of the proposal as an image (PNG, 1931 x 1662 pixels, transparent background), exported from draw.io with the diagram data embedded, so draw.io can open the image for editing. |
| [`original/diagrams/group_project_global_design_and_structure_diagram.drawio`](original/diagrams/group_project_global_design_and_structure_diagram.drawio) | The global design and structure diagram (draw.io), drawn by Illia Stefanovskyi: the screens and flows of the client (login, password reset, main interface, upload form with the backup creation, sharing requests, deletion, restore from backup) and the Firebase side (the Firestore collections vault and vaultUsers, the Storage paths and the Realtime Database for the sharing requests). |
| [`original/diagrams/group_project_global_design_and_structure_diagram.drawio.png`](original/diagrams/group_project_global_design_and_structure_diagram.drawio.png) | The global design and structure diagram as an image (PNG, 2410 x 3696 pixels, transparent background), exported from draw.io with the diagram data embedded. |
| [`original/group_project_thesis.pdf`](original/group_project_thesis.pdf) | The thesis (18 pages, May 2026): the abstract, the introduction with the research questions and objectives, the literature review, the methodology, the system design, the implementation, the security analysis and testing results, the conclusions, the future work and the references. |
| [`original/group_project_demo.pdf`](original/group_project_demo.pdf) | The presentation and demo of 14 May 2026 (37 slides): the walkthrough (registration, login, unlock method, home screen), the document lifecycle (upload and encryption, decryption and export, backup restoration, sharing), the other features (censoring, export, metadata editing, storage mode, guest account, background privacy screen) and the test coverage. |
| [`extension/group_project_extension_draft_idea.pdf`](extension/group_project_extension_draft_idea.pdf) | The draft idea of the extension (3 pages): the extension of the previous project into privacy and security research (privacy and data protection law, cryptography and key management, anonymity and digital fingerprinting, zero-knowledge architecture, cloud and storage security, data remanence, threat modelling, pentesting methodology, the test of SecDocVault, findings and fixes, a post-quantum look) and the split of the work by theme. |
| [`extension/resources/group_project_extension_work_plan.pdf`](extension/resources/group_project_extension_work_plan.pdf) | The work plan of the extension (1 page): the work split by theme, exported from a Google Sheet (linked above) while the work was in progress. For each theme and thesis section it gives who writes it, the key topics, the week (nine weeks from 30 June to 25 August 2026) and the status (done, in progress or not started). |
| [`extension/group_project_extension_thesis.pdf`](extension/group_project_extension_thesis.pdf) | The thesis of the extension, SecDocVault: Privacy & Security Research (234 pages, July-August 2026): the introduction with the hypothesis and four research questions, the literature review (anonymity and digital fingerprinting, privacy and data protection, cryptography), the methodology, the system design and implementation, the testing and experimental analysis (functional, non-functional, the TA series, OWASP MASVS, data protection), the final evaluation with the recommendations, the references and appendix A with the reproduction scripts of the tests. |
| [`extension/group_project_extension_demo.pdf`](extension/group_project_extension_demo.pdf) | The presentation and demo of the extension (19 slides): why the research, the literature review and the gap, the hypothesis and research questions, the methodology, the application, the nine claims under test, the testing results and findings, the comparison with related research, the recommendations and the conclusion. |
