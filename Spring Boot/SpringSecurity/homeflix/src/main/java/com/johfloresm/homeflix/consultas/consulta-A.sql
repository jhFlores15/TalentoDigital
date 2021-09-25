select film_id, title, length, rental_duration, rental_rate, rating
from film
where description like '%Secret Agent%'
  and rental_duration >= 5
order by rental_duration desc, rental_rate asc;