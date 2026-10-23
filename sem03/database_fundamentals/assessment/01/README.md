# Assessment 1: Database for a university office

**Module:** Database Fundamentals (`COMP H1029`)  
**Semester:** 3 (Year 2), folder `sem03`  
**Type:** project, individual  
**Weight:** 40%  
**Deadline:** 26 November 2024  
**Result:** 32.8/40 (82%)  
**On main:** [`sem03/database_fundamentals/assessment/01/`](https://github.com/DanyilT/projects-in-university/tree/main/sem03/database_fundamentals/assessment/01) (the brief, the link file and this README)  
**Branch:** [`project/year02/module-database_fundamentals/develop-database-system-for-university-office`](https://github.com/DanyilT/projects-in-university/tree/project/year02/module-database_fundamentals/develop-database-system-for-university-office) (the report PDF, the conceptual, logical and physical ERDs, the relational EER diagram and the Workbench model, the DDL and DML scripts and the 20 query files)  
**Repository:** —

[Module README](../../README.md)

## What this assessment is for

The brief (3 pages) asks for a database system for a university office: courses at levels 6 to 10, departments, the academic and personal information of the learners, end-of-year results and opening times, with at least 10 rows in each table. It suggests Mockaroo (https://www.mockaroo.com) for generating data. The project has three tasks: the database design (40% of the project: the entities, relationships and business rules, the conceptual, logical and physical ERDs and the relational model in third normal form), the creation and population of the database (the DDL statements for the tables and the DML statements that insert at least 10 rows into each table) and 20 queries on the dataset (updates for year 1 to year 2, course status, opening times, phone number and dean; deletes; a descending list of grades; a count of business students; staff with more than 4 years of service; courses over 3 semesters; addresses containing "road"; and a view over three tables).

The submission is a report with the diagrams, screenshots and a narrative, and an SQL script with each statement labelled by its question number. The database has six tables: Departments, Courses, Students, Staff, Results and Opening_Times. The files are on the branch linked above; the screenshots below show the first 8 pages of the report, the three ERDs (photographs of hand-drawn diagrams), the relational EER diagram from MySQL Workbench, the DDL and DML statements and the 20 queries, one for each question of task 3.

<table>
  <tr valign="top">
    <td colspan="3"><img src="../../.screenshots/assessment/01/screenshot.png" alt="Project report, pages 1 to 8"><br><i>The first 8 of 34 pages of the project report: the title page with the table of contents and the introduction, then the start of task one (the entities, the relationships, the conceptual ER diagram and the logical ER diagram).</i></td>
  </tr>
  <tr valign="top">
    <td width="33%"><img src="../../.screenshots/assessment/01/conceptual_erd.jpg" alt="Conceptual ERD"><br><i>Conceptual ERD (hand-drawn).</i></td>
    <td width="33%"><img src="../../.screenshots/assessment/01/logical_erd.jpg" alt="Logical ERD"><br><i>Logical ERD (hand-drawn).</i></td>
    <td width="33%"><img src="../../.screenshots/assessment/01/physical_erd.jpg" alt="Physical ERD"><br><i>Physical ERD (hand-drawn).</i></td>
  </tr>
  <tr valign="top">
    <td width="33%"><img src="../../.screenshots/assessment/01/eer_diagram.png" alt="EER diagram"><br><i>The relational EER diagram from MySQL Workbench.</i></td>
    <td width="33%"><img src="../../.screenshots/assessment/01/ddl_statements.png" alt="DDL statements"><br><i>The DDL statements that create the database.</i></td>
    <td width="33%"><img src="../../.screenshots/assessment/01/dml_statements.png" alt="DML statements"><br><i>The DML statements that fill it.</i></td>
  </tr>
</table>
<table>
  <tr valign="top">
    <td width="25%"><img src="../../.screenshots/assessment/01/query_01.png" alt="Query 1"><br><i>Question 1 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_02.png" alt="Query 2"><br><i>Question 2 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_03.png" alt="Query 3"><br><i>Question 3 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_04.png" alt="Query 4"><br><i>Question 4 of task 3.</i></td>
  </tr>
  <tr valign="top">
    <td width="25%"><img src="../../.screenshots/assessment/01/query_05.png" alt="Query 5"><br><i>Question 5 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_06.png" alt="Query 6"><br><i>Question 6 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_07.png" alt="Query 7"><br><i>Question 7 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_08.png" alt="Query 8"><br><i>Question 8 of task 3.</i></td>
  </tr>
  <tr valign="top">
    <td width="25%"><img src="../../.screenshots/assessment/01/query_09.png" alt="Query 9"><br><i>Question 9 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_10.png" alt="Query 10"><br><i>Question 10 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_11.png" alt="Query 11"><br><i>Question 11 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_12.png" alt="Query 12"><br><i>Question 12 of task 3.</i></td>
  </tr>
  <tr valign="top">
    <td width="25%"><img src="../../.screenshots/assessment/01/query_13.png" alt="Query 13"><br><i>Question 13 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_14.png" alt="Query 14"><br><i>Question 14 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_15.png" alt="Query 15"><br><i>Question 15 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_16.png" alt="Query 16"><br><i>Question 16 of task 3.</i></td>
  </tr>
  <tr valign="top">
    <td width="25%"><img src="../../.screenshots/assessment/01/query_17.png" alt="Query 17"><br><i>Question 17 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_18.png" alt="Query 18"><br><i>Question 18 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_19.png" alt="Query 19"><br><i>Question 19 of task 3.</i></td>
    <td width="25%"><img src="../../.screenshots/assessment/01/query_20.png" alt="Query 20"><br><i>Question 20 of task 3.</i></td>
  </tr>
</table>

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`database_fundamentals_assessment.pdf`](database_fundamentals_assessment.pdf) | The project brief (3 pages, 40%, deadline 26 November 2024): a database for a university office, in three tasks: design (conceptual, logical and physical ERDs and the relational model in 3NF), create and populate the database with DDL and DML (at least 10 rows per table), and 20 queries (updates, deletes, counts, a view over three tables). |
| [`submission/project_link.txt`](submission/project_link.txt) | Two lines: the GitHub link to the project on its branch, and the branch name. |
