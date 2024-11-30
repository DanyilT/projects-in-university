CREATE VIEW Student_Course_Grades AS
SELECT s.first_name, s.last_name, c.title AS course_title, r.grade
FROM Students s
JOIN Courses c ON s.course_id = c.course_id
JOIN Results r ON s.student_id = r.student_id;

SELECT * FROM Student_Course_Grades;
