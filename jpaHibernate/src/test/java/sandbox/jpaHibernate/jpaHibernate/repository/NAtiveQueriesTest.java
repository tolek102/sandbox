package sandbox.jpaHibernate.jpaHibernate.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.JpaHibernateApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class NAtiveQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void findAll_NativeQueries_basic() {
        Query query = entityManager.createNativeQuery("Select * From COURSE", Course.class);
        List resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30m Query: Select * From COURSE -> {} \u001B[0m", resultList);
    }

    @Test
    public void findByID_NativeQueries_basic() {
        Query query = entityManager.createNativeQuery("Select * From COURSE where id = ?", Course.class);
        query.setParameter(1, 10001L);
        List<Course> resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30mConditionalQuery: Select * From COURSE where id = ? -> {} \u001B[0m", resultList);
    }

    @Test
    public void findByID_NativeQueries_basic2() {
        Query query = entityManager.createNativeQuery("Select * From COURSE where id = :id", Course.class);
        query.setParameter("id:", 10001L);
        List resultList = query.getResultList();
        logger.info("\u001B[45m\u001B[30mConditionalQuery: Select * From COURSE where id = ? -> {} \u001B[0m", resultList);
    }

    @Test
    @Transactional
    public void updateAll_NativeQueries_basic() {
        Query query = entityManager.createNativeQuery("UPDATE COURSE set last_updated_date = sysdate()", Course.class);
        int nrOfRowUpdated = query.executeUpdate();
        logger.info("\u001B[45m\u001B[30mnrOfRowUpdated -> {} \u001B[0m", nrOfRowUpdated);
    }

}
