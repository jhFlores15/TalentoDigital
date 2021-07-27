package com.johflores.contador;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping("")
    public String index(HttpSession session){
        int counter = session.getAttribute("counter") == null ? 0 : ((int) (session.getAttribute("counter")) );
        session.setAttribute("counter", ++counter);
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model){
        int counter = session.getAttribute("counter") == null ? 0 : ((int) (session.getAttribute("counter")) );
        model.addAttribute("counter",counter);

        return "counter.jsp";
    }

    @RequestMapping(value = "/reset", method= RequestMethod.POST)
    public RedirectView  reset(HttpSession session){
        session.setAttribute("counter",0);

        return new RedirectView("/counter");
    }

    @RequestMapping("double")
    public String doubleCounter (HttpSession session){
        int counter = session.getAttribute("counter") == null ? 2 : ((int) (session.getAttribute("counter"))) + 2;
        session.setAttribute("counter", counter);

        return "doubleCounter.jsp";
    }
}
