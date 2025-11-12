SELECT MIN(SAL) AS "Minimum Salary", 
	   MAX(SAL) AS "Maximum Salary", 
       AVG(SAL) AS "Average Salary"
FROM EMP
WHERE JOB = 'SALESMAN';
