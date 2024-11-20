SELECT e.empno AS "Employee Number", e.ename AS "Employee Name", d.deptno AS "Department Number", d.dname AS "Department Name"
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno;
