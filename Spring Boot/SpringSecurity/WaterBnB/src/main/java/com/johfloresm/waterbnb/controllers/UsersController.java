package com.johfloresm.waterbnb.controllers;

import com.johfloresm.waterbnb.models.Role;
import com.johfloresm.waterbnb.models.User;
import com.johfloresm.waterbnb.services.RoleService;
import com.johfloresm.waterbnb.services.UserService;
import com.johfloresm.waterbnb.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersController{
    private final UserService   userService;
    private final UserValidator userValidator;
    private final RoleService roleService;
    public UsersController(UserService userService, UserValidator userValidator,RoleService roleService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.roleService = roleService;
    }

    @RequestMapping("/guest/signing")
    public String index(@ModelAttribute("user") User user,Model model) {
        model.addAttribute("roles", roleService.getRoles());
        return "index.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "index.jsp";
        }
        user = userService.registerUser(user);
        session.setAttribute("idUser", user.getId());
        return "redirect:/";
    }

    @PostMapping(value="login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        if(userService.authenticateUser(email,password)){
            User user = userService.findByEmail(email);
            session.setAttribute("idUser", user.getId());
            if(user.getRole().getId() == Role.HOST){
                return "redirect:host/dashboard";
            }
            return "redirect:/";
        }
        return "index.jsp";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("idUser") != null){
            User usuario = userService.findUserById(Long.parseLong(session.getAttribute("idUser").toString()));
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

    //if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
    //User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));

}
