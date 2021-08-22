package com.johfloresm.eventos.services;

import com.johfloresm.eventos.models.State;
import com.johfloresm.eventos.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService{
    @Autowired
    StateRepository stateRepository;

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public State getStateByName(String name){
        return stateRepository.findFirstByNameIs(name);
    }

    public State getStateById(Long id){
        return stateRepository.findById(id).get();
    }
}
