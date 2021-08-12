package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Contact;
import com.johfloresm.listaestudiantes.services.ContactService;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("contacts")
public class ContactController{

    @Autowired
    private ContactService contactService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/new")
    public String create(@ModelAttribute("contact") Contact contact, Model model){
        model.addAttribute("students", studentService.getStudents());
       return "contacts/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store (@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("students", studentService.getStudents());
            return "contacts/create.jsp";
        }
        contactService.createContact(contact);

        return "redirect:/students";
    }

}
