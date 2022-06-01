package com.safir.employeeManager.service;

import com.safir.employeeManager.exception.UserNotFoundException;
import com.safir.employeeManager.model.Employee;
import com.safir.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);

    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){

        Employee employee1 = findEmployee(employee.getId());
        employee1.setEmail(employee.getEmail());
        employee1.setName(employee.getName());
        employee1.setJobTitle(employee.getJobTitle());
        employee1.setPhone(employee.getPhone());
        employee1.setImageUrl(employee.getImageUrl());

        return employeeRepository.save(employee1);
    }

    public Employee findEmployee(Long employeeId){ //or create a method findEmployeeById or findById
        return employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(() -> new UserNotFoundException("User by id "+employeeId+" not found "));
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);  //or create a methode deleteEmployeeById
    }


}
