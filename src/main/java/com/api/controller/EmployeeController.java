package com.api.controller;

import com.api.pojo.Employee;
import com.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees() {
        return employeeService.getActiveEmployees();
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        return employeeService.deleteEmployee(id);
    }

}
