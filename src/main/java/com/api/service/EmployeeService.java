package com.api.service;

import com.api.pojo.Employee;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<Employee>> getActiveEmployees();

    ResponseEntity<Employee> getEmployeeById(long id);

    ResponseEntity<Employee> addEmployee(@Valid Employee employee);

    ResponseEntity<Employee> updateEmployee(long id, @Valid Employee employee);

    ResponseEntity<Employee> deleteEmployee(long id);
}