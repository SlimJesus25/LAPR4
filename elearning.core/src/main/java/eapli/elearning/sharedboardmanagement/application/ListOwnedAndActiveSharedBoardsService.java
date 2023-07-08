package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

@ApplicationService
public class ListOwnedAndActiveSharedBoardsService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SharedBoardRepository repo = PersistenceContext.repositories().sharedBoards();
    public List<SharedBoardDTO> listOwnedAndActiveSharedBoards(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        SystemUser user = authz.session().get().authenticatedUser();
        List<SharedBoardDTO> sharedBoards = new ArrayList<>();
        repo.findSharedBoardsOwnedandActiveByUser(user).forEach(e -> sharedBoards.add(e.toDTO()));
        return sharedBoards;
    }
}
