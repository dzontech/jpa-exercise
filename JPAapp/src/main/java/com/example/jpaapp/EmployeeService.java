package com.example.jpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class EmployeeService {

    @Autowired
    public EmployeeRepo repo;

    public void standardMethods() {

        //insert
        Employee newEmp = new Employee(-1, "Mika", 3000, "Zagubica");
        newEmp = repo.save(newEmp);
        System.out.printf("Inserted employee id: %d\n", newEmp.getEmployeeId());

        //count
        System.out.printf("Number of employees: %d\n", repo.count());

        //all employees
        display("All employees:", repo.findAll());
    }

    public void customMethods() {

        //find by region
        display("Po regionu 'Kraljevo':\n", repo.findByRegion("Kraljevo"));

        //find in salary range
        List<Employee> em = repo.findInSalaryRange(2000, 2200);
        display("Employees in salary range 2000-2200", em);

        //page by grater salary

        Pageable pageable = PageRequest.of(1,3,Direction.DESC, "plata");
        Page<Employee> page = repo.findByPlataGreaterThan(1200, pageable);
        display("Page 1 of employees with salary greater than 1200:", page.getContent());
    }


    private void display(String message, Iterable<Employee> employees) {
        System.out.printf("\n%s\n", message);
        for(Employee e: employees){
            System.out.println(e);
        }
    }
}
