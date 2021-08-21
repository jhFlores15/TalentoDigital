package com.johfloresm.employes.services;

import com.johfloresm.employes.models.Employee;
import com.johfloresm.employes.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByManager(Long id){
        return employeeRepository.findAllByManager_Id(id);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

}
