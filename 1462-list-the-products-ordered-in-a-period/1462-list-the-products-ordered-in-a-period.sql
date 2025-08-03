# Write your MySQL query statement below
select p.product_name,sum(o.unit) as unit
from orders o left join products p on o.product_id=p.product_id
where month(o.order_date)=2 and year(o.order_date)=2020
group by o.product_id,p.product_name
having unit>=100;
