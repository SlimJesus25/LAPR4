package eapli.elearning.examquestionmanagement.application;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.examquestionmanagement.domain.QuestionFactory;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashMap;
import java.util.List;


/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CreateExamQuestionController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamQuestionRepository repo = PersistenceContext.repositories().examQuestions();
    public ExamQuestionDTO createQuestion(ExamQuestionType questionType, List<String> solutions, Integer value,
                                          HashMap<ExamQuestionResult,String> feedbacks, String statement){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        final ExamQuestion question = QuestionFactory.createQuestion(questionType, solutions, value, feedbacks,statement);
        return repo.save(question).toDTO();
    }
}
