package com.johfloresm.dojosninjas.repositories;

import com.johfloresm.dojosninjas.models.Dojo;
import com.johfloresm.dojosninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

    List<Ninja> findByDojo(Dojo d);

    List<Ninja> findAll();
}
