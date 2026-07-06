-- Create Table C (first names)
CREATE TABLE C (
    id INT,
    name VARCHAR(50)
);

-- Create Table D (last names)
CREATE TABLE D (
    id INT,
    name VARCHAR(50)
);

-- Insert sample data into C
INSERT INTO C (id, name) VALUES
(1, 'Sahil'),
(2, 'Ravi'),
(3, 'Amitabh');

-- Insert sample data into D
INSERT INTO D (id, name) VALUES
(1, 'Sharma'),
(2, 'Kumar'),
(3, 'Bachchan');

---------------------------------------------------
-- Combine C and D into full name
---------------------------------------------------
SELECT C.id, CONCAT(C.name, ' ', D.name) AS full_name
FROM C
JOIN D ON C.id = D.id;
