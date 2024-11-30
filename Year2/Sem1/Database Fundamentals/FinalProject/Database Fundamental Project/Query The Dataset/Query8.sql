SELECT COUNT(*) AS "Student Count"
FROM Students s
JOIN Courses c ON s.course_id = c.course_id
JOIN Departments d ON c.department_id = d.department_id
WHERE d.name = 'School of Business';
