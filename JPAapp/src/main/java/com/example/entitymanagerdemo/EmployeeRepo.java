package com.example.entitymanagerdemo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeRepo {

    @PersistenceContext
    protected EntityManager entityManager;

    public Employee getEmployee(long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    public long getEmployeeCount() {
        String jpql = "select count(e) from Employee e";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        return query.getSingleResult();
    }

    public List<Employee> getEmployees() {
        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        return query.getResultList();
    }

    @Transactional
    public void insertEmployee(Employee e) {
        entityManager.persist(e);
    }
    @Transactional
    public void updateEmployee(Employee e) {
        Employee entity = entityManager.find(Employee.class, e.getEmployeeid());
        entity.setName(e.getName());
        entity.setSalary(e.getSalary());
        entity.setRegion(e.getRegion());
    }

    @Transactional
    public void deleteEmployee(long employeeId) {
        Employee e = entityManager.find(Employee.class, employeeId);
        entityManager.remove(e);
    }

}
