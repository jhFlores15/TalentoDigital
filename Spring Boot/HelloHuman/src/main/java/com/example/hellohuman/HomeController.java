package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String index(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName
    ) {
        if (name == null && lastName == null) {
            return "¡Hello Human!";
        } else {
            return "¡Hello " + (name != null ? name : "") + " " + (lastName != null ? lastName : "") + "!";
        }
    }


}
