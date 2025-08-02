# Write your MySQL query statement below
-- SELECT category,
--        COUNT(*) AS accounts_count
-- FROM (
--     SELECT 
--       CASE 
--         WHEN income < 20000 THEN 'Low Salary'
--         WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
--         ELSE 'High Salary'
--       END AS category
--     FROM Accounts
-- ) AS categorized
-- GROUP BY category
-- ORDER BY category;

select 'Low Salary' as category, count(*) as accounts_count from accounts
where income<20000
union 
select 'Average Salary' as category, count(*) as accounts_count from accounts
where income between 20000 and 50000
union 
select 'High Salary' as category, count(*) as accounts_count from accounts 
where income>50000;


