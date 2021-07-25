package com.example.mostrarfecha;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model){
        Date now = new java.util.Date();
        SimpleDateFormat dt = new SimpleDateFormat("EEEE d 'de' MMMM, YYYY");
        model.addAttribute("date",dt.format(now));
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model){
        Date now = new java.util.Date();
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm aaa");
        model.addAttribute("time",dt.format(now));

        return "time.jsp";
    }
}
