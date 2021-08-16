package com.johfloresm.listaestudiantes.services;

import com.johfloresm.listaestudiantes.models.Class;
import com.johfloresm.listaestudiantes.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService{

    @Autowired
    private ClassRepository classRepository;

    public List<Class> getClasses(){
        return  classRepository.findAll();
    }

    public Class getClassById(Long id){
        return  classRepository.findClassById(id);
    }

    public Class createClass(Class c){
        return classRepository.save(c);
    }
}
