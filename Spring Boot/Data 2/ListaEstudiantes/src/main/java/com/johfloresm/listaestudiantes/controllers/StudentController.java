package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Class;
import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.services.ClassService;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController{

    @Autowired private StudentService studentService;
    @Autowired private ClassService  classService;

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

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Student student = studentService.getStudentById(id);
        List<Class> classes = classService.getClasses();
        model.addAttribute("classes", classes);
        model.addAttribute("student", student);
        return "students/show.jsp";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String addClass(@PathVariable(value = "id") Long studentId, @RequestParam("classId") Long classId){
        Student student = studentService.getStudentById(studentId);
        Class c = classService.getClassById(classId);
        c.setStudent(student);
        classService.createClass(c);

        return "redirect:/students/"+studentId;
    }

    @RequestMapping(value = "{id}/remove", method = RequestMethod.POST)
    public String removeClass(@PathVariable(value = "id") Long studentId, @RequestParam("classId") Long classId){
        Student student = studentService.getStudentById(studentId);
        Class c = classService.getClassById(classId);
        student.removeClass(c);
        studentService.createStudent(student);

        return "redirect:/students/"+studentId;
    }

}
