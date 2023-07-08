package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
public class AnswerMeetingInvitationControllerImpl implements AnswerMeetingInvitationController{

    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();
    private final FindMeetingParticipationByIDController ctrl = new FindMeetingParticipationByIDController();
    @Override
    public MeetingParticipationDTO acceptMeetingInvitation(MeetingParticipationDTO meeting) {
        MeetingParticipation meetingParticipation = findMeetingParticipationByID(meeting);
        meetingParticipation.acceptMeetingRequest();
        return repo.save(meetingParticipation).toDTO();
    }

    @Override
    public MeetingParticipationDTO refuseMeetingInvitation(MeetingParticipationDTO meeting) {
        MeetingParticipation meetingParticipation =findMeetingParticipationByID(meeting);
        meetingParticipation.rejectMeetingRequest();
        return repo.save(meetingParticipation).toDTO();
    }

    private MeetingParticipation findMeetingParticipationByID(MeetingParticipationDTO meeting){
        return ctrl.findMeetingParticipationByID(meeting.getId());
    }
}
