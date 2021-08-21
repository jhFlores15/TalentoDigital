package com.johflores.world.repositories;

import com.johflores.world.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long>{

    
}
