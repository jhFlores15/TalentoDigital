package com.johfloresm.auth.controllers;

import com.johfloresm.auth.models.User;
import com.johfloresm.auth.services.UserService;
import com.johfloresm.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {
    private UserService   userService;
    private UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }

        if(userService.getUsersAdmin().size() == 0){
            userService.saveUserWithAdminRole(user);
        }else{
            userService.saveWithUserRole(user);
        }

        return "redirect:/dashboard";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        User user = userService.findByUsername(username);

        // Por defecto, obtenemos el tipo de objeto, por lo que debemos convertirlo en un objeto UserDetails.
        //User userPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //String name = user.getUsername();
        if(user.isAdmin()){
            return "redirect:/admin";
        }
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "home.jsp";
    }

    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.getUsers());
        return "adminPage.jsp";
    }

    @GetMapping(value = "/admin/{id}/makeAdmin")
    public String makeAdmin(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(!user.isAdmin()){
            userService.saveUserWithAdminRole(user);
        }

        return "redirect:/admin";
    }

    @GetMapping(value ="/admin/{id}/remove")
    public String removeUser(@PathVariable("id") Long id){
        userService.deleteUser(id);

        return "redirect:/admin";
    }

    @GetMapping("/dashboard")
    public String dahsboard(Principal principal, Model model){
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user",user);
        return "dashboard.jsp";
    }
}