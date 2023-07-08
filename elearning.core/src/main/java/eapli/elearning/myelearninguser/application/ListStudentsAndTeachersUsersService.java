package eapli.elearning.myelearninguser.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ListStudentsAndTeachersUsersService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SystemUserRepository repo = PersistenceContext.repositories().systemUsers();
    public List<SystemUser> listStudentsAndTeachersUsers(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        List<SystemUser> users = new ArrayList<>();
        repo.findAll().forEach(users::add);
        users.remove(authz.session().get().authenticatedUser());
        return users;
    }
}
