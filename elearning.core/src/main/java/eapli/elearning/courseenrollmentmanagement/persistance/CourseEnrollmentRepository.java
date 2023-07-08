package eapli.elearning.courseenrollmentmanagement.persistance;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface CourseEnrollmentRepository extends DomainRepository<Integer, CourseEnrollment> {
    public Iterable<CourseEnrollment> listCourseEnrollments();

    public Iterable<CourseEnrollment> listStudentsApplicatedTo(String courseCode);
    public CourseEnrollment updateEnrollmentState(CourseEnrollment courseEnrollment, StudentEnrollmentState approval);
    public Iterable<Course> coursesThatStudentIsEnrolledOn(String mechanographicNumber);

    Iterable<Course> listOpenEnrollmentCoursesAvailableToEnrollStudentController(Student student);

    Iterable<Course> checkIfStudentEnrolledInCourse(Course course, Student student);

    Iterable<Student> listStudentsEnrolledInCourse(String courseCode);
}
