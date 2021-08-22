package com.johfloresm.eventos.controllers;

import com.johfloresm.eventos.models.Location;
import com.johfloresm.eventos.models.User;
import com.johfloresm.eventos.services.StateService;
import com.johfloresm.eventos.services.UserService;
import com.johfloresm.eventos.validator.UserValidator;
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
    private final StateService stateService;
    public UsersController(UserService userService, UserValidator userValidator, StateService stateService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.stateService = stateService;
    }

    @RequestMapping("/")
    public String index(@ModelAttribute("user") User user,Model model) {
        model.addAttribute("states", stateService.getStates());
        return "index.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,@RequestParam("state") Long state,@RequestParam("locationStr") String locationStr, BindingResult result, HttpSession session,Model model) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
           return index(user,model);
        }

        Location l = new Location(locationStr);
        l.setState(stateService.getStateById(state));
        user.setLocation(l);
        userService.registerUser(user);
        session.setAttribute("idUser", user.getId());
        return "redirect:/home";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        if(userService.authenticateUser(email,password)){
            User user = userService.findByEmail(email);
            session.setAttribute("idUser", user.getId());
            return "redirect:/events";
        }
        return "index.jsp";
    }

    @RequestMapping("/home")
    public String home(HttpSession httpSession, Model model) {
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        model.addAttribute("user",user);
        return "home.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
