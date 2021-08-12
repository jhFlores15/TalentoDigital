package com.johfloresm.licenciamanejo.controllers;

import com.johfloresm.licenciamanejo.models.License;
import com.johfloresm.licenciamanejo.services.LicenseService;
import com.johfloresm.licenciamanejo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LicenseController{

    @Autowired
    private LicenseService licenseService;
    @Autowired
    private PersonService personService;

    @RequestMapping("licenses/new")
    public String create(@ModelAttribute("license") License license, Model model){
        model.addAttribute("persons", personService.getPersons());
        return "licenses/create.jsp";
    }

    @RequestMapping(value = "licenses", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("license") License license, BindingResult result,Model model){
        if (result.hasErrors()) {
            model.addAttribute("persons", personService.getPersons());
            return "licenses/create.jsp";
        }
        licenseService.createLicense(license);

        return "redirect:/persons";
    }
}
