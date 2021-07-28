package com.johfloresm.encuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class HomeController {
    final String[] LANGUAGES = {"Python", "Java", "PHP"};
    final String[] LOCATIONS = {"San Jose", "Santiago"};


    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("locations", this.LOCATIONS);
        model.addAttribute("languages", this.LANGUAGES);

        return "index.jsp";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String post(@RequestParam Map<String,String> allParams, HttpSession session){
        String name     = allParams.get("name");
        String location = allParams.get("location");
        String language = allParams.get("language");
        String comment  = allParams.get("comment") == null ? "" : allParams.get("comment");

        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);

        return "redirect:/result";
    }

    @RequestMapping("/result")
    public String result(Model model, HttpSession session){
        model.addAttribute("session",session);

        return "result.jsp";
    }

}
