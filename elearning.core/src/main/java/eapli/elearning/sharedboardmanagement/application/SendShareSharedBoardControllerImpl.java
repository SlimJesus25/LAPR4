package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.ShareSharedBoardService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class SendShareSharedBoardControllerImpl implements SendShareSharedBoardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShareSharedBoardService svc2 = new ShareSharedBoardService();

    @Override
    public String shareBoard(SharedBoard sharedBoard, String username, UserPermission permission) {
        //authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        return svc2.shareBoard(sharedBoard, username, permission);
    }
}
