package com.example.jpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SeedDB {

    @Autowired
    JdbcTemplate temp;

    @Autowired
    public SeedDB(DataSource ds) {
        JdbcTemplate temp = new JdbcTemplate(ds);
        temp.update("insert into EMPLOYEE(name, plata, region) values(?,?,?)", new Object[]{"Jovan", 2000, "Beograd"});
        temp.update("insert into EMPLOYEE(name, plata, region) values(?,?,?)", new Object[]{"Sanja", 2200, "Beograd"});
        temp.update("insert into EMPLOYEE(name, plata, region) values(?,?,?)", new Object[]{"Bojan", 2100, "Kraljevo"});
        temp.update("insert into EMPLOYEE(name, plata, region) values(?,?,?)", new Object[]{"Ivan", 2300, "Cacak"});
        temp.update("insert into EMPLOYEE(name, plata, region) values(?,?,?)", new Object[]{"Marko", 2300, "Nis"});
    }
}
