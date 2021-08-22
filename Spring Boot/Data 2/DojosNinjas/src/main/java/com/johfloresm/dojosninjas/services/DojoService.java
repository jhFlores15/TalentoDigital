package com.johfloresm.dojosninjas.services;

import com.johfloresm.dojosninjas.models.Dojo;
import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private static final int PAGE_SIZE = 5;
    public Page<Object[]> getDojosAndNinjas(int pageNumber){
        PageRequest    pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.DESC,"name"));
        //Page<Object[]> items      = dojoRepository.joinDojosAndNinjas(pageRequest);
        return dojoRepository.joinDojosAndNinjas(pageRequest);
        /**for(Object[] row : table) {
            Dojo  dojo  = (Dojo) row[0];
            Ninja ninja = (Ninja) row[1];
        }*/
        //return table;
    }


}
