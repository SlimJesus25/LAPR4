package eapli.elearning.examsectionmanagement.application;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examsectionmanagement.domain.SectionFactory;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CreateExamSectionController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamSectionRepository repo = PersistenceContext.repositories().examSections();
    public ExamSectionDTO createSection(String examSectionTextualDescription, Set<ExamQuestion> questions){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        final ExamSection newSection = SectionFactory.createSection(examSectionTextualDescription, questions);
        return repo.save(newSection).toDTO();
    }
}
