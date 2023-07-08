package eapli.elearning.meetingmanagement.domain;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipationFactory;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.time.LocalDateTime;
import java.util.Set;

@DomainService
public class ScheduleMeetingService {
    MeetingRepository meetingRepo = PersistenceContext.repositories().meetings();
    MeetingParticipationRepository meetingParticipationRepo = PersistenceContext.repositories().meetingParticipations();
    public Meeting scheduleMeeting(Meeting meeting, Set<SystemUser> guests){
        for(SystemUser user : guests){
            MeetingParticipation meetingParticipation =  MeetingParticipationFactory
                    .createMeetingParticipation(user, meeting);
            meetingParticipationRepo.save(meetingParticipation);
        }
        return meeting;
    }
}
