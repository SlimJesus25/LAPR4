package eapli.elearning.sharedboardmanagement.repositories;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface SharedBoardRepository extends DomainRepository<Integer, SharedBoard> {

    SharedBoard findSharedBoardsByTitle(String sharedBoardTitle);

    SharedBoard findSharedBoarByTitle(String title);
    List<SharedBoard> findSharedBoardsOwnedandActiveByUser(SystemUser user);
}
