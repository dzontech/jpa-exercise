package com.example.jpaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpAappApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JpAappApplication.class, args);

        EmployeeService s = ctx.getBean(EmployeeService.class);
        s.standardMethods();
        s.customMethods();
    }

}
