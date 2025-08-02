# Write your MySQL query statement below
select class from (
    select class ,count(distinct student) as a from courses 
    group by class having a>4
) as b;