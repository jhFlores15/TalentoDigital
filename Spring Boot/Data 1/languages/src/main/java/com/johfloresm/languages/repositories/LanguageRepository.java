package com.johfloresm.languages.repositories;

import com.johfloresm.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

    List<Language> findAll();

    @Transactional
    Long deleteBookById(Long id);

}
