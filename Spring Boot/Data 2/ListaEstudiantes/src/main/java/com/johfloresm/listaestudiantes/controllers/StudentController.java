package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("students")
public class StudentController{

    @Autowired
    private StudentService studentService;

    @RequestMapping("")
    public String index (Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students/index.jsp";
    }

    @RequestMapping("new")
    public String create (@ModelAttribute("student") Student student){
        return "students/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("student") Student student, BindingResult result){
        if(result.hasErrors()){
            return "students/create.jsp";
        }

        studentService.createStudent(student);
        return "redirect:/contacts/new";
    }

}
