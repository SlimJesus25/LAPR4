package eapli.elearning.automaticformativeexammanagement.application;

import eapli.elearning.coursemanagement.application.ListTeacherCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.domain.CreateAutomaticFormativeExamService;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.formativeexamantlr.FormativeExamParserService;
import eapli.elearning.exammanagement.domain.formativeexamupdateantlr.UpdateFormativeExamParserService;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CreateUpdateAutomaticFormativeExamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CreateAutomaticFormativeExamService svc = new CreateAutomaticFormativeExamService();
    private final ListTeacherCoursesService listTeacherCoursesCtrl = new ListTeacherCoursesService();
    private final FormativeExamParserService antlrSvc = new FormativeExamParserService();
    private final UpdateFormativeExamParserService uAntlrSvc = new UpdateFormativeExamParserService();
    public ExamDTO createAutomaticFormativeExamController(CourseDTO course, String path) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        antlrSvc.parse(path);
        String title = antlrSvc.title();
        String header = antlrSvc.header();
        HashMap<String, List<ExamQuestionType>> sectionQuestions = antlrSvc.sections();
        return svc.createAutomaticFormativeExam(title, header, sectionQuestions, course)
                .toDTO();
    }

    public ExamDTO updateAutomaticFormativeExamController(String path) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        uAntlrSvc.parse(path);
        Exam exam = uAntlrSvc.exam();
        HashMap<String, List<ExamQuestionType>> sections = uAntlrSvc.sections();
        return svc.updateAutomaticFormativeExam(exam, sections).toDTO();
    }

    public List<CourseDTO> listTeacherCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER, ElearningRoles.POWER_USER);
        return listTeacherCoursesCtrl.listTeacherCourses();
    }
}
