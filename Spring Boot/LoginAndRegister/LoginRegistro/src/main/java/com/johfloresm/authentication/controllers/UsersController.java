package com.johfloresm.authentication.controllers;

import com.johfloresm.authentication.models.User;
import com.johfloresm.authentication.services.UserService;
import com.johfloresm.authentication.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersController{
    private final UserService   userService;
    private final UserValidator userValidator;
    public UsersController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/")
    public String index(@ModelAttribute("user") User user) {
        return "index.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "index.jsp";
        }
        user = userService.registerUser(user);
        session.setAttribute("idUsuario", user.getId());
        return "redirect:/home";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        if(userService.authenticateUser(email,password)){
            User user = userService.findByEmail(email);
            session.setAttribute("idUsuario", user.getId());
            return "redirect:/home";
        }
        return "index.jsp";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("idUsuario") != null){
            User usuario = userService.findUserById(Long.parseLong(session.getAttribute("idUsuario").toString()));
            model.addAttribute("user",usuario);
            return "home.jsp";
        }
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
