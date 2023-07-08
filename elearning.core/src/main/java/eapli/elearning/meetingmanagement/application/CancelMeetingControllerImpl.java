package eapli.elearning.meetingmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CancelMeetingControllerImpl implements CancelMeetingController{

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingRepository repo = PersistenceContext.repositories().meetings();
    @Override
    public MeetingDTO cancelMeeting(Integer meetingID) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        Meeting m = repo.findMeetingByID(meetingID);
        m.cancelMeeting();
        return repo.save(m).toDTO();
    }
}

