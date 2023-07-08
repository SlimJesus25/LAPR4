package eapli.elearning.meetingparticipationmanagement.persistance;

import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface MeetingParticipationRepository extends DomainRepository<Integer, MeetingParticipation> {
    Iterable<Meeting> listFutureMeetingsByUser(SystemUser user);
    Iterable<MeetingParticipation> listUnansweredMeetingsByUser(SystemUser user);
    List<Meeting> listOwnedMeetingsByUser(SystemUser user);
    List<Meeting> listAllMeetingsByUser(SystemUser user);
    List<MeetingParticipation> listMeetingParticipants(Integer meetingID);
}
