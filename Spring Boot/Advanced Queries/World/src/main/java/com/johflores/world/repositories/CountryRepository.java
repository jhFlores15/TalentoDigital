package com.johflores.world.repositories;

import com.johflores.world.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long>{

    @Query(value = "select c.name,language,percentage from languages as l\n" +
            "left join countries as c on  l.country_id = c.id\n" +
            "where language = \"Slovene\"\n" +
            "order by percentage desc",nativeQuery = true)
    List<Object[]> findAllCountriesThatSpeakSlovene();

    @Query(value = "select co.name, count(ci.id) as total_cities from countries as co \n" +
            "left join cities as ci on ci.country_id = co.id\n" +
            "group by co.id\n" +
            "order by total_cities desc",nativeQuery = true)
    List<Object[]> findAllCountriesAndTheirNumbCities();

    @Query(value="select ci.name, ci.population from countries as co \n" +
            "left join cities as ci on ci.country_id = co.id\n" +
            "where co.id = 136 and ci.population > 500000\n" +
            "order by population desc",nativeQuery = true)
    List<Object[]> findBigMexicoCities();

    @Query(value = "select countries.name, languages.language, languages.percentage\n" +
            "from languages\n" +
            "left join countries on languages.country_id = countries.id\n" +
            "where percentage > 89\n" +
            "order by percentage desc",nativeQuery = true)
    List<Object[]> findMostUsedLanguages();

    @Query(value="select co.name, surface_area, population from countries as co\n" +
            "where surface_area < 501 and population > 100000\n" +
            "order by name asc" , nativeQuery=true)
    List<Object[]> findSmallCountriesWithBigPopulation();

    @Query(value="select co.name, surface_area, population from countries as co\n" +
            "where  government_form = \"Constitutional Monarchy\" and capital > 200 and life_expectancy > 75\n" +
            "order by name asc" , nativeQuery=true)
    List<Object[]> findMonarchyCountries();

    @Query(value="select co.name as country, ci.name as city,ci.district, ci.population from countries as co \n" +
            "left join cities as ci on ci.country_id = co.id\n" +
            "where co.id = 9 and ci.district = \"Buenos Aires\" and ci.population > 500000\n" +
            "order by ci.population desc" , nativeQuery=true)
    List<Object[]> findBigCitiesInBuenosAires();

    @Query(value="select co.region, count(co.id) as total_countries from countries as co \n" +
            "group by co.region\n" +
            "order by total_countries desc" , nativeQuery=true)
    List<Object[]> findCountriesByRegion();
}
