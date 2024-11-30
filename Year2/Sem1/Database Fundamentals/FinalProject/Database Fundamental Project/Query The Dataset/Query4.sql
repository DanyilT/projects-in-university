SELECT s.first_name AS "First Name", s.last_name AS "Last Name", r.grade AS "Last Grade"
FROM Students s
JOIN Results r ON s.student_id = r.student_id
WHERE r.result_id IN (SELECT MAX(result_id) FROM Results GROUP BY student_id)
ORDER BY r.grade ASC;
