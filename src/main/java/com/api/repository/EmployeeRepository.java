package com.api.repository;

import com.api.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();

    Optional<Employee> findById(long id);

    void save(Employee employee);

    void delete(long id);
}