package sandbox.jpaHibernate.jpaHibernate.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.JpaHibernateApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;
import sandbox.jpaHibernate.jpaHibernate.entity.Review;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(10001L);
        assertEquals("Some course no 1 name", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_basic_update() {
        Course course = courseRepository.findById(10001L);
        assertEquals("Some course no 1 name", course.getName());

        course.setName("Updated course no 1");
        courseRepository.save(course);

        Course course1 = courseRepository.findById(10001L);

        assertEquals("Updated course no 1", course1.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        courseRepository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieve_reviews_for_course() {
        Course course = courseRepository.findById(10001L);
        logger.info("\u001B[45m\u001B[30m course.getReviews() -> {} \u001B[0m", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieve_course_for_review() {
        Review review = entityManager.find(Review.class,50001L);
        logger.info("\u001B[45m\u001B[30m review.getCourse() -> {} \u001B[0m", review.getCourse());
    }
}
