package eapli.elearning.courseenrollment.domain;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentDate;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class CourseEnrollmentTest {
    CourseEnrollmentDate date;
    StudentEnrollmentState state;
    Course course;
    Student student;

    SystemUser user = dummyUser("dummy1", ElearningRoles.POWER_USER);

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    @BeforeEach
    void setUp() {
        date = new CourseEnrollmentDate(LocalDate.of(2023,12,12));
        state = StudentEnrollmentState.ENROLLED;
        Teacher teacher = new Teacher("AMS", "21321312", LocalDate.of(1990,12, 3), user);
        course = new Course("JAVA", "Java Collections Framework", "Java Collections Framework", CourseState.CLOSE, teacher);
        student = new Student("21321312", LocalDate.of(1990,12, 3), user);
    }
    @Test
    public void ensureCourseEnrollmentDateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CourseEnrollment(null, state, course, student));
    }
    @Test
    public void ensureStudentEnrollmentStateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CourseEnrollment(date.date(), null, course, student));
    }
    @Test
    public void ensureCourseCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CourseEnrollment(date.date(), state, null, student));
    }
    @Test
    public void ensureStudentCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CourseEnrollment(date.date(), state, course, null));
    }

    @Test
    public void ensureAcceptApplication(){
        StudentEnrollmentState accept = StudentEnrollmentState.ACCEPTED;
        CourseEnrollment courseEnrollment = new CourseEnrollment(date.date(), state, course, student);
        courseEnrollment.acceptStudentApplication();
        Assertions.assertSame(accept, courseEnrollment.enrollmentState());
    }

    @Test
    public void ensureRejectApplication(){
        StudentEnrollmentState reject = StudentEnrollmentState.REJECTED;
        CourseEnrollment courseEnrollment = new CourseEnrollment(date.date(), state, course, student);
        courseEnrollment.rejectStudentApplication();
        Assertions.assertSame(reject, courseEnrollment.enrollmentState());
    }
}
