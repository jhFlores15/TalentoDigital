package com.johfloresm.listaestudiantes.repositories;

import com.johfloresm.listaestudiantes.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{




}
