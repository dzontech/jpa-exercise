package com.example.entitymanagerdemo;

import javax.persistence.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeid = -1;

    private String name;
    private String region;

    private double salary;

    public Employee() {

    }

    public Employee(long employeeid, String name, double salary, String region) {
        this.employeeid = employeeid;
        this.name = name;
        this.salary = salary;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public long getEmployeeid() {
        return employeeid;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if(other instanceof Employee) {
            Employee otherEmp = (Employee) other;
            result = (this.employeeid== otherEmp.employeeid);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (int)employeeid;
    }
}
