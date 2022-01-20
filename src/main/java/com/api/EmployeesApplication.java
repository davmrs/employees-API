package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EmployeesApplication {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

}
