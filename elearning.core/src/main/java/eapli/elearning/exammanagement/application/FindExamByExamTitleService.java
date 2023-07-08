package eapli.elearning.exammanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class FindExamByExamTitleService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamRepository repo = PersistenceContext.repositories().exams();
    public Exam findExamByExamTitle(String title){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT,
                ElearningRoles.TEACHER);
        List<Exam> e = repo.findExamByTitle(title);
        if(e.isEmpty()){
            return null;
        }else{
            return e.get(0);
        }
    }
}
