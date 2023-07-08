package eapli.elearning.exammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseBuilder;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.domain.TeacherBuilder;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ExamTest {

    SystemUser user = dummyUser("dummy1", ElearningRoles.POWER_USER);
    Teacher teacher = dummyTeacher("dummy", "dummy",  LocalDate.of(1999, Month.JUNE, 10), user);
    Course course = dummyCourse("cc1", "dummy", "dummy", CourseState.CLOSE, teacher);

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }
    public static Course dummyCourse(final String courseCode, final String courseTitle, final String courseDescription,
                                         final CourseState state, final Teacher regent) {
        final CourseBuilder builder = new CourseBuilder();
        return builder.withCourseCode(courseCode).withCourseTitle(courseTitle).withCourseState(state).withRegent(regent)
                .withCourseDescription(courseDescription).build();
    }
    public static Teacher dummyTeacher(final String acronym, final String taxPayerNumber, final LocalDate dateOfBirth,
                                       SystemUser systemUser) {
        final TeacherBuilder builder = new TeacherBuilder();
        return builder.withTeacherAcronym(acronym).withTeacherDateOfBirth(dateOfBirth).withTeacherSystemUser(systemUser)
                .withTeacherTaxPayerNumber(taxPayerNumber).build();
    }

     @Test
     public void ensureExamTitleCantBeNull(){
         Assertions.assertThrows(IllegalArgumentException.class, () -> new Exam(null, "header"
                 , null, course, ExamType.NORMAL
                 , LocalDateTime.now().plusSeconds(10), LocalDateTime.now().plusSeconds(20)));
     }
}
