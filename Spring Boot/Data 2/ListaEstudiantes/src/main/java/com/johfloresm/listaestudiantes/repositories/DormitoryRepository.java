package com.johfloresm.listaestudiantes.repositories;

import com.johfloresm.listaestudiantes.models.Dormitory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Long>{
    Dormitory findDormitoryById(Long id);

    
}
