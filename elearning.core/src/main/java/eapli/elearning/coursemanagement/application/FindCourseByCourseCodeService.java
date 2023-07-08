package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@ApplicationService
public class FindCourseByCourseCodeService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();
    public Course findCourseByCourseCode(String courseCode){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        return repo.findCourseByCode(courseCode);
    }
}
