package com.safir.employeeManager.repository;

import com.safir.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long employeeId); //Long is the type of the PK

}

