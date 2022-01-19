package com.api.service;

import com.api.pojo.Employee;
import com.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getActiveEmployees() {
        return employeeRepository.findAll().stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(long id) {
        Optional<Employee> previousEmployee = employeeRepository.findById(id);
        if (!previousEmployee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Employee currentEmployee = previousEmployee.get();

        if (!currentEmployee.isActive()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentEmployee, HttpStatus.OK);
    }

    @Override
    public Employee addEmployee(@Valid Employee employee) {
        employee.setActive(true);
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(long id, Employee employee) {
        Optional<Employee> previousEmployee = employeeRepository.findById(id);
        if (!previousEmployee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

        employeeRepository.save(currentEmployee);

        return new ResponseEntity<>(currentEmployee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> deleteEmployee(long id) {
        Optional<Employee> previousEmployee = employeeRepository.findById(id);
        if (!previousEmployee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Employee currentEmployee = previousEmployee.get();
        currentEmployee.setActive(false);
        employeeRepository.save(currentEmployee);

        return new ResponseEntity<>(currentEmployee, HttpStatus.OK);
    }
}
