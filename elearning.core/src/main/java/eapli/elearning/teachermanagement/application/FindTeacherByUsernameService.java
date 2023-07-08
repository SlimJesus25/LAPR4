package eapli.elearning.teachermanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.stereotype.Controller;

@ApplicationService
public class FindTeacherByUsernameService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeacherRepository repo = PersistenceContext.repositories().teachers();
    public Teacher findTeacherByUsername(Username userName) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.TEACHER);
        return repo.findTeacherByUserName(userName);
    }
}
