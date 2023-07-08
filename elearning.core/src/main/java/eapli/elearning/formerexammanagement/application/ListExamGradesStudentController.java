package eapli.elearning.formerexammanagement.application;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.formerexammanagement.domain.FormerExamService;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListExamGradesStudentController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final FormerExamService formerExam = new FormerExamService();

    public Iterable<FormerExamDTO> listExamsGrades(CourseDTO course){
        auth.ensureAuthenticatedUserHasAnyOf(ElearningRoles.STUDENT);
        return formerExam.listExamsGrades(course);
    }
}
