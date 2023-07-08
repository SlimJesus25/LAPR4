package eapli.elearning.meetingmanagement.domain;

import java.time.LocalDateTime;

public class MeetingFactory {
    public static Meeting createMeeting(String meetingName, LocalDateTime meetingDateNTime, Integer meetingDuration){
        return new Meeting(meetingDuration, meetingDateNTime, meetingName);
    }
}