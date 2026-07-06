
DROP TABLE A

-- Create Table A
CREATE TABLE A (
    id INT,
    name VARCHAR(50),
    date DATE
);

DROP TABLE B


-- Create Table B
CREATE TABLE B (
    id INT,
    name VARCHAR(50),
    date DATE
);

-- Insert sample data into A
INSERT INTO A (id, name, date) VALUES
(1, 'Sahil', '2023-04-01'),
(2, 'Ravi', '2023-04-02'),
(3, 'Sahil', '2023-04-03'),
(4, 'Amitabh', '2023-04-04'),
(5, 'Sahil', '2023-04-05');

-- Insert sample data into B
INSERT INTO B (id, name, date) VALUES
(3, 'Sahil', '2023-04-03'),
(6, 'Ramesh', '2023-04-06'),
(7, 'Amitabh', '2023-04-07');

---------------------------------------------------
-- a. Union of A and B
---------------------------------------------------
SELECT id, name, date FROM A
UNION
SELECT id, name, date FROM B;

---------------------------------------------------
-- b. Records present in A and not in B (using NOT EXISTS)
---------------------------------------------------
SELECT id, name, date
FROM A a
WHERE NOT EXISTS (
    SELECT 1 FROM B b
    WHERE a.id = b.id AND a.name = b.name AND a.date = b.date
);

---------------------------------------------------
-- c. Records unique to each table (symmetric difference)
---------------------------------------------------
SELECT id, name, date
FROM A a
WHERE NOT EXISTS (
    SELECT 1 FROM B b
    WHERE a.id = b.id AND a.name = b.name AND a.date = b.date
)
UNION
SELECT id, name, date
FROM B b
WHERE NOT EXISTS (
    SELECT 1 FROM A a
    WHERE a.id = b.id AND a.name = b.name AND a.date = b.date
);

---------------------------------------------------
-- d. Count of records in A where name appears more than 2 times
---------------------------------------------------
SELECT name, COUNT(*) AS cnt
FROM A
GROUP BY name
HAVING COUNT(*) > 2;
