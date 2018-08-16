package sandbox.jpaHibernate.jpaHibernate.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.JpaHibernateApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;
import sandbox.jpaHibernate.jpaHibernate.entity.Passport;
import sandbox.jpaHibernate.jpaHibernate.entity.Review;
import sandbox.jpaHibernate.jpaHibernate.entity.Student;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieve_student_and_passport_details() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("\u001B[45m\u001B[30m student -> {} \u001B[0m", student);
        logger.info("\u001B[45m\u001B[30m passpott -> {} \u001B[0m", student.getPassport());

    }

    @Test
    @Transactional
    public void retrieve_passport_and_associated_student_details() {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("\u001B[45m\u001B[30m passport -> {} \u001B[0m", passport);
        logger.info("\u001B[45m\u001B[30m student -> {} \u001B[0m", passport.getStudent());

    }

    @Test
    @Transactional
    public void retrieve_student_and_related_courses() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("\u001B[45m\u001B[30m student -> {} \u001B[0m", student);
        logger.info("\u001B[45m\u001B[30m courses -> {} \u001B[0m", student.getCourses());

    }

    @Test
    @Transactional
    public void retrieve_course_and_related_students() {
        Course course = entityManager.find(Course.class, 10001L);
        logger.info("\u001B[45m\u001B[30m course -> {} \u001B[0m", course);
        logger.info("\u001B[45m\u001B[30m students -> {} \u001B[0m", course.getStudents());

    }

    @Test
    @Transactional
    public void retrieve_reviews_from_student() {
        Student student = studentRepository.findById(20001L);
        logger.info("\u001B[45m\u001B[30m student.getReviews() -> {} \u001B[0m", student.getReviews());
    }

    @Test
    @Transactional
    public void retrieve_student_for_review() {
        Review review = entityManager.find(Review.class,50001L);
        logger.info("\u001B[45m\u001B[30m review.getStudent() -> {} \u001B[0m", review.getStudent());
    }
}

