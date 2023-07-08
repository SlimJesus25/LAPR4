package eapli.elearning.exammanagement.application;

import eapli.elearning.coursemanagement.application.CourseService;
import eapli.elearning.coursemanagement.application.ListCoursesController;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.application.TeacherService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ListExamsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamService exam = new ExamService();
    public Iterable<ExamDTO> listExams(CourseDTO courseDTO){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER, ElearningRoles.POWER_USER);
        return exam.listExams(new CourseCode(courseDTO.getCourseCode()));
    }
}
