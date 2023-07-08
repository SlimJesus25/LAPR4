package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CreateSharedBoardParticipantionService {
    SharedBoardParticipationRepository repo = PersistenceContext.repositories().sharedBoardParticipations();
    public List<SharedBoardParticipation> createSharedBoardParticipation(UserPermission userPermission, UserStatus userStatus
            , List<SystemUser> guests, SharedBoard sharedBoard){
        List<SharedBoardParticipation> sharedBoardParticipations = new ArrayList<>();
        for(SystemUser systemUser : guests){
            SharedBoardParticipation e = SharedBoardParticipationFactory.createSharedBoardParticipation(
                    userPermission, userStatus, systemUser, sharedBoard);
            sharedBoardParticipations.add(repo.save(e));
        }
        return sharedBoardParticipations;
    }
}
