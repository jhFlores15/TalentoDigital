package com.johfloresm.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class Random {
    public static void main(String[] args) {
        SpringApplication.run(FirstprojectApplication.class, args);
    }

    // 1. Anotación
    @RequestMapping("/random")
    // 3. Método que se asigna a la Solicitud anterior.
    public String hello() { // 3
        return "Sping Boot is great! So easy to just respong with strings";
    }
}