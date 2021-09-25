select rating, count(*)
from film
         left join language l on film.language_id = l.language_id
where l.name = 'French'
group by rating