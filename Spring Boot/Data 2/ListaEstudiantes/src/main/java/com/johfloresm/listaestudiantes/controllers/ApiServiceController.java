package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Contact;
import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.services.ContactService;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiServiceController{

    @Autowired
    private StudentService studentService;
    @Autowired
    private ContactService contactService;

    @RequestMapping("students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping("contacts/create")
    public Student createContact(
            @RequestParam(value = "student") Long studentId,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state
        ){

        Student student = studentService.getStudentById(studentId);
        Contact contact = new Contact (address, city, state,student);
        contactService.createContact(contact);

        return student;
    }

}
