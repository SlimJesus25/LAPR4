package eapli.elearning.postitmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class UndoChangeControllerImpl implements UndoChangeController{
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    public String undoChange(SharedBoard sharedBoard){
        //auth.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER);
        sharedBoard.undoLastChange();
        return "";
    }
}
