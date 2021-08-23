package com.johfloresm.waterbnb.controllers;

import com.johfloresm.waterbnb.models.User;
import com.johfloresm.waterbnb.services.PoolService;
import com.johfloresm.waterbnb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController{
    private final PoolService poolService;
    private final UserService userService;

    public HomeController(PoolService poolService,UserService userService){
        this.poolService = poolService;
        this.userService = userService;
    }

    @GetMapping("")
    public String index(HttpSession httpSession, Model model){
        User user = httpSession.getAttribute("idUser") == null ? null : userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
         model.addAttribute("user",user);
        return "home.jsp";
    }

    @GetMapping("search")
    public String search(@RequestParam("location") String location, HttpSession httpSession, Model model){
        User user = httpSession.getAttribute("idUser") == null ? null : userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        model.addAttribute("user",user);
        model.addAttribute("pools",poolService.getPoolsByAddress(location));
        return "search.jsp";
    }
}
