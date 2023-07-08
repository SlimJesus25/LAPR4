package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@ApplicationService
public class AnswerStudentApplicationService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();

    public CourseEnrollment setCourseEnrollmentState(CourseEnrollment enrollment, StudentEnrollmentState approval) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        if(approval == StudentEnrollmentState.ACCEPTED){
            enrollment.acceptStudentApplication();
        }else{
            enrollment.rejectStudentApplication();
        }
        return repo.save(enrollment);
    }
}
