/**
 * SandboxApplication main class for PersonJDBC
 */


package com.sandbox.sandbox.person.personJDBC;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PersonApplicationJDBC implements CommandLineRunner {

    @Autowired
    PersonJdbcDao personJdbcDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {

        SpringApplication.run(PersonApplicationJDBC.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personJdbcDao.findAll());
        logger.info("User id 10001 -> {}", personJdbcDao.finById(10001));
        logger.info("Deleting id 10002 -> No of rows deleted - {}", personJdbcDao.deleteById(10002));
        logger.info("inserting id 10005 ->{}", personJdbcDao.insert(
                new PersonJDBC(10005, "InsertedName5", "InsertedLocation5", new Date(92, 02, 03), new Date())));
        logger.info("Update id 10003 ->{}", personJdbcDao.update(new PersonJDBC(10003, "Name3 changed", "Location3 changed", new Date(99, 03, 11), new Date())));

    }
}

