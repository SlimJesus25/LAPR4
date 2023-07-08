package eapli.elearning.formerexammanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.domain.*;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.formerexammanagement.domain.*;
import eapli.elearning.formerexammanagement.persistence.FormerExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
@UseCaseController
public class CreateFormerExamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final FormerExamRepository repo = PersistenceContext.repositories().formerExams();
    public FormerExam createFormerExam(Integer formerExamGrade, Exam formerExamExam, Student formerExamStudent) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT);

        final FormerExam formerExam = new FormerExamBuilder()
                .withFormerExamGrade(formerExamGrade)
                .withFormerExamExam(formerExamExam)
                .withFormerExamStudent(formerExamStudent)
                .build();
        return repo.save(formerExam);
    }

}
