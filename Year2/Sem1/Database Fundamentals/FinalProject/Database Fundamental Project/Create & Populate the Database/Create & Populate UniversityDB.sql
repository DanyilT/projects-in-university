-- Create Database
CREATE DATABASE UniversityDB;
USE UniversityDB;

-- Create Tables
-- Departments Table
CREATE TABLE Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    school VARCHAR(100) NOT NULL,
    phone_number CHAR(15) NOT NULL
);

-- Courses Table
CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    academic_level INT NOT NULL,
    department_id INT NOT NULL,
    delivery_method VARCHAR(50) NOT NULL,
    semesters INT NOT NULL,
    participants INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

-- Students Table
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course_id INT NOT NULL,
    outstanding_fees_due INT DEFAULT 0 NOT NULL,
    year INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

-- Results Table
CREATE TABLE Results (
    result_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    grade CHAR(2) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

-- Opening_Times Table
CREATE TABLE Opening_Times (
    time_id INT AUTO_INCREMENT PRIMARY KEY,
    department_id INT NOT NULL,
    day VARCHAR(20) NOT NULL,
    opening_time TIME NOT NULL,
    closing_time TIME NOT NULL,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

-- Staff Table
CREATE TABLE Staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    department_id INT NOT NULL,
    years_at_university INT NOT NULL,
    days_off INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

-- Populate Tables
-- Departments Table
INSERT INTO Departments (name, school, phone_number) VALUES
('School of Computing', 'Computing', '123456789'),
('School of Business', 'Business', '123456789'),
('School of Magic', 'Magic', '123456789'),
('School of Arts', 'Arts', '123456789'),
('School of Sciences', 'Sciences', '123456789'),
('School of Law', 'Law', '123456789'),
('School of Medicine', 'Medicine', '123456789'),
('School of Education', 'Education', '123456789'),
('School of Social Sciences', 'Social Sciences', '123456789'),
('School of Music', 'Music', '123456789');

-- Courses Table
INSERT INTO Courses (title, academic_level, department_id, delivery_method, semesters, participants) VALUES
('Cyber Security', 8, 1, 'On-Campus', 8, 30),
('Computer Science', 7, 1, 'Online', 6, 50),
('Business Administration', 6, 2, 'Online', 3, 25),
('Accounting Disappearance', 10, 2, 'Hybrid', 1, 10),
('Houdini Tricks', 7, 3, 'On-Campus', 3, 10),
('Advanced Potions', 9, 3, 'Hybrid', 1, 20),
('Fine Arts', 8, 4, 'On-Campus', 6, 15),
('Black Square is the Best Art?', 6, 4, 'Online', 2, 5),
('Physics', 9, 5, 'Online', 8, 30),
('Astrophysics', 10, 5, 'Online', 2, 12),
('Corporate Law', 9, 6, 'On-Campus', 2, 18),
('Batman\'s Law', 10, 6, 'On-Campus', 10, 1),
('Pharmacy', 9, 7, 'On-Campus', 8, 30),
('Medical Sciences', 10, 7, 'Hybrid', 9, 35),
('Education Theory', 5, 8, 'Online', 1, 22),
('Artificial Intelligence', 10, 8, 'Online', 6, 15),
('Cultural Studies', 7, 9, 'On-Campus', 2, 28),
('Civil Engineering', 8, 3, 'Hybrid', 6, 18),
('Musical Composition', 10, 10, 'Hybrid', 9, 10),
('Stop Listenig Pop', 4, 10, 'Online', 1, 10);

-- Students Table
INSERT INTO Students (first_name, last_name, date_of_birth, address, email, course_id, outstanding_fees_due, year, status) VALUES
('Dany', 'qwerty', '2004-12-08', 'Far Far Away', 'qwerty@dany.com', 1, 0, 2, 'Active'),
('John', 'Doe', '2000-05-15', '123 Maple Street', 'johndoe@gmail.com', 1, 0, 1, 'Active'),
('Jane', 'Smith', '1999-10-22', '456 Oak Avenue', 'janesmith@gmail.com', 2, 2, 2, 'Active'),
('Alice', 'Brown', '2001-01-17', '789 Pine Lane', 'alicebrown@gmail.com', 3, 6, 1, 'Active'),
('Bob', 'White', '1998-07-10', '321 Elm Drive', 'bobwhite@gmail.com', 4, 0, 3, 'Active'),
('Charlie', 'Green', '2002-09-25', '654 Birch Road', 'charliegreen@gmail.com', 5, 3, 1, 'Active'),
('David', 'Black', '2000-02-14', '987 Cedar Boulevard', 'davidblack@gmail.com', 6, 0, 2, 'Active'),
('Emma', 'Gray', '1999-06-30', '111 Spruce Street', 'emmagray@gmail.com', 7, 0, 4, 'Completed'),
('Frank', 'Blue', '2001-12-12', '222 Walnut Way', 'frankblue@gmail.com', 8, 4, 3, 'Active'),
('Grace', 'Yellow', '2000-03-21', '333 Chestnut Court', 'gracey@gmail.com', 9, 0, 2, 'Active'),
('Hannah', 'Purple', '1998-11-11', '444 Aspen Place', 'hannahp@gmail.com', 10, 0, 4, 'Completed'),
('Ivy', 'Orange', '2001-05-05', '555 Maple Lane', 'ivyorange@gmail.com', 12, 0, 1, 'Active'),
('Jack', 'Red', '1997-07-16', '666 Pine Court', 'jackred@gmail.com', 13, 8, 3, 'Active'),
('Karen', 'Pink', '2003-11-23', '777 Cedar Drive', 'karenpink@gmail.com', 14, 0, 2, 'Active'),
('Leo', 'Brown', '2002-08-10', '888 Birch Avenue', 'leobrown@gmail.com', 15, 1, 1, 'Active'),
('Maria', 'Silver', '1999-09-18', '999 Aspen Street', 'mariasilver@gmail.com', 16, 0, 4, 'Completed'),
('Nathan', 'Gold', '2000-04-12', '101 Elm Road', 'nathangold@gmail.com', 17, 0, 3, 'Active'),
('Olivia', 'Teal', '2001-06-28', '202 Walnut Boulevard', 'oliviateal@gmail.com', 18, 0, 2, 'Active'),
('Paul', 'Green', '1998-02-20', '303 Spruce Lane', 'paulgreen@gmail.com', 19, 6, 4, 'Completed'),
('Quinn', 'Blue', '1997-01-14', '404 Chestnut Drive', 'quinnblue@gmail.com', 20, 0, 1, 'Active');

-- Results Table
INSERT INTO Results (student_id, grade) VALUES
(1, 'A'), (1, 'A'),
(2, 'B'),
(3, 'C'), (3, 'B'),
(4, 'B'),
(5, 'A'), (5, 'A'), (5, 'A'),
(6, 'C'),
(7, 'B'), (7, 'A'),
(8, 'A'), (8, 'A'), (8, 'A'), (8, 'A'),
(9, 'B'), (9, 'B'), (9, 'A'),
(10, 'C'), (10, 'B'),
(11, 'A'), (11, 'A'), (11, 'A'), (11, 'A'),
(12, 'B'),
(13, 'C'), (13, 'B'), (13, 'A'),
(14, 'C'), (14, 'B'),
(15, 'B'),
(16, 'A'), (16, 'A'), (16, 'A'), (16, 'A'),
(17, 'B'), (17, 'A'), (17, 'A'),
(18, 'C'), (18, 'B'),
(19, 'A'), (19, 'A'), (19, 'A'), (19, 'A'),
(20, 'B');

-- Opening_Times Table
INSERT INTO Opening_Times (department_id, day, opening_time, closing_time) VALUES
(1, 'Monday', '07:00:00', '20:00:00'),
(2, 'Tuesday', '08:30:00', '17:30:00'),
(3, 'Tuesday', '09:00:00', '19:00:00'),
(4, 'Wednesday', '08:00:00', '19:00:00'),
(5, 'Wednesday', '08:00:00', '18:00:00'),
(6, 'Thursday', '09:00:00', '18:00:00'),
(7, 'Thursday', '09:00:00', '17:00:00'),
(8, 'Friday', '10:00:00', '17:00:00'),
(9, 'Saturday', '10:00:00', '14:00:00'),
(10, 'Sunday', '12:00:00', '14:00:00');

-- Staff Table
INSERT INTO Staff (name, job_title, department_id, years_at_university, days_off) VALUES
('Prof. Nobody', 'Dean', 1, 37, 0),
('Dr. Amy Watson', 'Lecturer', 1, 5, 12),
('Mr. Mark Johnson', 'Administrator', 2, 10, 5),
('Ms. Sarah Brown', 'Assistant', 2, 2, 8),
('Dr. Michael Lee', 'Researcher', 3, 7, 10),
('Ms. Olivia Davis', 'Lecturer', 3, 3, 9),
('Mr. James Harris', 'Technician', 4, 6, 15),
('Dr. Linda Martinez', 'Researcher', 4, 9, 6),
('Ms. Emily Clark', 'Office Worker', 5, 1, 5),
('Mr. Ryan King', 'Lecturer', 5, 4, 11),
('Dr. Angela Wright', 'Lecturer', 6, 12, 18),
('Mr. Daniel Evans', 'Technician', 6, 8, 14),
('Ms. Rebecca Adams', 'Office Worker', 7, 3, 7),
('Prof. Christopher Scott', 'Dean', 7, 20, 22),
('Mr. Kevin Carter', 'Administrator', 8, 5, 9),
('Dr. Isabella Young', 'Researcher', 8, 6, 10),
('Ms. Mia Hill', 'Assistant', 9, 4, 8),
('Dr. Liam Walker', 'Lecturer', 9, 11, 16),
('Mr. William Hall', 'Technician', 10, 9, 12),
('Ms. Sophia Allen', 'Office Worker', 10, 2, 4);
