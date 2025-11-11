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
