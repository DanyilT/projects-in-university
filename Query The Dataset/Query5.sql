-- Add to Departments Table
INSERT INTO Departments (name, school, phone_number) 
VALUES ('School of AI', 'Artificial Intelligence', '01-9876543');

-- Add to Courses Table
INSERT INTO Courses (title, academic_level, department_id, delivery_method, semesters, participants) 
VALUES ('Deep Learning', 9, (SELECT department_id FROM Departments WHERE name = 'School of AI'), 'Online', 6, 40);

-- Add to Students Table
INSERT INTO Students (first_name, last_name, date_of_birth, address, email, course_id, outstanding_fees_due, year, status) 
VALUES ('Test', 'Student', '2003-01-01', 'Test Address', 'test.student@example.com', (SELECT course_id FROM Courses WHERE title = 'Deep Learning'), 0, 1, 'Active');

-- Add to Results Table
INSERT INTO Results (student_id, grade) 
VALUES ((SELECT student_id FROM Students WHERE first_name = 'Test' AND last_name = 'Student'), 'A');

-- Add to Opening_Times Table
INSERT INTO Opening_Times (department_id, day, opening_time, closing_time) 
VALUES ((SELECT department_id FROM Departments WHERE name = 'School of AI'), 'Saturday', '09:00:00', '17:00:00');

-- Add to Staff Table
INSERT INTO Staff (name, job_title, department_id, years_at_university, days_off) 
VALUES ('Test Staff', 'Lecturer', (SELECT department_id FROM Departments WHERE name = 'School of AI'), 1, 2);
