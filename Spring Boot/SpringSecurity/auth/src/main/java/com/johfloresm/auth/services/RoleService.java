package com.johfloresm.auth.services;

import com.johfloresm.auth.models.Role;
import com.johfloresm.auth.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService{

    @Autowired
    RoleRepository roleRepository;

    public Role getRoleByName(String name){
        return roleRepository.findFirstByName(name);
    }
}
