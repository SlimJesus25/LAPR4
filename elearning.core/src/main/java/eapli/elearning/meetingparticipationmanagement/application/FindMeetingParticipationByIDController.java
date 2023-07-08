package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class FindMeetingParticipationByIDController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();

    public MeetingParticipation findMeetingParticipationByID(Integer id){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        return repo.ofIdentity(id).orElseThrow(IllegalArgumentException::new);
    }
}
