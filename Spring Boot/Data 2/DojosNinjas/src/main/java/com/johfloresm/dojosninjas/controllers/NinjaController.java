package com.johfloresm.dojosninjas.controllers;

import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.services.DojoService;
import com.johfloresm.dojosninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/dojos/"+ninja.getDojo().getId()+"/show";
    }

    @RequestMapping("/pages/{pageNumber}")
    public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
        //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página)
        Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
        //Total número de páginas que tenemos
        int totalPages = ninjas.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("ninjas", ninjas);
        return "ninjas/index.jsp";
    }
}
