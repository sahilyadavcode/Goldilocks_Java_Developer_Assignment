--8.	Write a SQL query to find the age is less than 30 and name start with S

DROP TABLE Employees

CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Department VARCHAR(50)
);

INSERT INTO Employees (EmpID, Name, Age, Department)
VALUES
(1, 'Sahil', 25, 'IT'),
(2, 'Sneha', 28, 'HR'),
(3, 'Sam', 22, 'Finance'),
(4, 'Steve', 29, 'Marketing'),
(5, 'Rahul', 35, 'IT'),
(6, 'Priya', 31, 'HR'),
(7, 'Sonia', 27, 'Finance');


SELECT *
FROM Employees
WHERE Age < 30
  AND Name LIKE 'S%';

-- TIME TAKEN : 13MIN
