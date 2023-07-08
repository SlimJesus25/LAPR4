package eapli.elearning.sharedboardmanagement.domain;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardparticipationmanagement.domain.SharedBoardParticipation;
import eapli.elearning.sharedboardparticipationmanagement.domain.SharedBoardParticipationFactory;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserStatus;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


public class ShareSharedBoardService {
    private final SharedBoardParticipationRepository sharedBoardParticipationRepo
            = PersistenceContext.repositories().sharedBoardParticipations();
    private final SystemUserRepository systemUserRepository = PersistenceContext.repositories().systemUsers();
    public String shareBoard(SharedBoard sharedBoard, String username, UserPermission permission) {
        SystemUser user = systemUserRepository.findSystemUserByUsername(username);
        UserStatus stats = UserStatus.GUEST;
        SharedBoardParticipation e = SharedBoardParticipationFactory.createSharedBoardParticipation(
                permission, stats, user, sharedBoard);
        sharedBoardParticipationRepo.save(e);
        return "";
    }
}
