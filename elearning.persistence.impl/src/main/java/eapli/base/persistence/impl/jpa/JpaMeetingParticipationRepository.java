package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingmanagement.domain.MeetingState;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.domain.ParticipationState;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMeetingParticipationRepository extends JpaAutoTxRepository<MeetingParticipation, Integer, Integer>
        implements MeetingParticipationRepository {

    public JpaMeetingParticipationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaMeetingParticipationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Meeting> listFutureMeetingsByUser(SystemUser user) {
        ParticipationState accepted = ParticipationState.ACCEPTED;
        ParticipationState owned = ParticipationState.OWNER;
        //ParticipationState refused = ParticipationState.REFUSED;
        MeetingState state = MeetingState.SCHEDULED;
        final TypedQuery<Meeting> query = entityManager().createQuery("SELECT a.meeting FROM MeetingParticipation a"
                + " WHERE :username = a.user AND a.state = :accepted "
                //+ "OR a.state = :refused "
                + "OR a.state = :owned "
                + "AND a.meeting.meetingState = :state "
                + "AND a.meeting.meetingDateTime.dateTime >= :actualDateTime", Meeting.class);
        query.setParameter("username", user);
        query.setParameter("accepted", accepted);
        //query.setParameter("refused", refused);
        query.setParameter("owned", owned);
        query.setParameter("state", state);
        query.setParameter("actualDateTime", LocalDateTime.now());
        return query.getResultList();
    }

    @Override
    public List<Meeting> listAllMeetingsByUser(SystemUser user) {
        ParticipationState accepted = ParticipationState.ACCEPTED;
        ParticipationState owned = ParticipationState.OWNER;
        MeetingState state = MeetingState.SCHEDULED;
        final TypedQuery<Meeting> query = entityManager().createQuery("SELECT a.meeting FROM MeetingParticipation a"
                + " WHERE :username = a.user "
                + "AND (a.state = :accepted "
                + "OR a.state = :owned) "
                + "AND a.meeting.meetingState = :state", Meeting.class);
        query.setParameter("username", user);
        query.setParameter("accepted", accepted);
        query.setParameter("owned", owned);
        query.setParameter("state", state);
        return query.getResultList();
    }

    @Override
    public Iterable<MeetingParticipation> listUnansweredMeetingsByUser(SystemUser user) {
        ParticipationState noAnswer = ParticipationState.NO_ANSWER;
        MeetingState state = MeetingState.SCHEDULED;
        final TypedQuery<MeetingParticipation> query = entityManager().createQuery("SELECT a FROM MeetingParticipation a"
                + " WHERE :user = a.user AND a.state = :noAnswer"
                + " AND a.meeting.meetingState = :state"
                , MeetingParticipation.class);
        query.setParameter("user", user);
        query.setParameter("noAnswer", noAnswer);
        query.setParameter("state", state);
        return query.getResultList();
    }

    @Override
    public List<Meeting> listOwnedMeetingsByUser(SystemUser user) {
        ParticipationState owner = ParticipationState.OWNER;
        MeetingState state = MeetingState.SCHEDULED;
        final TypedQuery<Meeting> query = entityManager().createQuery("SELECT a.meeting FROM MeetingParticipation a"
                        + " WHERE a.user = :user AND a.state = :owner"
                        + " AND a.meeting.meetingState = :state"
                , Meeting.class);
        query.setParameter("user", user);
        query.setParameter("owner", owner);
        query.setParameter("state", state);
        return query.getResultList();
    }

    @Override
    public List<MeetingParticipation> listMeetingParticipants(Integer meetingID) {
        final TypedQuery<MeetingParticipation> query = entityManager().createQuery("SELECT a FROM MeetingParticipation a" +
                        " WHERE a.meeting.id = :meetingID"
                , MeetingParticipation.class);
        query.setParameter("meetingID", meetingID);
        return query.getResultList();
    }
}
