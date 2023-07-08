package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.*;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaCourseRepository extends JpaAutoTxRepository<Course, CourseCode, CourseCode> implements CourseRepository {
    public JpaCourseRepository(final TransactionalContext autoTx) {
        super(autoTx, "courseCode");
    }

    public JpaCourseRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "courseCode");
    }

    @Override
    public Teacher findRegentOf(String courseCode){
        final TypedQuery<Teacher> query = entityManager().createQuery("SELECT t FROM Teacher t " +
                "JOIN Course co ON upper(co.regent.teacherAcronym)=upper(t.teacherAcronym) where " +
                "upper(co.courseCode)=upper(:course)", Teacher.class);
        query.setParameter("course", courseCode);
        return query.getSingleResult();
    }

    @Override
    public List<Course> listTeacherCourses(SystemUser teacher) {
        final TypedQuery<Course> query = entityManager().createQuery("SELECT t.course FROM TeamElement t " +
                "WHERE t.teacher.systemUser = :teacher " +
                "OR t.course.regent.systemUser = :teacher", Course.class);
        query.setParameter("teacher", teacher);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> listAllCourses() {
        final TypedQuery<Course> query = entityManager().createQuery("SELECT a FROM Course a", Course.class);
        return query.getResultList();
    }
    @Override
    public Iterable<Course> listAllOpenEnrollmentCourses() {
        final TypedQuery<Course> query = entityManager().createQuery("SELECT a FROM Course a WHERE a.courseState "+
                "= :courseState", Course.class);
        query.setParameter("courseState", CourseState.OPEN_WITH_ENROLLMENTS);
        return query.getResultList();
    }
    @Override
    public Course findCourseByCode(String courseCode) {
        final TypedQuery<Course> query = entityManager().createQuery("SELECT a FROM Course a WHERE upper(a.courseCode)" +
                " = upper(:course)", Course.class);
        query.setParameter("course", courseCode);
        return query.getSingleResult();
    }

    @Override
    public Course updateCourseEnrollmentState(Course course, CourseState newState) {
        switch(newState){
            case CLOSE: course.closeCourse();break;
            case OPEN: course.openCourse();break;
            case OPEN_WITH_ENROLLMENTS: course.openCourseWithEnrollments();break;
            case OPEN_WITHOUT_ENROLLMENTS: course.openCourseWithoutEnrollments();break;
        }
        this.save(course);
        return course;
    }


    public Course findCourseRuledBy(String teacherAcronym) {
        TypedQuery<Course> query = entityManager().createQuery("SELECT c FROM Course c WHERE" +
                " c.regent.id.teacherAcronym=:teacherAcronym", Course.class);
        query.setParameter("teacherAcronym", teacherAcronym);
        return  query.getSingleResult();
        /*final Map<String, Object> params = new HashMap<>();
        params.put("teacherAcronym", teacherAcronym);
        return matchOne("a.regent.id.teacherAcronym=:teacherAcronym", params);
        */
    }
}
