package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Dormitory;
import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.repositories.DormitoryRepository;
import com.johfloresm.listaestudiantes.services.DormitoryService;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("dorms")
public class DormitoryController{

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model){

        List<Student> students = studentService.getStudents();
        Dormitory dormitory = dormitoryService.getDormitoryById(id);


        model.addAttribute("dormitory", dormitory);
        model.addAttribute("students", students);

        return "dorms/show.jsp";
    }

    @RequestMapping(value = "{id}/remove/{studentId}", method = RequestMethod.DELETE)
    public String removeStudent(
            @PathVariable(name = "id") Long dormitoryId,
            @PathVariable(name = "studentId") Long studentId
    ){
        Student student = studentService.getStudentById(studentId);
        student.setDormitory(null);
        studentService.createStudent(student);

        return "redirect:/dorms/" + dormitoryId;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String addStudent(
            @PathVariable(name = "id") Long dormitoryId,
            @RequestParam("student") Long studentId
    ){
        Student student = studentService.getStudentById(studentId);
        student.setDormitory(dormitoryService.getDormitoryById(dormitoryId));
        studentService.createStudent(student);

        return "redirect:/dorms/" + dormitoryId;
    }
}
