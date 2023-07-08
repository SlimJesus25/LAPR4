package eapli.elearning.elearningusermanagement.application;

import eapli.elearning.elearningusermanagement.repositories.ELearningUserRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.List;

@ApplicationService
public class ShowRolesService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ELearningUserRepository repo = PersistenceContext.repositories().eLearningUsers();
    public List<Role> showRoles() {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        return repo.showRoles();
    }
}
