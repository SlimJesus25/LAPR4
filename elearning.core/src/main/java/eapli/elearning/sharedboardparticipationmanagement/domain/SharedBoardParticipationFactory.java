package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SharedBoardParticipationFactory {
    public static SharedBoardParticipation createSharedBoardParticipation(UserPermission userPermission
            , UserStatus userStatus, SystemUser user, SharedBoard sharedBoard){
        return new SharedBoardParticipation(userPermission, userStatus, user, sharedBoard);
    }
}
