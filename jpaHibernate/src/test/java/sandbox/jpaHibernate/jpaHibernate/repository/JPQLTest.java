package sandbox.jpaHibernate.jpaHibernate.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import sandbox.jpaHibernate.jpaHibernate.JpaHibernateApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void findAll_JPQL_basic() {
        Query query = entityManager.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30m Query: Select c From Course c -> {} \u001B[0m", resultList);
    }

    @Test
    public void findAll_JPQL_typed() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30mTypedQuery: Select c From Course c -> {} \u001B[0m", resultList);
    }

    @Test
    public void findByName_JPQL_basic() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like '%Update'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30mConditionalQuery: Select c From Course c where name like '%Update' -> {} \u001B[0m", resultList);
    }

}
