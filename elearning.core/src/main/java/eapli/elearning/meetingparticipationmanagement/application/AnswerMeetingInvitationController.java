package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.application.UseCaseController;

@UseCaseController
public interface AnswerMeetingInvitationController {
    public MeetingParticipationDTO acceptMeetingInvitation(MeetingParticipationDTO meeting);
    public MeetingParticipationDTO refuseMeetingInvitation(MeetingParticipationDTO meeting);
}
