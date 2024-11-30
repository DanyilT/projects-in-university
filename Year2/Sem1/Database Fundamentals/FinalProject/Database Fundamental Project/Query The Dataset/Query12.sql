ALTER TABLE Opening_Times
MODIFY opening_time VARCHAR(50),
MODIFY closing_time VARCHAR(50);

UPDATE Opening_Times
SET opening_time = 'Closed to Visitors', closing_time = 'Closed to Visitors';
