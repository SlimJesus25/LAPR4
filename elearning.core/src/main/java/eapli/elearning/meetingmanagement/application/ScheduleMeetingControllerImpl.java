package eapli.elearning.meetingmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.domain.*;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UseCaseController
public class ScheduleMeetingControllerImpl implements ScheduleMeetingController{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MeetingRepository repo = PersistenceContext.repositories().meetings();
    private final CheckAvailabilityService checkAvailabilityService = new CheckAvailabilityService();
    private final ScheduleMeetingService scheduleMeetingService = new ScheduleMeetingService();
    public Map<SystemUser, Boolean> checkUsersAvailability(LocalDateTime meetingDateNTime,
                                   Integer meetingDuration, List<SystemUser> guests){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        guests.add(authz.session().get().authenticatedUser());
        return checkAvailabilityService.checkAvailability(meetingDateNTime, guests, meetingDuration);
    }

    @Override
    public Meeting scheduleMeeting(String meetingName, LocalDateTime meetingDateNTime, Integer meetingDuration) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        Meeting meeting = MeetingFactory.createMeeting(meetingName, meetingDateNTime, meetingDuration);
        return repo.save(meeting);
    }
}