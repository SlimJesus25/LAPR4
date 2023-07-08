package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Controller;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Controller
public class VisualizeSharedBoardController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    public String visualizeSharedBoard(SharedBoard sharedBoard){
        //authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER);
        return sharedBoard.visualizeBoard();
    }

}
