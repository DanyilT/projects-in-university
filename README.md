# Network Security: T-Pot Multi-Honeypot Platform

**Module:** Network Security (`MACSH6011`, `DFCS H4015`)  
**Programme:** BSc (Hons) Digital Forensics & Cybersecurity  
**Lecturer:** Mark Lane  
**Assessment:** Assignment 1, individual, 60% of the continuous assessment  
**Given out:** 15 September 2026  
**Report due:** 23:00 on Sunday 1 November 2026, uploaded to Brightspace as a `.docx` file  
**Demonstration:** week of 2 November 2026, about 10 minutes, to be confirmed. The demonstration carries 80% of the marks and the report 20%.

## The assignment

The assignment deploys the T-Pot honeypot platform in the cloud, collects attack data for two weeks, analyses the data and presents the findings in a report and a demonstration. The honeynet has three T-Pot instances, in Europe, the United States and Asia.

## The report

The report is written in Google Docs: [the document](https://docs.google.com/document/d/1PoFXXT1YGmrjO75n91moh7J_i7tb-1PvOkWucJvkD7I) and its [published version](https://docs.google.com/document/d/e/2PACX-1vSs7gTXYgFioTxSzzFvKPTPy-hcnEqJ2bC_jEShn-_JllUkm3Ndy98v7Og-_tTIhUvH5_mzsJFi0BFA/pub). The file uploaded to Brightspace is a `.docx`. [`network_security_report.pdf`](network_security_report.pdf) is the same report as a PDF, and [`network_security_report.md`](network_security_report.md) is a Markdown copy of it.

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`network_security_report.pdf`](network_security_report.pdf) | The report as a PDF. |
| [`network_security_report.md`](network_security_report.md) | The report in Markdown, with the figures and the screenshots linked from this folder. |
| [`REPRODUCE.md`](REPRODUCE.md) | The deployment steps, the data export and the commands that rebuild the tables and figures. |
| [`analysis/export_es.py`](analysis/export_es.py) | Exports the events of one T-Pot instance from Elasticsearch to gzipped JSON lines, one file per UTC day. It runs on the VM with the Python 3 standard library. |
| [`analysis/analyse_instance.py`](analysis/analyse_instance.py) | Summarises the exported events of one instance into CSV tables and `summary.json` (Tables 1 to 3 and D1 to D6 of the report). |
| [`analysis/ssh_sessions.py`](analysis/ssh_sessions.py) | Groups the Cowrie events of the three instances into sessions and measures how well the key file, the unlock command and the SSH client fingerprints pick out the key-writing sessions (Tables 4 and 5). |
| [`analysis/php_sequences.py`](analysis/php_sequences.py) | Groups the libredtail requests into runs and tests whether each run follows the 49-request script (Tables 6 and 7). |
| [`analysis/php_probes.py`](analysis/php_probes.py) | Counts the PHP-targeted requests of the web honeypots by probe family (Table D7). |
| [`analysis/load_local_es.py`](analysis/load_local_es.py) | Loads the daily exports into a local Elasticsearch, which Kibana reads. |
| [`analysis/make_figures.py`](analysis/make_figures.py) | Draws Figures 1, 2, 4, 5, D1 and D2 with matplotlib. It needs matplotlib; the other scripts use only the Python 3 standard library. |
| [`screenshots/`](screenshots/) | Elasticsearch and Kibana screenshots of the pages behind the counts and tables of the report, shown in Appendix A of the report. A file name is `<area>-<topic>-<region>.png`. |
| [`figures/`](figures/) | The figures that `analysis/make_figures.py` draws, and the dashboard of Figure 3, cropped from a screenshot. |
