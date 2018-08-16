package sandbox.jpaHibernate.jpaHibernate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sandbox.jpaHibernate.jpaHibernate.entity.Course;
import sandbox.jpaHibernate.jpaHibernate.entity.Review;
import sandbox.jpaHibernate.jpaHibernate.repository.CourseRepository;
import sandbox.jpaHibernate.jpaHibernate.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		logger.info("\u001B[45m\u001B[30m Course 10001 -> {} \u001B[0m", course);
//
//		courseRepository.deleteById(10002L);
//
//		courseRepository.save(new Course("Some new course"));

//		courseRepository.playWithEntityManager();

//		studentRepository.saveStudentWithPassport();

//		courseRepository.addHardcodedReviewsForCourse();


		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("11", "New Review 11"));
		reviews.add(new Review("22", "New Review 22"));

		courseRepository.addReviewsForCourse(10001L,reviews);

	}
}
