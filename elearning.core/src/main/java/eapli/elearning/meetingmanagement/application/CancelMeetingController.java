package eapli.elearning.meetingmanagement.application;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.framework.application.UseCaseController;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public interface CancelMeetingController {
    MeetingDTO cancelMeeting(Integer meetingID);
}
