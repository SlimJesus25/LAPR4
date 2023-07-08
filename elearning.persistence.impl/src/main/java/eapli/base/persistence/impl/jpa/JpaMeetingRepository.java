package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.meetingparticipationmanagement.domain.ParticipationState;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaMeetingRepository extends JpaAutoTxRepository<Meeting, Integer, Integer> implements MeetingRepository {
    public JpaMeetingRepository(final TransactionalContext autoTx) {
        super(autoTx, "meeting_id");
    }

    public JpaMeetingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "meeting_id");
    }
    @Override
    public Meeting findMeetingByID(Integer meetingID) {
        final TypedQuery<Meeting> query = entityManager().createQuery("SELECT a FROM Meeting a" +
                        " WHERE :meetingid = a.id"
                , Meeting.class);
        query.setParameter("meetingid", meetingID);
        return query.getSingleResult();
    }
}
