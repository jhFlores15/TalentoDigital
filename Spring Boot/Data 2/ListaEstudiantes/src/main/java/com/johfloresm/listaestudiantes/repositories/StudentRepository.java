package com.johfloresm.listaestudiantes.repositories;

import com.johfloresm.listaestudiantes.models.Contact;
import com.johfloresm.listaestudiantes.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

    List<Student> findAll();
    Student findStudentById(Long id);
    List<Student> findAllByDormitoryIsNull();


}
