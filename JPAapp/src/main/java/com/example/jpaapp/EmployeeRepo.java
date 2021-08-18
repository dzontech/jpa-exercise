package com.example.jpaapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    List<Employee> findByRegion(String region);

    @Query("select emp from Employee emp where emp.plata >= ?1 and emp.plata <= ?2")
    List<Employee> findInSalaryRange(double from, double to);

    Page<Employee> findByPlataGreaterThan(double plata, Pageable pageable);

}
