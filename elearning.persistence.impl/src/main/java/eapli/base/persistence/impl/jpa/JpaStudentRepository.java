package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import javax.persistence.TypedQuery;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaStudentRepository extends JpaAutoTxRepository<Student, StudentMechanographicalNumber,
        StudentMechanographicalNumber> implements StudentRepository {

    public JpaStudentRepository(final TransactionalContext autoTx) {
        super(autoTx, "studentMechanographicalNumber");
    }

    public JpaStudentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "studentMechanographicalNumber");
    }

    @Override
    public Iterable<Student> findAllStudents() {
        final TypedQuery<Student> query = entityManager().createQuery("SELECT a FROM Student a", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findStudentByMechanographicalNumber(String mechanographicalNumber) {
        final TypedQuery<Student> query = entityManager().createQuery("SELECT a FROM Student a" +
                " WHERE upper(a.mechanographicalNumber) = upper(:meca)", Student.class);
        query.setParameter("meca", mechanographicalNumber);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentByUserName(Username user) {
        final TypedQuery<Student> query = entityManager().createQuery("SELECT a FROM Student a" +
                " WHERE upper(a.systemUser.id.value) = upper(:user)", Student.class);
        query.setParameter("user", user.toString());
        return query.getSingleResult();
    }
}
