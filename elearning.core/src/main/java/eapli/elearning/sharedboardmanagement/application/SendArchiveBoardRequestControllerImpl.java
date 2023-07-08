package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.ArchiveSharedBoardService;
import eapli.elearning.sharedboardmanagement.domain.SendArchiveSharedBoardRequestService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.io.IOException;
import java.util.List;

public class SendArchiveBoardRequestControllerImpl implements SendArchiveBoardRequestController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ArchiveSharedBoardService archiveSvc = new ArchiveSharedBoardService();


    @Override
    public String archiveBoard(SharedBoard sharedBoard, String username) {
        //authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        return archiveSvc.archiveSharedBoard(sharedBoard, username);
    }
}
