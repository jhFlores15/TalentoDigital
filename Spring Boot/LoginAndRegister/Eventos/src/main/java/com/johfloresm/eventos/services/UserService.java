package com.johfloresm.eventos.services;

import com.johfloresm.eventos.models.User;
import com.johfloresm.eventos.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // registrar el usuario y hacer Hash a su password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(Long id) {
        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}