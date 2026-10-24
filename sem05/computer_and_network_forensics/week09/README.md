# Week 09 — Lab 6: carving a file with a hex editor

**Module:** Computer and Network Forensics (`DFCS H3011`)  
**Semester:** 5 (Year 3), folder `sem05`

[Module README](../README.md)

## What this week is for

Lab 6 carves .jpeg files out of alienimage.dd, the image of the FTK Imager lab, by hand with Hex Workshop: find the start of the file (the JFIF text string), find its end (the FFD9 hex value), select the block, copy it into a new file and open the carved image. The week's readings explain hexadecimal, magic numbers and the types of carving.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/computer_and_network_forensics_week09_lab.pdf`](lab/computer_and_network_forensics_week09_lab.pdf) | The lab sheet (24 pages): Using a Hex Editor to Carve a file. |
| [`lab/resources/AlienImage.zip`](lab/resources/AlienImage.zip) | The evidence of the lab (1.7 MB zip): alienimage.dd (227 MB unzipped), alienimage.md5 and alienimage.txt, the image of the FTK Imager lab. |
| [`lab/solution/computer_and_network_forensics_week09_lab_report.pdf`](lab/solution/computer_and_network_forensics_week09_lab_report.pdf) | The solution (4 pages): the steps of the carving with screenshots. |
| [`resources/Different types of Carving in Digital Forensics.pdf`](resources/Different%20types%20of%20Carving%20in%20Digital%20Forensics.pdf) | Different types of Carving in Digital Forensics (2 pages): file carving, data carving and disk carving. |
| [`resources/HEX Explained.pdf`](resources/HEX%20Explained.pdf) | HEX Explained (5 pages): hexadecimal in digital forensics and the FAT file system. |
| [`resources/Magic Numbers in Digital Forensics.pdf`](resources/Magic%20Numbers%20in%20Digital%20Forensics.pdf) | Magic Numbers in Digital Forensics: Identification, Application, and Significance by Michael Hegarty (5 pages). |
