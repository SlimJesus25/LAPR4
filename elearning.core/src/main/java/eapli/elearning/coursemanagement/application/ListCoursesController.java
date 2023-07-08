package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Controller
public class ListCoursesController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();

    public Iterable<CourseDTO> allCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER,ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Iterable<Course> courses = repo.listAllCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }
}
