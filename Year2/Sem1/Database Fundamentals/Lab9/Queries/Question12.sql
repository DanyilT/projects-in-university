SELECT R.Fname AS "Renter First Name", R.Lname AS "Renter Last Name", V.Pno AS "Property No", V.Comment
FROM Renter R
INNER JOIN Viewing V ON R.Rno = V.Rno;
