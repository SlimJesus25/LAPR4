package eapli.elearning.extralecturemanagement.application;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class FindExtraLectureByIdController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExtraLectureRepository repo = PersistenceContext.repositories().extraLectures();
    public ExtraLecture findExtraLectureById(Integer id){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.TEACHER);
        return repo.findExtraLectureByID(id);
    }
}
