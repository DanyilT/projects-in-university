-- Create a Database called Football 
create database if not exists football;
use football;

--Create a table called premiership in Football database;
CREATE TABLE if not exists premiership(
   Team  VARCHAR (50),
   Played INT,
   Points INT,
   CONSTRAINT premiership_PK PRIMARY KEY (Team));
);

USE football;
--Insert the records into the premiership table.
INSERT INTO premiership (Team, Played, Points)
VALUES ('Juventus', 12, 34);

INSERT INTO premiership (Team, Played, Points)
VALUES ('Man Utd', 11, 29);

INSERT INTO premiership (Team, Played, Points)
VALUES ('Barcelona', 10, 25);

INSERT INTO premiership (Team, Played, Points)
VALUES ('Liverpool', 12, 23);

INSERT INTO premiership (Team, Played, Points)
VALUES ('Arsenal', 14, 26);

--Change the name Juventus to Napoli
UPDATE premiership 
SET 
    Team = 'Napoli'
WHERE
    Team = 'Juventus';

--Change the No of games played by an extra 2 for all teams	
UPDATE  premiership 
SET played=played + 2
where team <> "";

--Show full details of all teams who have played more than 12 games and have less than 30 points
SELECT * FROM premiership
WHERE played > 12
AND points < 30;

--Delete Arsenal from the table

DELETE FROM football 
WHERE Team='Arsenal';

-- Delete all records from the Table
DELETE FROM premiership
where team <> "";



