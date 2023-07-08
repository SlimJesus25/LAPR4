package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.framework.application.ApplicationService;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@ApplicationService
public class FindSharedBoardByTitleService {
    SharedBoardRepository repo = PersistenceContext.repositories().sharedBoards();
    public SharedBoard findSharedBoardByTitle(String title){
        return repo.findSharedBoardsByTitle(title);
    }
}
