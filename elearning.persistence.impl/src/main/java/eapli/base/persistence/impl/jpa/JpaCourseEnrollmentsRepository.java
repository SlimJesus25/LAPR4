package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaCourseEnrollmentsRepository extends JpaAutoTxRepository<CourseEnrollment, Integer, Integer> implements CourseEnrollmentRepository {
    public JpaCourseEnrollmentsRepository(final TransactionalContext autoTx) {
        super(autoTx, "courseEnrollmentID");
    }

    public JpaCourseEnrollmentsRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "courseEnrollmentID");
    }

    @Override
    public Iterable<CourseEnrollment> listCourseEnrollments() {
        final TypedQuery<CourseEnrollment> query = entityManager().
                createQuery("SELECT DISTINCT a FROM CourseEnrollment a", CourseEnrollment.class);
        // WHERE upper(a.courseEnrollmentCourse.courseState) =upper(:state)"
        //query.setParameter("state", CourseState.OPEN_WITH_ENROLLMENTS);
        return query.getResultList();
    }

    @Override
    public Iterable<CourseEnrollment> listStudentsApplicatedTo(String courseCode) {
        final TypedQuery<CourseEnrollment> query = entityManager().
                createQuery("SELECT DISTINCT a FROM CourseEnrollment a " +
                        "WHERE a.courseEnrollmentCourse.courseCode.courseCode = :course", CourseEnrollment.class);
        query.setParameter("course", courseCode);
        return query.getResultList();
    }

    @Override
    public CourseEnrollment updateEnrollmentState(CourseEnrollment courseEnrollment, StudentEnrollmentState approval) {
        courseEnrollment.updateStudentEnrollment(approval);
        this.save(courseEnrollment);
        return courseEnrollment;
    }

    @Override
    public Iterable<Course> coursesThatStudentIsEnrolledOn(String mechanographicNumber) {
        final TypedQuery<Course> query = entityManager().
                createQuery("SELECT DISTINCT a.courseEnrollmentCourse FROM CourseEnrollment a " +
                        "WHERE upper(a.courseEnrollmentStudent.mechanographicalNumber) = upper(:mechanographic) " +
                                "AND upper(a.studentEnrollmentState) = 'ENROLLED'",
                        Course.class);
        query.setParameter("mechanographic", mechanographicNumber);
        return query.getResultList();
    }
    @Override
    public Iterable<Course> listOpenEnrollmentCoursesAvailableToEnrollStudentController(Student student){
        final TypedQuery<Course> query = entityManager().
                createQuery("SELECT a.courseEnrollmentCourse FROM CourseEnrollment a " +
                                "WHERE a.courseEnrollmentStudent !=: student ",
                        Course.class);
        query.setParameter("student", student);
        return query.getResultList();
    }
    @Override
    public Iterable<Course> checkIfStudentEnrolledInCourse(Course course, Student student){
        final TypedQuery<Course> query = entityManager().
                createQuery("SELECT a.courseEnrollmentCourse FROM CourseEnrollment a " +
                                "WHERE a.courseEnrollmentStudent =: student and a.courseEnrollmentCourse=: course",
                        Course.class);
        query.setParameter("student", student);
        query.setParameter("course", course);
        return query.getResultList();
    }

    @Override
    public Iterable<Student> listStudentsEnrolledInCourse(String courseCode) {
        final TypedQuery<Student> query = entityManager().
                createQuery("SELECT a.courseEnrollmentStudent FROM CourseEnrollment a " +
                                "WHERE upper(a.courseEnrollmentCourse.courseCode.courseCode) = upper(:course)" +
                                "AND upper(a.studentEnrollmentState) = 'ENROLLED'",
                        Student.class);
        query.setParameter("course", courseCode);
        return query.getResultList();
    }

}
