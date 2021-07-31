package com.johfloresm.gameninja.controllers;

import com.johfloresm.gameninja.models.Ninja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gold")
public class TwoMethodController{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        model.addAttribute("ninja",ninja);

        return "indexTwo.jsp";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String indexPost(
            @RequestParam(value = "type", required = false) String type,
            HttpSession session
    ){
        Ninja ninja = session.getAttribute("ninja") == null ? new Ninja() : (Ninja) session.getAttribute("ninja");
        Integer amount = null;
        switch(type){
            case "farm":
                amount = ninja.addGold(20, 10);
                ninja.addActivity(amount, "farm");
                break;
            case "cave":
                amount = ninja.addGold(10, 5);
                ninja.addActivity(amount, "cave");
                break;
            case "house":
                amount = ninja.addGold(5, 2);
                ninja.addActivity(amount, "house");
                break;
            case "casino":
                amount = ninja.randomAddOrSub(50,0);
                ninja.addActivity(amount,"casino");
                break;
            case "spa":
                amount = ninja.subtractGold(20,5);
                ninja.addActivity(amount,"spa");
                break;
        }

        session.setAttribute("ninja", ninja);

        return "redirect:/gold";
    }

    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public String reset(HttpSession session){
        Ninja ninja = new Ninja();
        session.setAttribute("ninja",ninja);

        return "redirect:/gold";
    }

}
