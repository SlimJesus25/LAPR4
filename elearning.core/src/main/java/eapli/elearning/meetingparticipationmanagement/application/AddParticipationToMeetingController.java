package eapli.elearning.meetingparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipation;
import eapli.elearning.meetingparticipationmanagement.domain.MeetingParticipationFactory;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class AddParticipationToMeetingController {
    private final MeetingParticipationRepository repo = PersistenceContext.repositories().meetingParticipations();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public MeetingParticipationDTO addParticipationToMeeting(Meeting meeting, SystemUser user){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        if(authz.session().get().authenticatedUser().equals(user)){
            return addParticipationOwnerToMeeting(meeting, user);
        }
        MeetingParticipation theMeetingParticipation
                =  MeetingParticipationFactory.createMeetingParticipation(user, meeting);
        return repo.save(theMeetingParticipation).toDTO();
    }

    public MeetingParticipationDTO addParticipationOwnerToMeeting(Meeting meeting, SystemUser user){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        MeetingParticipation theMeetingParticipation
                =  MeetingParticipationFactory.createMeetingParticipation(user, meeting);
        theMeetingParticipation.giveMeetingOwnerShip();
        return repo.save(theMeetingParticipation).toDTO();
    }

}
