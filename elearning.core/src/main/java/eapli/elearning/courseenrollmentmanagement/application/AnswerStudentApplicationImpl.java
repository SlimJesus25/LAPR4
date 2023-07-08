package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public class AnswerStudentApplicationImpl implements AnswerStudentApplication{

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();
    private final AnswerStudentApplicationService service = new AnswerStudentApplicationService();

    @Override
    public CourseEnrollmentDTO answerStudentApplication(Integer identity, CourseDTO courseCode, StudentDTO studentMechanographicalNumber,
                                                        StudentEnrollmentState approval) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR,ElearningRoles.POWER_USER);

        var theEnrollment = repo.ofIdentity(identity)
                .orElseThrow(IllegalArgumentException::new);
        service.setCourseEnrollmentState(theEnrollment, approval);
        return theEnrollment.toDTO();
    }


}
