-- Delete from Staff Table
DELETE FROM Staff 
WHERE name = 'Test Staff';

-- Delete from Opening_Times Table
DELETE FROM Opening_Times 
WHERE department_id = (SELECT department_id FROM Departments WHERE name = 'School of AI');

-- Delete from Results Table
DELETE FROM Results 
WHERE student_id = (SELECT student_id FROM Students WHERE first_name = 'Test' AND last_name = 'Student');

-- Delete from Students Table
DELETE FROM Students 
WHERE first_name = 'Test' AND last_name = 'Student';

-- Delete from Courses Table
DELETE FROM Courses 
WHERE title = 'Deep Learning';

-- Delete from Departments Table
DELETE FROM Departments 
WHERE name = 'School of AI';
