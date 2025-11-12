SELECT d.deptno AS "Department Number", d.dname AS "Department Name", SUM(e.sal + IFNULL(e.comm, 0)) AS "Total Monthly Salaries"
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno
GROUP BY d.deptno, d.dname;
