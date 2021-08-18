package com.example.entitymanagerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDB {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update("insert into Employee(name, salary, region) values(?,?,?)", new Object[]{"Jovan", 2000, "Beograd"});
        jdbcTemplate.update("insert into Employee(name, salary, region) values(?,?,?)", new Object[]{"Sanja", 2100, "Beograd"});
        jdbcTemplate.update("insert into Employee(name, salary, region) values(?,?,?)", new Object[]{"Bojan", 2200, "Kraljevo"});
        jdbcTemplate.update("insert into Employee(name, salary, region) values(?,?,?)", new Object[]{"Ivan", 2300, "Cacak"});
        jdbcTemplate.update("insert into Employee(name, salary, region) values(?,?,?)", new Object[]{"Marko", 2400, "Nis"});
    }
}
