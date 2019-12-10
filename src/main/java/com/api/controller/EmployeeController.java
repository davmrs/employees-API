package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Employee;
import com.api.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
    @GetMapping(path = "/employees")
    public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

    @GetMapping(path = "/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") long id) {
		return employeeService.getEmployeeById(id);
	}
    
}
