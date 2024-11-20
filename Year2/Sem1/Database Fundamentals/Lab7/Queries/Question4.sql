SELECT d.deptno AS "Department Number", d.dname AS "Department Name", d.loc AS "Location", e.empno AS "Employee Number", e.ename AS "Employee Name"
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno;
