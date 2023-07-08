package eapli.elearning.sharedboardmanagement.domain;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.framework.domain.services.DomainService;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@DomainService
public class ArchiveSharedBoardService {

    private final SharedBoardRepository sharedBoardRepo = PersistenceContext.repositories().sharedBoards();
    private final SharedBoardParticipationRepository sharedBoardParticipationRepo
            = PersistenceContext.repositories().sharedBoardParticipations();

    public String archiveSharedBoard(SharedBoard sharedBoard, String username){
        if(sharedBoardParticipationRepo.isUserOwnerOfSharedBoard(sharedBoard, username)){
            sharedBoard.archiveBoard();
            sharedBoardRepo.save(sharedBoard);
        }else{
            throw new IllegalArgumentException("You don't own this board!");
        }
        return "";
    }

}
