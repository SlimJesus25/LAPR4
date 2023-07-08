package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
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
public class SetCourseEnrollmentStateService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepo = PersistenceContext.repositories().courses();

    public Course setCourseEnrollmentState(Course course, CourseState state) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        courseRepo.updateCourseEnrollmentState(course, state);
        return course;
    }
}
