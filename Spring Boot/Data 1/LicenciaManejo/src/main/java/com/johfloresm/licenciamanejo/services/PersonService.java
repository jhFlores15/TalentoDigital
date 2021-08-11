package com.johfloresm.licenciamanejo.services;

import com.johfloresm.licenciamanejo.models.Person;
import com.johfloresm.licenciamanejo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService{

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Person createPerson(Person b) {
        return personRepository.save(b);
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void deletePersonById(Long id){
        personRepository.deletePersonById(id);
    }

    public void updatePerson(Person p){
        Person person = this.getPersonById(p.getId());
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setLicense(p.getLicense());

        personRepository.save(person);
    }


}
