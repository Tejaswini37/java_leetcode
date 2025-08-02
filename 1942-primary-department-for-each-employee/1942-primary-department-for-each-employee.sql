# Write your MySQL query statement below
select employee_id,dePARTMENT_ID from employee where primary_flag='Y' or 
employee_id in (select employee_id from employee group by employee_id having count(*)=1);