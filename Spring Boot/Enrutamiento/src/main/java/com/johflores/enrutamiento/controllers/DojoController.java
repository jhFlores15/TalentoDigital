package com.johflores.enrutamiento.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

    @RequestMapping("/{var}")
    public String showVar(@PathVariable("var") String var){
        String value;
        switch (var){
            case "dojo":
                value = "¡El Dojo es increíble!";
                break;
            case "burbank-dojo":
                value = "El Dojo Burbank está localizado al sur de California";
                break;
            case "san-jose":
                value = "El Dojo SJ es el cuartel general";
                break;
            default:
                value = "Valor no manejado";
                break;
        }

        return value;
    }

}
