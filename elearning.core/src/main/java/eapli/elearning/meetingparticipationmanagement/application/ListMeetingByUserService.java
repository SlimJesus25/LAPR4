package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class ListMeetingByUserService{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();

    public List<MeetingParticipationDTO> listUnansweredMeetingsByUser() {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        SystemUser user = authz.session().get().authenticatedUser();
        List<MeetingParticipationDTO> meetingParticipationsDTOS = new ArrayList<>();
        repo.listUnansweredMeetingsByUser(user).forEach(e -> meetingParticipationsDTOS.add(e.toDTO()));
        return meetingParticipationsDTOS;
    }
}
