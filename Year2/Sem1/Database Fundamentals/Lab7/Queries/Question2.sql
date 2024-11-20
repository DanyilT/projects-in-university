SELECT e.mgr AS "Manager ID", MIN(e.sal) AS "Lowest paid Salary"
FROM emp e
WHERE e.mgr IS NOT NULL
GROUP BY e.mgr
HAVING MIN(e.sal) >= 1000
ORDER BY "Lowest paid Salary" ASC;
