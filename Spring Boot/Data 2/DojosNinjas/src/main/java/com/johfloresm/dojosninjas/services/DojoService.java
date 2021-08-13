package com.johfloresm.dojosninjas.services;

import com.johfloresm.dojosninjas.models.Dojo;
import com.johfloresm.dojosninjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService{

    @Autowired
    private DojoRepository dojoRepository;

    public List<Dojo> getDojos(){
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo d){
        return dojoRepository.save(d);
    }

    public Dojo getDojoById(Long id){
        return dojoRepository.findFirstById(id);
    }
}
