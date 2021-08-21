package com.johfloresm.auth.services;

import com.johfloresm.auth.models.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.johfloresm.auth.models.User;
import com.johfloresm.auth.repositories.RoleRepository;
import com.johfloresm.auth.repositories.UserRepository;

import java.util.List;


@Service
public class UserService {
    private UserRepository        userRepository;
    private RoleRepository        roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    // 1
    public void saveWithUserRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
    // 2
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    // 3
    public User findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }

    public List<User> getUsersAdmin(){
        Role r = roleRepository.findFirstByName(Role.ROLE_ADMIN);
        return userRepository.findUsersByRolesIs(r);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
