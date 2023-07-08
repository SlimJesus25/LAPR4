package eapli.elearning.meetingmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

public class MeetingBuilder implements DomainFactory<Meeting> {
    private Meeting theMeeting;
    private MeetingDuration meetingDuration;
    private MeetingDateTime meetingDateTime;

    public MeetingBuilder withMeetingDuration(MeetingDuration meetingDuration) {
        this.meetingDuration = meetingDuration;
        return this;
    }
    public MeetingBuilder withMeetingDateTime(MeetingDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
        return this;
    }
    @Override
    public Meeting build() {
        final Meeting meeting = buildOrThrow();
        theMeeting = null;
        return meeting;
    }
    private Meeting buildOrThrow(){
        if (theMeeting != null)
            return theMeeting;
        else if (meetingDuration != null && meetingDateTime != null){
            //theMeeting = new Meeting(meetingDuration,meetingDateTime);
            return theMeeting;
        } else throw new IllegalStateException();
    }
}
