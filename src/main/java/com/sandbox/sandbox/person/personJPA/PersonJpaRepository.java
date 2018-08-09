package com.sandbox.sandbox.person.personJPA;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<PersonJPA> findAll() {
        TypedQuery<PersonJPA> namedQuery = entityManager.createNamedQuery("find_all_persons", PersonJPA.class);
        return namedQuery.getResultList();
    }

    public PersonJPA findByID(int id) {
        return entityManager.find(PersonJPA.class, id);
    }

    public PersonJPA update(PersonJPA personJPA) {
        return entityManager.merge(personJPA);
    }

    public PersonJPA insert(PersonJPA personJPA) {
        return entityManager.merge(personJPA);
    }

    public void deleteById(int id) {
        PersonJPA personJPA = findByID(id);
        entityManager.remove(personJPA);
    }

}
