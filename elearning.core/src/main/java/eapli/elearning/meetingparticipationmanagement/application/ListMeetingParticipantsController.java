package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.application.UseCaseController;

import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

@UseCaseController
public interface ListMeetingParticipantsController {
    List<MeetingParticipationDTO> listMeetingParticipants(Integer meetingID);
}
