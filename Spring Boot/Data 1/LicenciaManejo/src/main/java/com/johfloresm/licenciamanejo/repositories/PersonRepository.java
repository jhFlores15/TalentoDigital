package com.johfloresm.licenciamanejo.repositories;

import com.johfloresm.licenciamanejo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{

    List<Person> findAll();

    @Transactional
    Long deletePersonById(Long id);
}
