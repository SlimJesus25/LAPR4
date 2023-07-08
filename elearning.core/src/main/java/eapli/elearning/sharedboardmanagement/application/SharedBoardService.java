package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;

public class SharedBoardService {
    private final SharedBoardRepository repo = PersistenceContext.repositories().sharedBoards();
    public SharedBoard createSharedBoard(SharedBoard newSharedBoard){
        return repo.save(newSharedBoard);
    }
}
