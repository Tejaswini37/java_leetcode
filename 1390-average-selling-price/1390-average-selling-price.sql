# Write your MySQL query statement below
select p.product_id, round(ifnull(sum(s.units*p.price)/nullif(sum(s.units),0),0),2) as average_price
from prices p left join unitssold s on p.product_id=s.product_id
and s.purchase_date between p.start_date and p.end_date
group by p.product_id;

-- IFNULL()	
-- Substitute a default value if NULL	
-- IFNULL(col, 0) → if col is NULL, return 0
-- NULLIF()	
-- Returns NULL if two values are equal	
-- NULLIF(a, b) → returns NULL if a = b
