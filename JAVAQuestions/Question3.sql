DROP  DATABASE student;
-- Create the database
CREATE DATABASE student;

-- Switch to the database
USE student;

-- Create the table "test" with the required schema

DROP TABLE TEST;
CREATE TABLE test (
    `Emp name` VARCHAR(200),
    `Emp age` INT(10)
);

-- Insert some sample data
INSERT INTO test (`Emp name`, `Emp age`) VALUES
('Sahil', 25),
('Ravi', 35),
('Amitabh', 60);
