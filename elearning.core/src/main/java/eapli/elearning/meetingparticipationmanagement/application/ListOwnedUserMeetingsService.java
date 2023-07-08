package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

@ApplicationService
public class ListOwnedUserMeetingsService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();

    public List<MeetingDTO> listOwnedUserMeetings(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        Iterable<Meeting> userMeetings = repo.listOwnedMeetingsByUser(authz.session().get().authenticatedUser());
        List<MeetingDTO> userMeetingsDTO = new ArrayList<>();
        userMeetings.forEach(e -> userMeetingsDTO.add(e.toDTO()));
        return userMeetingsDTO;
    }

}
