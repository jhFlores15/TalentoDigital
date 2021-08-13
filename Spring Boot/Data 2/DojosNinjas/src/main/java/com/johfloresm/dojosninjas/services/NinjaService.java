package com.johfloresm.dojosninjas.services;

import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService{

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja createNinja(Ninja n){
        return ninjaRepository.save(n);
    }

}
