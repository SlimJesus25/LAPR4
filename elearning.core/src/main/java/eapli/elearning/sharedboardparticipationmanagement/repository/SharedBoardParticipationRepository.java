package eapli.elearning.sharedboardparticipationmanagement.repository;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.domain.SharedBoardParticipation;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface SharedBoardParticipationRepository extends DomainRepository<Integer, SharedBoardParticipation> {
    boolean isUserOwnerOfSharedBoard(SharedBoard sharedBoard, String username);

    public SharedBoard findSharedBoarByTitle(String title);
    List<SharedBoard> listWritableSharedBoards(SystemUser user);
}
