-- 6.	In tables above find the name start with S. Find the name having “so”
--  in the name for A table
SELECT * FROM A WHERE name LIKE 'S%';

-- Names containing "so"
SELECT * FROM A WHERE name LIKE '%so%';
