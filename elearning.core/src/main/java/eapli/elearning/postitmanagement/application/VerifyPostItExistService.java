package eapli.elearning.postitmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class VerifyPostItExistService {
    private final SharedBoardParticipationRepository repo = PersistenceContext.repositories().sharedBoardParticipations();

    public boolean verifyPosition(Integer row, Integer column, SharedBoardDTO sharedBoard){
        SharedBoard board=repo.findSharedBoarByTitle(sharedBoard.getSharedBoardTitle());
        if(board.postIt(row, column) != null){
            //ja tem post it
            return false;
        }
        return true;
    }

}
