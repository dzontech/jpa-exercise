package com.example.jpaapp;


import javax.persistence.*;


@Entity
@Table(name="EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId = -1;

    private String name;
    private String region;

    @Column(name="salary")
    private double plata;

    public Employee() {

    }

    public Employee(long employeeId, String name, double plata, String region) {
        this.employeeId =employeeId;
        this.name = name;
        this.plata = plata;
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", plata=" + plata +
                '}';
    }
}
