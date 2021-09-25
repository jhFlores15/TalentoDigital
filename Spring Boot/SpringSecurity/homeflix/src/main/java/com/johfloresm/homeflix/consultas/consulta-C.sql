select f.film_id, title, release_year, rating
from film as f
         left join film_category fc on f.film_id = fc.film_id
         left join category c on fc.category_id = c.category_id
         left join film_actor fa on f.film_id = fa.film_id
         left join actor a on fa.actor_id = a.actor_id
where c.name = 'Horror'
  and a.first_name = 'Susan'
  and a.last_name = 'Davis'