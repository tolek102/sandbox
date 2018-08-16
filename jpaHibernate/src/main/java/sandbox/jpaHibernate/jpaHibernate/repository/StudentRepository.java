package sandbox.jpaHibernate.jpaHibernate.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sandbox.jpaHibernate.jpaHibernate.entity.Passport;
import sandbox.jpaHibernate.jpaHibernate.entity.Student;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student) {
        if(student.getId()==null){
            entityManager.persist(student);
        }else{
            entityManager.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("New1111111");
        entityManager.persist(passport);
        Student student = new Student("NewStudent5");
        student.setPassport(passport);
        entityManager.persist(student);

    }

}
