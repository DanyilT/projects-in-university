SELECT * FROM emp;
-- 1
SELECT deptno, COUNT(*) AS 'NUMBER OF EMPLOYEEES'
FROM emp
GROUP BY deptno
HAVING COUNT(*) > 4;

-- 2
select mgr, min(sal) as 'Lowest paid salary'
from emp
group by mgr
having min(sal) > 1000
order by min(sal);

-- 3
select e.empno, e.ename, e.deptno, d.dname
from emp e inner join dept d
WHERE e.deptno = d.deptno;

-- 4
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno;

-- 5
select e.ename, e.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
order by ename, dname;
-- could also order by empno instead of ename - its not clear from the query

-- 6
/*The SUM function returns NULL if there is no matching row. 
Sometimes, you want the SUM function to return zero instead of NULL. 
If expr1 is not NULL, IFNULL() returns expr1; 
otherwise it returns expr2. 
IFNULL() returns a numeric or string value, 
depending on the context in which it is used. 
*/

select d.deptno, d.dname, SUM(sal + IFNULL(comm,0)) #sum(sal) + IFNULL(sum(comm),0)
from emp e inner join dept d
on e.deptno = d.deptno 
group by deptno;

#aside
SELECT * FROM dept;
SELECT sum(sal+comm) 
FROM emp
WHERE comm IS NOT NULL;
#end aside

-- 7
select d.deptno, d.dname, count(*)
from emp e inner join dept d
on e.deptno = d.deptno 
group by deptno;

-- 8
select d.deptno, d.dname, count(*)
from emp e inner join dept d
on e.deptno = d.deptno 
group by deptno
having count(*) > 4;


-- 9
select e.ename, g.grade
from emp e inner join salgrade g
on e.sal >= g.losal and e.sal <=g.hisal;

-- 10
select ename, g.grade, e.job, e.sal
from emp e inner join salgrade g
on e.sal >= g.losal and e.sal <=g.hisal;

-- 11
select e1.ename as 'employee name', e1.empno as 'employee ID', 
e2.empno as 'managers number', e2.ename as 'managers name'
from emp e1 inner join emp e2
ON e1.mgr = e2.empno;

SELECT * FROM emp;
