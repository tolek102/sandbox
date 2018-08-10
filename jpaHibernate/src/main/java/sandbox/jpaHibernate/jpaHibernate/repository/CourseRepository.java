package sandbox.jpaHibernate.jpaHibernate.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

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

}
