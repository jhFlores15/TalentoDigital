package com.johflores.world.controllers;

import com.johflores.world.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController{

    @Autowired
    CountryService countryService;

    @RequestMapping("/query/{num}")
    public Object one(@PathVariable("num") int num) {
        switch(num){
            case 1:
                return countryService.queryOne();
            case 2:
                return countryService.queryTwo();
            case 3:
                return countryService.queryThree();
            case 4:
                return countryService.queryFour();
            case 5:
                return countryService.queryFive();
            case 6:
                return countryService.querySix();
            case 7:
                return countryService.querySeven();
            case 8:
                return countryService.queryEigth();
            default:
                break;

        }
        return null;
    }


}
