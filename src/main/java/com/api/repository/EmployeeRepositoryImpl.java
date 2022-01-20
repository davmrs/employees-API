package com.api.repository;

import com.api.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(Arrays.asList(
            new Employee(1, "David", "S", "Mora", LocalDate.of(1989, Month.FEBRUARY, 8), LocalDate.of(2015, Month.SEPTEMBER, 20), true),
            new Employee(2, "Juan", "A", "Guevara", LocalDate.of(1978, Month.SEPTEMBER, 3), LocalDate.of(2017, Month.MARCH, 15), true),
            new Employee(3, "Luis ", "R", "Cervantes", LocalDate.of(1985, Month.MARCH, 19), LocalDate.of(2015, Month.JANUARY, 10), false),
            new Employee(4, "Fernando", "J", "Trinidad", LocalDate.of(1990, Month.DECEMBER, 28), LocalDate.of(2018, Month.APRIL, 5), true)));

    @Override
    public List<Employee> findAll() {
        return EMPLOYEE_LIST;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return EMPLOYEE_LIST.stream()
                .filter(Employee::isActive)
                .filter(employee -> employee.getId() == id)
                .findAny();
    }

    @Override
    public void save(Employee employee) {
        employee.setActive(true);
        EMPLOYEE_LIST.add(employee);
    }

    @Override
    public void delete(long id) {
        Optional<Employee> employee = findById(id);
        employee.ifPresent(value -> value.setActive(false));
    }
}
