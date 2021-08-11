package com.johfloresm.licenciamanejo.repositories;

import com.johfloresm.licenciamanejo.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

    List<License> findAll();

    @Transactional
    Long deleteLicenseById(Long id);
}
