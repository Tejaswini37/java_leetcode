# Write your MySQL query statement below

-- SELECT COUNT(DISTINCT value) AS distinct_count
-- FROM your_table;

-- add 1 day to given date
-- DATE_ADD(date_value, INTERVAL N DAY)
-- date_sub


select round(
    count(distinct player_id)/(select count(distinct player_id) from activity)
    ,2) as fraction 
    from activity
where (player_id,date_sub(event_date, interval 1 day)) in
(select player_id,min(event_date) from activity group by player_id);