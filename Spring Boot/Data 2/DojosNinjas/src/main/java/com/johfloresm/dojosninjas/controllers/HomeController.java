package com.johfloresm.dojosninjas.controllers;

import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.services.DojoService;
import com.johfloresm.dojosninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController{
    @Autowired
    NinjaService ninjaService;
    @Autowired
    DojoService  dojoService;


    @RequestMapping("/pages/{pageNumber}")
    public String index (Model model, @PathVariable("pageNumber") int pageNumber) {
        Page<Object[]> data = dojoService.getDojosAndNinjas(pageNumber - 1);
        int totalPages = data.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("data",data);
        return "index.jsp";
    }


}
