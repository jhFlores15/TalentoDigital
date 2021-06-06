-- 1)
select customer.first_name, customer.last_name, address.address from customer 
join address on address.address_id = customer.address_id
join city on city.city_id = address.city_id
where city.city_id = 312;

-- 2)
select f.title,f.description, f.release_year,f.rating, f.special_features, c.name from film as f
left join film_category as fc on fc.film_id = f.film_id
left join category as c on c.category_id = fc.category_id
where c.category_id = 5;

-- 3)
select distinct a.actor_id, a.first_name, f.title ,f.description, f.release_year from film as f
right join film_actor as fa on fa.film_id = f.film_id
left join actor as a on a.actor_id = fa.actor_id
where a.actor_id  = 5;

-- 4)
select c.first_name, c.last_name, c.email, adds.address, ci.city from customer as c
left join address as adds on adds.address_id = c.address_id
join city as ci on ci.city_id = adds.city_id
where store_id = 1 and adds.city_id in (1,42,312,459);

-- 5)
select f.title, f.rating,f.special_features from film as f
left join film_actor as fa on fa.film_id = f.film_id
where f.rating  = "G" and f.special_features like "%Deleted Scenes%" and fa.actor_id = 15;

-- 6)
select f.film_id, f.title, a.actor_id, a.first_name  from actor as a
left join film_actor as fa on fa.actor_id = a.actor_id
left join film as f on f.film_id = fa.film_id
where fa.film_id = 369;

-- 7)
select f.title, f.release_year,f.rating, f.special_features, c.name, f.rental_rate from film as f
left join film_category as fc on fc.film_id = f.film_id
left join category as c on c.category_id = fc.category_id
where c.category_id = 7 and f.rental_rate = 2.99;

-- 8)
select distinct f.title, f.description, f.release_year,f.rating, f.special_features, c.name, concat(a.first_name,' ',a.last_name)  from film as f
 inner join film_actor as fa on f.film_id = fa.film_id
 inner join actor as a on a.actor_id = fa.actor_id
 inner join film_category as fc on fc.film_id = f.film_id
 inner join category as c on c.category_id = fc.category_id 
where c.name = "Action" and a.first_name ="SANDRA" and a.last_name="KILMER";


