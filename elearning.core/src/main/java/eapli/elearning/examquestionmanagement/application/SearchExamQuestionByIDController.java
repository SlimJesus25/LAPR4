package eapli.elearning.examquestionmanagement.application;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SearchExamQuestionByIDController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamQuestionRepository repo = PersistenceContext.repositories().examQuestions();
    public ExamQuestion searchExamQuestionByID(Integer identifier){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        return repo.ofIdentity(identifier).orElseThrow(IllegalAccessError::new);
    }
}
