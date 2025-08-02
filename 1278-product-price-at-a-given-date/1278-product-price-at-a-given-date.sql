# Write your MySQL query statement below
-- IFNULL(new_price, 10)
-- COALESCE(NULL, NULL, 'apple', 'banana') return first not null value
-- CASE 
--     WHEN new_price IS NOT NULL THEN new_price
--     ELSE 10
select p.product_id, ifnull(latest.new_price,10) as price
from (select distinct product_id from products) p
left join (
    select product_id,new_price from products
    where change_date<='2019-08-16' and (product_id,change_date) in
    (select product_id,max(change_date) 
    from products 
    where change_date<='2019-08-16'
    group by product_id)
) latest on p.product_id=latest.product_id;