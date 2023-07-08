package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@ApplicationService
public class ListTeacherCoursesService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();
    public List<CourseDTO> listTeacherCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER, ElearningRoles.POWER_USER);
        List<Course> courses = repo.listTeacherCourses(authz.session().get().authenticatedUser());
        List<CourseDTO> coursesDTO = new ArrayList<>();
        courses.forEach(e -> coursesDTO.add(e.toDTO()));
        return coursesDTO;
    }
}
