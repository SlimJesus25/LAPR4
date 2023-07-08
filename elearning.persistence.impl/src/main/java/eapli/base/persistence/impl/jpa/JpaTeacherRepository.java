package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class  JpaTeacherRepository extends JpaAutoTxRepository<Teacher, TeacherAcronym, TeacherAcronym> implements TeacherRepository {

    public JpaTeacherRepository(final TransactionalContext autoTx) {
        super(autoTx, "teacherAcronym");
    }

    public JpaTeacherRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "teacherAcronym");
    }

    @Override
    public Teacher findTeacherByUserName(Username username) {
        final TypedQuery<Teacher> query = entityManager().createQuery("SELECT a FROM Teacher a" +
                " WHERE upper(a.systemUser.id.value) = upper(:user)", Teacher.class);
        query.setParameter("user", username.toString());
        return query.getSingleResult();
    }
    @Override
    public Teacher findTeacherByAcronym(String acronym) {
        final TypedQuery<Teacher> query = entityManager().createQuery("SELECT a FROM Teacher a" +
                " WHERE upper(a.teacherAcronym) = upper(:acronym)", Teacher.class);
        query.setParameter("acronym", acronym);
        return query.getSingleResult();
    }

    @Override
    public Teacher regentOfCourse(Course course){
        final TypedQuery<Teacher> query = entityManager().createQuery("SELECT t FROM Teacher t " +
                "JOIN Course co ON upper(co.regent.teacherAcronym)=upper(t.teacherAcronym) where upper(co.courseCode)=upper(:course)", Teacher.class);
        query.setParameter("course",course);
        return query.getSingleResult();
    }

    @Override
    public Iterable<Teacher> listTeachers() {
        return null;
    }
}
