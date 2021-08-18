package com.example.entitymanagerdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;
import java.util.Scanner;

@Component
public class EmployeeService {

    private Scanner scanner = new Scanner(System.in);
    @Autowired
    private EmployeeRepo repo;

    public void queryEntities() {

        try {
            long emCount = repo.getEmployeeCount();
            System.out.printf("Number of employees %d:\n", emCount);


            long id = promptForId("Enter employee id you want:");
            Employee emp = repo.getEmployee(id);
            System.out.printf("Employee %d: %s\n", id, emp);

        }
        catch(Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    public void modyfyEntities() {

        try {
            //insert
            Employee newEmp = new Employee(-1, "Micko", 3000, "Ub");
            repo.insertEmployee(newEmp);
            display("All employees:", repo);

            //update
            long id = promptForId("Enter employee id you want to update:");
            Employee em = repo.getEmployee(id);
            em.setRegion("Madagaskar");
            repo.updateEmployee(em);
            display("All employees after update:", repo);

            //delete
            long idd = promptForId("Enter employee id you want to delete:");
            repo.deleteEmployee(idd);
            display("All employees after delete:", repo);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    public long promptForId(String message) {
        System.out.printf("\n%s\n", message);
        long id = scanner.nextInt();
        return id;
    }

    public void display(String message, EmployeeRepo repo) {
        System.out.printf("\n%s\n", message);
        for (Employee e: repo.getEmployees()){
            System.out.println(e);
        }
    }
}
