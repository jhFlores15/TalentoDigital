package com.johflores.contador;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
