package com.johfloresm.dojosninjas.services;

import com.johfloresm.dojosninjas.models.Ninja;
import com.johfloresm.dojosninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NinjaService{

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja createNinja(Ninja n){
        return ninjaRepository.save(n);
    }

    //la variable estática establece el número de ninjas que queremos mostrar por página.
    private static final int PAGE_SIZE = 2;
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por apellido.
        PageRequest    pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.DESC,"lastName"));
        Page<Ninja> ninjas      = ninjaRepository.findAll(pageRequest);
        return ninjaRepository.findAll(pageRequest);
    }

}
