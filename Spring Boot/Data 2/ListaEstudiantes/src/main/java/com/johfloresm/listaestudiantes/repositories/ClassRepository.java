package com.johfloresm.listaestudiantes.repositories;

import com.johfloresm.listaestudiantes.models.Class;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>{

    List<Class> findAll();

    Class findClassById(Long id);
}
