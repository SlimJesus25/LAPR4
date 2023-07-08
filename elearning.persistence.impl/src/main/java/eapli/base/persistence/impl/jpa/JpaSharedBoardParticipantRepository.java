package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.domain.SharedBoardState;
import eapli.elearning.sharedboardparticipationmanagement.domain.SharedBoardParticipation;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserStatus;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaSharedBoardParticipantRepository extends JpaAutoTxRepository<SharedBoardParticipation, Integer, Integer>
        implements SharedBoardParticipationRepository {
    public JpaSharedBoardParticipantRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaSharedBoardParticipantRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public boolean isUserOwnerOfSharedBoard(SharedBoard sharedBoard, String username) {
        UserStatus owner = UserStatus.OWNER;
        final TypedQuery<SharedBoard> query = entityManager().createQuery("SELECT a.sharedBoard FROM SharedBoardParticipation a" +
                        " WHERE upper(a.user.username.value) = upper(:user) " +
                        "AND a.userStatus = :owner " +
                        "AND a.sharedBoard = :sharedBoard"
                , SharedBoard.class);
        query.setParameter("user", username);
        query.setParameter("owner", owner);
        query.setParameter("sharedBoard", sharedBoard);

        return !query.getResultList().isEmpty();
    }

    @Override
    public SharedBoard findSharedBoarByTitle(String boardTitle) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery("SELECT a FROM SharedBoard a WHERE upper(a.sharedBoardTitle)" +
                " = upper(:boardTitle)", SharedBoard.class);
        query.setParameter("boardTitle", boardTitle);
        return query.getSingleResult();
    }

    @Override
    public List<SharedBoard> listWritableSharedBoards(SystemUser user) {
        UserStatus guest = UserStatus.GUEST;
        UserPermission read = UserPermission.READ;
        SharedBoardState active = SharedBoardState.ACTIVE;

        final TypedQuery<SharedBoard> query = entityManager().createQuery("SELECT a.sharedBoard " +
                        "FROM SharedBoardParticipation a " +
                        "WHERE a.user = :user " +
                        "AND a.userStatus <> :guest " +
                        "AND a.userPermission <> :read " +
                        "AND a.sharedBoard.sharedBoardState = :active"
                , SharedBoard.class);

        query.setParameter("user", user);
        query.setParameter("guest", guest);
        query.setParameter("read", read);
        query.setParameter("active", active);

        return query.getResultList();
    }
}
