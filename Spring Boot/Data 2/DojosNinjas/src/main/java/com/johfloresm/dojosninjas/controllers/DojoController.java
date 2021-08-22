package com.johfloresm.dojosninjas.controllers;

import com.johfloresm.dojosninjas.models.Dojo;
import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.services.DojoService;
import com.johfloresm.dojosninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("dojos")
public class DojoController{

    @Autowired
    private DojoService dojoService;

    @RequestMapping("/new")
    public String create(@ModelAttribute("dojo") Dojo dojo){
        return "dojos/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store (@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "dojos/create.jsp";
        }

        dojoService.createDojo(dojo);
        return "redirect:/ninjas/new";
    }

    @GetMapping("/{id}/show")
    public String show (@PathVariable("id") Long id, Model model){
        model.addAttribute("dojo", dojoService.getDojoById(id));

        return "dojos/show.jsp";
    }





}
