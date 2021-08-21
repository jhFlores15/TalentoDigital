package com.johflores.world.services;

import com.johflores.world.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService{
    @Autowired
    CountryRepository countryRepository;

    public List<Object> queryOne() {
        List<Object[]> table = countryRepository.findAllCountriesThatSpeakSlovene();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("language",  item[1]);
            map.put("percentage ", item[2]);
            response.add(map);
        }
        return response;
    }

    public List<Object> queryTwo() {
        List<Object[]> table = countryRepository.findAllCountriesAndTheirNumbCities();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("cities",  item[1]);
            response.add(map);
        }
        return response;
    }

    public List<Object> queryThree() {
        List<Object[]> table = countryRepository.findBigMexicoCities();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("city", item[0]);
            map.put("population ",  item[1]);
            response.add(map);
        }
        return response;
    }

    public List<Object> queryFour() {
        List<Object[]> table = countryRepository.findMostUsedLanguages();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("language ",  item[1]);
            map.put("percentage ",  item[2]);
            response.add(map);
        }
        return response;
    }

    public List<Object> queryFive() {
        List<Object[]> table = countryRepository.findSmallCountriesWithBigPopulation();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("surface_area ",  item[1]);
            map.put("population  ",  item[2]);
            response.add(map);
        }
        return response;
    }

    public List<Object> querySix() {
        List<Object[]> table = countryRepository.findMonarchyCountries();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("surface_area ",  item[1]);
            map.put("population  ",  item[2]);
            response.add(map);
        }
        return response;
    }

    public List<Object> querySeven() {
        List<Object[]> table = countryRepository.findBigCitiesInBuenosAires();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("country", item[0]);
            map.put("city ",  item[1]);
            map.put("district",  item[2]);
            map.put("population",  item[3]);
            response.add(map);
        }
        return response;
    }

    public List<Object> queryEigth() {
        List<Object[]> table = countryRepository.findCountriesByRegion();

        List<Object> response = new ArrayList<>();
        for(Object[] item : table){
            Map<String, Object> map = new HashMap<>();
            map.put("region", item[0]);
            map.put("total_countries  ",  item[1]);
            response.add(map);
        }
        return response;
    }
}
