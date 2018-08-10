package sandbox.jpaHibernate.jpaHibernate.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sandbox.jpaHibernate.jpaHibernate.JpaHibernateApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(10001L);
        assertEquals("Some course no 1 name", course.getName());
    }
}
