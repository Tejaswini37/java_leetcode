# Write your MySQL query statement below

select * from users
where regexp_like(mail,'^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$','c');
-- 'c' → Enables case-sensitive matching ('i' would make it case-insensitive).

-- com  COM
-- select * from users
-- where mail regexp '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$';

-- and right(mail,13)='@leetcode.com'