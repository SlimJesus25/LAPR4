package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.domain.SharedBoardState;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserStatus;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaSharedBoardRepository extends JpaAutoTxRepository<SharedBoard, Integer, Integer> implements SharedBoardRepository {

    public JpaSharedBoardRepository(final TransactionalContext autoTx) {
        super(autoTx, "identifier");
    }

    public JpaSharedBoardRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "identifier");
    }

    @Override
    public SharedBoard findSharedBoardsByTitle(String sharedBoardTitle) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery("SELECT a FROM SharedBoard a WHERE" +
                " upper(a.sharedBoardTitle.title) = upper(:title)", SharedBoard.class);
        query.setParameter("title", sharedBoardTitle);
        return query.getSingleResult();
    }

    @Override
    public SharedBoard findSharedBoarByTitle(String title) {
        return null;
    }

    @Override
    public List<SharedBoard> findSharedBoardsOwnedandActiveByUser(SystemUser user) {
        UserStatus owner = UserStatus.OWNER;
        SharedBoardState inactive = SharedBoardState.INACTIVE;
        final TypedQuery<SharedBoard> query = entityManager().createQuery("SELECT a.sharedBoard" +
                " FROM SharedBoardParticipation a WHERE a.userStatus = :owner" +
                " AND a.user = :user " +
                "AND a.sharedBoard.sharedBoardState <> :inactive", SharedBoard.class);
        query.setParameter("user", user);
        query.setParameter("owner", owner);
        query.setParameter("inactive", inactive);
        return query.getResultList();
    }
}
