select title, length, release_year, rental_rate, special_features
from film
where rating = 'R'
order by length desc
limit 10;