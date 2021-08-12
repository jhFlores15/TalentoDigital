package com.johfloresm.licenciamanejo.controllers;

import com.johfloresm.licenciamanejo.models.Person;
import com.johfloresm.licenciamanejo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PersonController{

    @Autowired
    private PersonService personService;

    @RequestMapping("persons")
    public String index(Model model){
        model.addAttribute("persons", personService.getPersons());
        return "persons/index.jsp";
    }

    @RequestMapping("persons/new")
    public String create(@ModelAttribute("person") Person person){
        return "persons/create.jsp";
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if (result.hasErrors()) {
            return "persons/create.jsp";
        }
        personService.createPerson(person);

        return "redirect:/licenses/new";
    }

    @RequestMapping("persons/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Person person = personService.getPersonById(id);
        person.getLicense();
        model.addAttribute("person",person);

        return "persons/show.jsp";
    }


}
