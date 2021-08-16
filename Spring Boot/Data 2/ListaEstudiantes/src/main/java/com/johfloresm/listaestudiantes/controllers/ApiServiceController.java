package com.johfloresm.listaestudiantes.controllers;

import com.johfloresm.listaestudiantes.models.Class;
import com.johfloresm.listaestudiantes.models.Contact;
import com.johfloresm.listaestudiantes.models.Dormitory;
import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.services.ClassService;
import com.johfloresm.listaestudiantes.services.ContactService;
import com.johfloresm.listaestudiantes.services.DormitoryService;
import com.johfloresm.listaestudiantes.services.StudentService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiServiceController{

    private StudentService studentService;
    private ContactService   contactService;
    private DormitoryService dormitoryService;
    private ClassService classService;

    public ApiServiceController(StudentService studentService, ContactService contactService, DormitoryService dormitoryService, ClassService classService){
        this.studentService = studentService;
        this.contactService = contactService;
        this.dormitoryService = dormitoryService;
        this.classService = classService;
    }

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

    @RequestMapping("students/create")
    public Student createStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") int age
    ){
        Student student = new Student(firstName, lastName, age, null,null);
        studentService.createStudent(student);

        return student;
    }

    @RequestMapping("dorms/create")
    public Dormitory createDormitory(
            @RequestParam("name") String name
    ){
        Dormitory dormitory = new Dormitory(name);
        return dormitoryService.createDormitory(dormitory);
    }

    @RequestMapping("dorms/{id}")
    public Dormitory showDormitory(@PathVariable(name = "id") Long dormitoryId){
        Dormitory dormitory = dormitoryService.getDormitoryById(dormitoryId);
        return dormitory;
    }

    @RequestMapping("dorms/{id}/add")
    public Student addStudent(
            @PathVariable(name = "id") Long dormitoryId,
            @RequestParam("student") Long studentId
    ){
        Student student = studentService.getStudentById(studentId);
        student.setDormitory(dormitoryService.getDormitoryById(dormitoryId));
        studentService.createStudent(student);
        return student;
    }

    @RequestMapping("dorms/{id}/remove")
    public Student removeStudent(
            @PathVariable(name = "id") Long dormitoryId,
            @RequestParam("student") Long studentId
    ){
        Student student = studentService.getStudentById(studentId);
        student.setDormitory(null);
        studentService.createStudent(student);

        return student;
    }

    @RequestMapping("classes/create")
    public Class createClass(@RequestParam("name") String name){
        Class c = new Class(name);
        return classService.createClass(c);
    }

    @RequestMapping("students/{id}/add")
    public Class addStudentToClass(@PathVariable(value = "id") Long studentId, @RequestParam(value = "class") Long classId){
        Student student = studentService.getStudentById(studentId);
        Class  c = classService.getClassById(classId);
        student.setClass(c);
        studentService.createStudent(student);
        return c;
    }

    @RequestMapping("classes/{id}")
    public Class showClass(@PathVariable("id") Long id){
        return classService.getClassById(id);
    }

}
