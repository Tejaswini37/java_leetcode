# Write your MySQL query statement below
select p2.person_name from queue p1 join queue p2
on p1.turn<=p2.turn
group by p2.turn,p2.person_name
having sum(p1.weight)<=1000
order by sum(p1.weight) desc
limit 1;