package com.johfloresm.dojosninjas.controllers;

import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.services.DojoService;
import com.johfloresm.dojosninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("ninjas")
public class NinjaController{
    @Autowired
    private NinjaService ninjaService;
    @Autowired
    private DojoService  dojoService;

    @RequestMapping("/new")
    public String create(@ModelAttribute("ninja")Ninja ninja, Model model){
        model.addAttribute("dojos", dojoService.getDojos());

        return "ninjas/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("dojos", dojoService.getDojos());
            return "ninjas/create.jsp";
        }

        ninjaService.createNinja(ninja);
        return "redirect:/dojos/"+ninja.getDojo().getId();
    }
}
