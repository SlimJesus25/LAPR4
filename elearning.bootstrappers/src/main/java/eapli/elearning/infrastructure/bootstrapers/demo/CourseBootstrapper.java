package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.coursemanagement.application.CreateCourseController;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseBootstrapper.class);

    private final CreateCourseController controller = new CreateCourseController();
    @Override
    public boolean execute() {

        Teacher regent1 = new Teacher("ABCD", "100200300", LocalDate.of(1973, Month.JULY,
                31), getSystemUserByUsername("ricardoT"));
        Teacher regent2 = new Teacher("ZZXX", "150250350", LocalDate.of(1995, Month.JULY,
                1), getSystemUserByUsername("venancioT"));
        Teacher regent3 = new Teacher("DCBA", "300200100", LocalDate.of(1973, Month.JULY,
                31),getSystemUserByUsername("krillinT"));
        Teacher regent4 = new Teacher("CCDD", "300200500", LocalDate.of(1973, Month.JULY,
                31), getSystemUserByUsername("gabrielT"));

        Course c1 = createCourse("SEM02-JAVA", "JAVA", "Java Collections Framework2",
                CourseState.CLOSE, regent1);
        Course c2 = createCourse("SEM02-PYTHON", "PYTHON", "PyNum2",
                CourseState.CLOSE, regent2);
        Course c3 = createCourse("SEM01-PYTHON", "PYTHON", "PyNum1",
                CourseState.CLOSE, regent3);
        Course c4 = createCourse("SEM01-JAVA", "PYTHON", "Java Collections Framework1",
                CourseState.CLOSE, regent4);
        LOGGER.debug("»»» Demo Course created{}", id);
        return true;

    }

    private Course createCourse(String courseCode, String courseTitle, String courseDescription,
                                CourseState state, Teacher regent){
        Course c;
        c = controller.createCourse(courseCode, courseTitle, courseDescription, state, regent.identity().acronym());
        return null;
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }

}