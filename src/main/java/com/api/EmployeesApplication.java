package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.model.Employee;
import com.api.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeesApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository) {
		return (args) -> {
			employeeRepository.save(new Employee("David", "S", "Mora", "22081991", "20092015", true));
			employeeRepository.save(new Employee("Juan", "A", "Guevara", "03091978", "15032017", true));
			employeeRepository.save(new Employee("Luis ", "R", "Pérez", "19031985", "10012015", false));
			employeeRepository.save(new Employee("Fernando", "J", "Trinidad", "28121990", "05042018", true));
			logger.info("The sample data has been generated");
		};
	}

}
