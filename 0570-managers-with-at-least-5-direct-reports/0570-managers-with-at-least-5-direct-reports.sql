# Write your MySQL query statement below
select e2.name from employee e1
join employee e2 on e1.managerId=e2.id
where e1.id<>e1.managerId 
group by e2.id,e2.name
HAVING count(*)>=5;
