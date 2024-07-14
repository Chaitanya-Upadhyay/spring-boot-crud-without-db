package com.spring.employee.springRestEmployee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Chaitanya Kumar
 */
@SpringBootApplication
public class SpringRestEmployeeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestEmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
    }
}
