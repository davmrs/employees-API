package com.api.service;

import java.util.List;
import java.util.Optional;

import com.api.model.Employee;

public interface EmployeeService {
	Optional<Employee> getEmployeeById(long id);
	List<Employee> getAllEmployees();
}