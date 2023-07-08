package eapli.elearning.examsectionmanagement.application;

import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SearchExamSectionByIDController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamSectionRepository repo = PersistenceContext.repositories().examSections();
    public ExamSection searchExamSectionByID(Integer identifier){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        return repo.ofIdentity(identifier).orElseThrow(IllegalAccessError::new);
    }
}
