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
@ApplicationService
public class ListOpenEnrollmentCoursesService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();

    public Iterable<CourseDTO> allOpenEnrollmentCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER,
                ElearningRoles.STUDENT);
        Iterable<Course> courses = repo.listAllOpenEnrollmentCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }
}
