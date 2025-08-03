# Write your MySQL query statement below
(select u.name as results from movierating mr left join users u on mr.user_id=u.user_id
group by mr.user_id ,u.name 
order by count(*) desc,u.name limit 1)
union all
(select m.title as result from movierating mr left join movies m on mr.movie_id=m.movie_id 
where year(mr.created_at)=2020 and month(mr.created_at)=2
group by m.movie_id,m.title
order by avg(rating) DESC , m.title limit 1);