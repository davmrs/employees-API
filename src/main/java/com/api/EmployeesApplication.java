package com.api;

import com.api.pojo.Employee;
import com.api.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class EmployeesApplication {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesApplication.class);

    private static final List<Employee> initialEmployees = Arrays.
            asList(
                    new Employee("David", "S", "Mora", "22081991", "20092015", true),
                    new Employee("Juan", "A", "Guevara", "03091978", "15032017", true),
                    new Employee("Luis ", "R", "Pérez", "19031985", "10012015", false),
                    new Employee("Fernando", "J", "Trinidad", "28121990", "05042018", true)
            );

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(EmployeeRepository employeeRepository) {
        return (args) -> {
            initialEmployees
                    .forEach(employeeRepository::save);
            logger.info("The sample data has been generated");
        };
    }

}
