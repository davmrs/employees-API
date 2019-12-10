package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Employee;
import com.api.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository; 

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
}
