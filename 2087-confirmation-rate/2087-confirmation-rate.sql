# Write your MySQL query statement below
-- select s.user_id,round(
--     ifnull(sum(c.action='confirmed')/count(s.user_id),0),
--     2) as confirmation_rate
-- from signups s left join confirmations c
-- on s.user_id=c.user_id 
-- group by s.user_id;

-- A boolean condition like c.action = 'confirmed' evaluates to:
-- 1 if true,
-- 0 if false,
-- NULL if c.action is NULL

select s.user_id,round(
    ifnull(sum(c.action='confirmed')/count(*),0),
    2) as confirmation_rate
from signups s left join confirmations c
on s.user_id=c.user_id 
group by s.user_id;