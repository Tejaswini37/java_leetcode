# Write your MySQL query statement below

SELECT class 
FROM courses 
GROUP BY class 
HAVING COUNT(DISTINCT student) > 4;

-- select class from (
--     select class ,count(distinct student) as a from courses 
--     group by class having a>4
-- ) as b;

-- every derived must have its own name . so we used b