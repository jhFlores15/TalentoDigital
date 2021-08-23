package com.johfloresm.waterbnb.services;

import com.johfloresm.waterbnb.models.Role;
import com.johfloresm.waterbnb.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService{

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
