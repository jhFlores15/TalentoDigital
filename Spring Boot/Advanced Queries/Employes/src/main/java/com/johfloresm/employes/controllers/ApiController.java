package com.johfloresm.employes.controllers;

import com.johfloresm.employes.models.Employee;
import com.johfloresm.employes.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController{

    @Autowired
    EmployeeService employeeService;

    @GetMapping("manager/{id}")
    public Object getEmployees(@PathVariable("id") Long id){
        Employee manager = employeeService.getEmployeeById(id);
        return manager == null ? null : manager.getEmployees();
    }

    @GetMapping("employee/{id}")
    public Object getManager(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee == null ? null :  employee.getManager();
    }

}
