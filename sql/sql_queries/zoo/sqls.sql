SELECT name, continent, population FROM world;

SELECT name
  FROM world
 WHERE population > 100000;
 

select name, population from world
where name IN ('France' , 'Germany' , 'Italy');

select name from world where name like '%United%';

select name, population, area from world
where area >= 3000000 or population >= 250000000;
