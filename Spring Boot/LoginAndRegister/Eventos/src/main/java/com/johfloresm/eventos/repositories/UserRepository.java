package com.johfloresm.eventos.repositories;

import com.johfloresm.eventos.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
    User findFirstById(Long id);

}