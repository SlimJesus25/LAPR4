package eapli.elearning.meetingparticipationmanagement.domain;

import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class MeetingParticipationFactory {
    public static MeetingParticipation createMeetingParticipation(SystemUser user, Meeting meeting){
        return new MeetingParticipation(user, meeting);
    }
}
