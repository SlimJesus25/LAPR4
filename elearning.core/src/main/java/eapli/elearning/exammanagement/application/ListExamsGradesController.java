package eapli.elearning.exammanagement.application;

import eapli.elearning.coursemanagement.application.CourseService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.formerexammanagement.domain.FormerExamService;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.elearning.teachermanagement.application.TeacherService;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListExamsGradesController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FormerExamService formerexam = new FormerExamService();
    private final CourseService CsService = new CourseService();

    public Iterable<FormerExamDTO> listExamsGrades(CourseDTO course){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER);
        return formerexam.listExamsGrades(course);
    }

    public Iterable<FormerExamDTO> listAllGrades(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER);
        return formerexam.listAllGrades(CsService.teacherCourses(this.authz.session().get().authenticatedUser()));
    }
}
