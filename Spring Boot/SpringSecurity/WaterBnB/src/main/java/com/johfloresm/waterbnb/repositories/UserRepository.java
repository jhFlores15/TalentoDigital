package com.johfloresm.waterbnb.repositories;

import com.johfloresm.waterbnb.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
    User findFirstById(Long id);
}