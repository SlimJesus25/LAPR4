package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface SendShareSharedBoardController {

    String shareBoard(SharedBoard sharedBoard, String username, UserPermission permission);
}
