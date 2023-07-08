package eapli.elearning.exammanagement.application;

import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.elearningusermanagement.domain.MecanographicNumber;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListUserExamsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final IExamService service = new ExamService();
    public Iterable<ExamDTO> listUserExams() {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ELEARNING_USER, ElearningRoles.STUDENT);
        return service.listUserExams(authz.session().get().authenticatedUser());
    }
}
