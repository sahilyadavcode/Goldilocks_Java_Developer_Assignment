-- 8.	Find the count of records with name as Amitabh in both the tables.

SELECT 'TableA' AS table_name, COUNT(*) AS cnt
FROM A WHERE name = 'Amitabh'
UNION
SELECT 'TableB', COUNT(*)
FROM B WHERE name = 'Amitabh';
