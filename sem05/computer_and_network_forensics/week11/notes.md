# Notes — Week 11 Lecture
**Topic:** Review Lecture  
**Module:** Computer and Network Forensics  
**Lecturere:** Michael Hegarty  
**Date:** 24 Nov 2025 | 1-3pm  

---

**Forensics Process**
1. Identify
2. Preserve
3. Acquire
4. Analyse/Discover
5. Document and Present

**chain of custody** – Where was the evidance from whe i got it till i finish my investigation.

**Role of Investigator**
- The investigator musst be impartial and skilled  
	- Impartiality
	- Neutrality must be maintained, creditability depends on it
	- Impartiality in analysis and reporting
	- Report evidence of wrong-doing including all the facts
> _Role is to deliver the evidence, not judge or convict_

> **Just collect and present the evidences!**

**Bit-stream copy**
- Forensics duplicate of a disc
- Should be the same size as the original disc
- Should be the exact bit-by-bit copy of a disc
- must be the exact the same hash checksum
> Conduct your analysis only on a copy of the data

**Compliting the Case**
- **5W H:** Who, What, When, Where Why and How

**Secure Lab**
- Write blockers must be used when acquiring data from storage devices
- Forensics computer must be isolated from the network
- Chain of Custody
> use at least two tools

**Licensed Copies of software that we used**
- Digital evidence first responder must use validated tools (`ISO 27037`)

> [!IMPORTANT]  
> Octoder 2012 — Establishment of **ISO Formnt**

**Hasing:** interity of evidence
- single file, multiple files or the full disc (`md5`, `sha`)

**Storage Fundamentals**
- **Slack Space** is unused space in cluster
- **Unallocated Space** is space on a storage device that is not assigned to any file or directory

**Determining What Data to Collect and Analize**
> Scope creep - when an investigation expands beyond the original description

**Documenting Evidence in the Lab**
> Your goal is to be able to reproduce the same results
