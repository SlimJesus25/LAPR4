package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.*;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.time.LocalDateTime;

public class CreateSharedBoardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SharedBoardService service = new SharedBoardService();
    public SharedBoard createSharedBoard(String title, LocalDateTime creationTimestamp){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
      final SharedBoard newSharedBoard = new SharedBoardBuilder()
              .withSharedBoardTitle(title)
              .withSharedBoardCreationTimestamp(creationTimestamp)
              .build();
        return service.createSharedBoard(newSharedBoard);
    }
}
