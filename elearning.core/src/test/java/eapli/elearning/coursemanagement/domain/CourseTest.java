package eapli.elearning.coursemanagement.domain;

import eapli.elearning.courseteammanagement.domain.CourseTeam;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseTest {

    SystemUser user = dummyUser("dummy1", ElearningRoles.POWER_USER);

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    @Test
    public void ensureCourseTitleCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("JAVA", null
                , "Java Collections Framework", CourseState.CLOSE, new Teacher("AMS"
                , "21321312", LocalDate.of(1990,12,3), user)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("JAVA"
                , "", "Java Collections Framework"
                , CourseState.CLOSE, new Teacher("AMS", "21321312"
                , LocalDate.of(1990,12,03), user)));
    }

    @Test
    public void ensureCourseCodeCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course(null, "Java Collections Framework",
                    "Java Collections Framework", CourseState.CLOSE, new Teacher("AMS",
                    "21321312", LocalDate.of(1990,12,3), user));
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course("", "Java Collections Framework",
                    "Java Collections Framework", CourseState.CLOSE, new Teacher("AMS",
                    "21321312", LocalDate.of(1990,12,3), user));
        });
    }

    @Test
    public void ensureCourseDescriptionCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course("JAVA", "Java Collections Framework",
                    null, CourseState.CLOSE, new Teacher("AMS",
                    "21321312", LocalDate.of(1990,12,3), user));
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course("JAVA", "Java Collections Framework",
                    "", CourseState.CLOSE, new Teacher("AMS",
                    "21321312", LocalDate.of(1990,12,3), user));
        });
    }

    @Test
    public void ensureCourseWorkFlowComply(){
        Course c1 = new Course("JAVA", "Java Collections Framework",
                "Java Collections Framework", CourseState.CLOSE, new Teacher("AMS",
                "21321312", LocalDate.of(1990,12,3), user));

        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithoutEnrollments);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithEnrollments);
        Assertions.assertThrows(IllegalArgumentException.class, c1::closeCourse);

        c1.openCourse();

        Assertions.assertThrows(IllegalArgumentException.class, c1::closeCourse);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourse);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithoutEnrollments);

        c1.openCourseWithEnrollments();

        Assertions.assertThrows(IllegalArgumentException.class, c1::closeCourse);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourse);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithEnrollments);

        c1.openCourseWithoutEnrollments();

        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourse);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithEnrollments);
        Assertions.assertThrows(IllegalArgumentException.class, c1::openCourseWithoutEnrollments);

        c1.closeCourse();
    }


}
