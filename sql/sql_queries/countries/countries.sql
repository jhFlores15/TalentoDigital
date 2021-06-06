-- 1) 
select c.name,language,percentage from languages as l
left join countries as c on  l.country_id = c.id
where language = "Slovene"
order by percentage desc;

-- 2) 
select co.name, count(ci.id) as total_cities from countries as co 
left join cities as ci on ci.country_id = co.id
group by co.id
order by total_cities desc;

-- 3)
select ci.name, ci.population from countries as co 
left join cities as ci on ci.country_id = co.id
where co.id = 136 and ci.population > 500000
order by population desc;

-- 4)
select countries.name, languages.language, languages.percentage
FROM languages
left JOIN countries ON languages.country_id = countries.id
where percentage > 89
ORDER BY percentage DESC;

-- 5)
select co.name, surface_area, population from countries as co
where surface_area < 501 and population > 100000
order by name asc;

-- 6)
select co.name, surface_area, population from countries as co
where  government_form = "Constitutional Monarchy" and capital > 200 and life_expectancy > 75
order by name asc;

-- 7)
select co.name, ci.name,ci.district, ci.population from countries as co 
left join cities as ci on ci.country_id = co.id
where co.id = 9 and ci.district = "Buenos Aires" and ci.population > 500000
order by population desc;

-- 8)
select co.region, count(co.id) as total_countries from countries as co 
group by co.region
order by total_countries desc;


