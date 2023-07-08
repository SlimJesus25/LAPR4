package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ListMeetingParticipantsControllerImpl implements ListMeetingParticipantsController{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();
    @Override
    public List<MeetingParticipationDTO> listMeetingParticipants(Integer meetingID) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        List<MeetingParticipation> meetingParticipants = repo.listMeetingParticipants(meetingID);
        List<MeetingParticipationDTO> meetingParticipationDTO = new ArrayList<>();
        meetingParticipants.forEach(e -> meetingParticipationDTO.add(e.toDTO()));
        return meetingParticipationDTO;
    }
}
