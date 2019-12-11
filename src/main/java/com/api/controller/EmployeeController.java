package com.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    	
    	List<Employee> employees = employeeService.getAllEmployees();
    	Predicate<Employee> isActive = employee -> employee.isActive() != false;

    	List<Employee> activeEmployees = employees.stream().filter(isActive)
                .collect(Collectors.toList());
    	
		return activeEmployees;
	}

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
    	
    	Optional<Employee> previousEmployee = employeeService.getEmployeeById(id);
    	if (previousEmployee.isPresent() == false) {
    		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    	
    	Employee currentEmployee = previousEmployee.get();
    	
    	if (currentEmployee.isActive() == false) {
    		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    	}
    	
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}
    
    @PostMapping(path = "/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
    	
    	employee.setActive(true);
    	
    	return employeeService.addEmployee(employee);
    }
    
    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
    	 
    	Optional<Employee> previousEmployee = employeeService.getEmployeeById(id);
    	if (previousEmployee.isPresent() == false) {
    		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    	
    	Employee currentEmployee = previousEmployee.get();
 
    	if (employee.getFirstName() != null) {
    		currentEmployee.setFirstName(employee.getFirstName());
    	}
    	
    	if (employee.getMiddleInitial() != null) {
    		currentEmployee.setMiddleInitial(employee.getMiddleInitial());
    	}
    	
    	if (employee.getLastName() != null) {
        	currentEmployee.setLastName(employee.getLastName());

    	}
    	
    	if (employee.getDateBirth() != null) {
        	currentEmployee.setDateBirth(employee.getDateBirth());

    	}
    	
    	if (employee.getDateEmployment() != null) {
        	currentEmployee.setDateEmployment(employee.getDateEmployment());

    	}
    	
    	employeeService.updateEmployee(currentEmployee);
    	
    	return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
    	 
    	Optional<Employee> previousEmployee = employeeService.getEmployeeById(id);
    	if (previousEmployee.isPresent() == false) {
    		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    	
    	Employee currentEmployee = previousEmployee.get();
    	currentEmployee.setActive(false);
    	employeeService.updateEmployee(currentEmployee);
 
    	return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }
    
}
