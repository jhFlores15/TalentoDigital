select first_name, last_name, count(*) as count
from actor as a
    left join film_actor fa on a.actor_id = fa.actor_id
    left join film f on fa.film_id = f.film_id
where rating in ('PG', 'PG-13', 'G')
group by a.actor_id
order by count desc
