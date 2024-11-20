SELECT d.deptno AS "Department Number", d.dname AS "Department Name", e.ename AS "Employee Name"
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno
ORDER BY d.deptno ASC, e.ename ASC;
