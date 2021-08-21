package com.johfloresm.auth.repositories;

import com.johfloresm.auth.models.Role;
import com.johfloresm.auth.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findFirstByUsername(String username);
    User findFirstById(long id);
    List<User> findUsersByRolesIs(Role role);
    List<User> findAll();
    User findUsersByIdAndRolesIs(Long idUser, Role role);


    void deleteById(Long id);
}