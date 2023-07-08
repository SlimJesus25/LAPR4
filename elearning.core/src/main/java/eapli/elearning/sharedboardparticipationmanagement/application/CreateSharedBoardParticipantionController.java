package eapli.elearning.sharedboardparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.domain.*;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class CreateSharedBoardParticipantionController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CreateSharedBoardParticipantionService svc = new CreateSharedBoardParticipantionService();
    private final SharedBoardParticipationRepository repo = PersistenceContext.repositories().sharedBoardParticipations();
    public List<SharedBoardParticipation> createSharedBoardParticipation(List<SystemUser> guests, SharedBoard sharedBoard){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        return svc.createSharedBoardParticipation(UserPermission.READ, UserStatus.GUEST
                , guests, sharedBoard);
    }

    public SharedBoardParticipation createSharedBoardParticipationOwner(SharedBoard sharedBoard){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        SystemUser owner = authz.session().get().authenticatedUser();
        SharedBoardParticipation sharedBoardParticipation
                = SharedBoardParticipationFactory.createSharedBoardParticipation(UserPermission.ADMIN, UserStatus.OWNER
                , owner, sharedBoard);
        return repo.save(sharedBoardParticipation);
    }

    public SharedBoardParticipation createSharedBoardParticipationOwner(SystemUser owner, SharedBoard sharedBoard){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        SharedBoardParticipation sharedBoardParticipation
                = SharedBoardParticipationFactory.createSharedBoardParticipation(UserPermission.ADMIN, UserStatus.OWNER
                , owner, sharedBoard);
        return repo.save(sharedBoardParticipation);
    }
}
