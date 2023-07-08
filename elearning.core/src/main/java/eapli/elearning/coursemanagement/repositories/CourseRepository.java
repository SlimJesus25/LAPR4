package eapli.elearning.coursemanagement.repositories;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface CourseRepository extends DomainRepository<CourseCode, Course> {

    public Iterable<Course> listAllCourses();
    public Course findCourseByCode(String courseCode);

    public Course updateCourseEnrollmentState(Course course, CourseState newState);

    public Iterable<Course> listAllOpenEnrollmentCourses();
    public Teacher findRegentOf(String courseCode);
    List<Course> listTeacherCourses(SystemUser teacher);
}
