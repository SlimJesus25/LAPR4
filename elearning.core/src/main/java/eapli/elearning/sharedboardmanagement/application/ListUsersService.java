package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class ListUsersService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SystemUserRepository repo = PersistenceContext.repositories().systemUsers();
    public List<SystemUser> listUsersService(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        SystemUser user = authz.session().get().authenticatedUser();
        List<SystemUser> users = new ArrayList<>();
        repo.findAll().forEach(users::add);
        return users;
    }
}
