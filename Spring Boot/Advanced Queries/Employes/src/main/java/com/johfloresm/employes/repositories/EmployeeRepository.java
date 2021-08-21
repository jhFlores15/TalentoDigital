package com.johfloresm.employes.repositories;

import com.johfloresm.employes.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{

    List<Employee> findAllByManager_Id(Long id);
    Optional<Employee> findById(Long id);
}
