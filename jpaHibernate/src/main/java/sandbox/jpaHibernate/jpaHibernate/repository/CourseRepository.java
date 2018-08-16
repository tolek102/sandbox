package sandbox.jpaHibernate.jpaHibernate.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;
import sandbox.jpaHibernate.jpaHibernate.entity.Review;

import javax.persistence.EntityManager;
import java.util.List;

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

    public void addHardcodedReviewsForCourse(){
        Course course = findById(10003L);
        logger.info("\u001B[45m\u001B[30m course.getRwviews() -> {} \u001B[0m",course.getReviews() );

        Review review1 = new Review("11", "New Review 11");
        Review review2 = new Review("22", "New Review 22");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        logger.info("\u001B[45m\u001B[30m course.getRwviews() -> {} \u001B[0m",course.getReviews() );

        for(Review review:reviews){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }

    }

}
