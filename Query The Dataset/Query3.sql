DELETE FROM Results
WHERE student_id IN (
    SELECT student_id
    FROM Students
    WHERE outstanding_fees_due > 6
);

DELETE FROM Students
WHERE outstanding_fees_due > 6;
