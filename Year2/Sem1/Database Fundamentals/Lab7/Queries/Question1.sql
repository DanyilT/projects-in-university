SELECT d.deptno AS "Department Number", d.dname AS "Department Name", COUNT(e.empno) AS "Number of Employees"
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno
GROUP BY d.deptno, d.dname
HAVING COUNT(e.empno) > 4;
