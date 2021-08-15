package com.johfloresm.listaestudiantes.services;

import com.johfloresm.listaestudiantes.models.Dormitory;
import com.johfloresm.listaestudiantes.models.Student;
import com.johfloresm.listaestudiantes.repositories.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormitoryService{

    @Autowired
    DormitoryRepository dormitoryRepository;

    public Dormitory createDormitory(Dormitory d){
        return dormitoryRepository.save(d);
    }

    public Dormitory getDormitoryById(Long id){
        return dormitoryRepository.findDormitoryById(id);
    }
}
