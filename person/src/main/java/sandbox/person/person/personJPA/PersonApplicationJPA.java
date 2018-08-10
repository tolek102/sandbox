package sandbox.person.person.personJPA;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PersonApplicationJPA implements CommandLineRunner {

    @Autowired
    PersonJpaRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {

        SpringApplication.run(PersonApplicationJPA.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("\u001B[46m All users -> {}", repository.findAll());

        logger.info("\u001B[46m User id 10001 -> {}", repository.findByID(10001));

        logger.info("\u001B[46m inserting id 10005 ->{}", repository.insert(
                new PersonJPA("InsertedName5JPA", "InsertedLocation5JPA", new Date(92, 02, 03), new Date())));

        logger.info("\u001B[46m Update id 10003 ->{}", repository.update(new PersonJPA(10003, "Name3JPA changed", "Location3JPA changed", new Date(99, 03, 11), new Date())));

        repository.deleteById(10003);
    }
}

