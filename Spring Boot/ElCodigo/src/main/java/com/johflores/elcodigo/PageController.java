package com.johflores.elcodigo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {
    final String CODE = "bushido";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/code")
    public String code(){
        return "code.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String validateCode(@RequestParam("code") String code, RedirectAttributes redirectAttributes){
        if(!code.equals(this.CODE)){
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }

        return "redirect:/code";
    }



}
