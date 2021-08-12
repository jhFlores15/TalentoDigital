package com.johfloresm.listaestudiantes.services;

import com.johfloresm.listaestudiantes.models.Contact;
import com.johfloresm.listaestudiantes.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService{

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(Contact c){
        return contactRepository.save(c);
    }




}
