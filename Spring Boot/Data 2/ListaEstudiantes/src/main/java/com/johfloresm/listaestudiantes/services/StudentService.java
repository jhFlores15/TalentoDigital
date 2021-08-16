package com.johfloresm.listaestudiantes.services;

import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student s){
        return studentRepository.save(s);
    }

    public Student getStudentById(Long id){
        return studentRepository.findStudentById(id);
    }

    public List<Student> getStudentsWithoutDormitory(){
        return studentRepository.findAllByDormitoryIsNull();
    }
}
