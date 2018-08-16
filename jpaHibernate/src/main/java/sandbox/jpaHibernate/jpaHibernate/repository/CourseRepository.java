package sandbox.jpaHibernate.jpaHibernate.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if(course.getId()==null){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        logger.info("\u001B[45m\u001B[30mplayWithEntitymanager - start\u001B[0m");

        Course course1 = new Course("Some new Entity Manager course1");
        entityManager.persist(course1);
        Course course2 = new Course("Some new Entity Manager course2");
        entityManager.persist(course2);

        entityManager.flush();

        course1.setName("Some new Entity Manager course1 - Update");
        course2.setName("Some new Entity Manager course2 - Update");

        entityManager.refresh(course1);

        entityManager.flush();
    }

}
