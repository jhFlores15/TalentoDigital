package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Class;
import com.johfloresm.listaestudiantes.services.ClassService;
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
@RequestMapping("classes")
public class ClassController{

    @Autowired private ClassService classService;

    @RequestMapping("new")
    public String create(@ModelAttribute("class") Class c){
        return "classes/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("class") Class c, BindingResult result){
        if(result.hasErrors()){
            return "classes/create.jsp";
        }

        classService.createClass(c);
        return "redirect:/classes/"+c.getId();
    }

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("classs", classService.getClassById(id));
        return "classes/show.jsp";
    }


}
