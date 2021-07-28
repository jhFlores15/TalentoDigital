package com.johfloresm.gameninja.controllers;

import com.johfloresm.gameninja.models.Ninja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class GameController {

    @RequestMapping("")
    public String index(Model model, HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        model.addAttribute("ninja",ninja);

        return "webapp/WEB-INF/index.jsp";
    }

    @RequestMapping(value = "/farm",method = RequestMethod.POST)
    public String farm(HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        ninja.addGold(20,10);
        session.setAttribute("ninja",ninja);

        return "redirect:/";
    }

    @RequestMapping(value = "/cave",method = RequestMethod.POST)
    public String cave(HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        ninja.addGold(10,5);
        session.setAttribute("ninja",ninja);

        return "redirect:/";
    }

    @RequestMapping(value = "/house",method = RequestMethod.POST)
    public String house(HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        ninja.addGold(5,2);
        session.setAttribute("ninja",ninja);

        return "redirect:/";
    }

    @RequestMapping(value = "/casino",method = RequestMethod.POST)
    public String casino(HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        ninja.randomAddOrSub(50,0);
        session.setAttribute("ninja",ninja);

        return "redirect:/";
    }

    @RequestMapping(value = "/spa",method = RequestMethod.POST)
    public String spa(HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        ninja.subtractGold(20,5);
        session.setAttribute("ninja",ninja);

        return "redirect:/";
    }





}
