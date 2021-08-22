package com.johfloresm.eventos.repositories;

import com.johfloresm.eventos.models.State;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State,Long>{

    List<State> findAll();
    State findFirstByNameIs(String name);
}
