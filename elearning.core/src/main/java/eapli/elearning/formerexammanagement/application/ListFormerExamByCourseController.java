package eapli.elearning.formerexammanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.elearning.formerexammanagement.persistence.FormerExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListFormerExamByCourseController {
    private final FormerExamRepository repo = PersistenceContext.repositories().formerExams();
    AuthorizationService authz = AuthzRegistry.authorizationService();
    public Iterable<FormerExam> listFormerExamByCourseController(String courseCode){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        return repo.listFormerExamsByCourse(courseCode);
    }
}
