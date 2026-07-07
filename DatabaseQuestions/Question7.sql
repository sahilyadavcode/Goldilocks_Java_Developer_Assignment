-- 7.	There are 2 table C and D (with 2 columns id and name).
--  In table C name has the first name and name in Table D is last name.
--   Make a table with id, full name (first name space second name)

CREATE TABLE C (
    id INT,
    name VARCHAR(50)
);

CREATE TABLE D (
    id INT,
    name VARCHAR(50)
);

INSERT INTO C (id, name) VALUES
(1, 'Sahil'),
(2, 'Ravi'),
(3, 'Amitabh');


INSERT INTO D (id, name) VALUES
(1, 'Sharma'),
(2, 'Kumar'),
(3, 'Bachchan');


SELECT C.id, CONCAT(C.name, ' ', D.name) AS full_name
FROM C
JOIN D ON C.id = D.id;
