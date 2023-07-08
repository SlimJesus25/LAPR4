package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public class SetCourseEnrollmentStateControllerImpl implements SetCourseEnrollmentStateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepo = PersistenceContext.repositories().courses();
    private final SetCourseEnrollmentStateService service = new SetCourseEnrollmentStateService();

    @Override
    public CourseDTO setCourseEnrollmentStateTo(String courseCode, CourseState state) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR,ElearningRoles.POWER_USER);
        Course theCourse = courseRepo.findCourseByCode(courseCode);
        service.setCourseEnrollmentState(theCourse, state);
        return theCourse.toDTO();
    }
}
