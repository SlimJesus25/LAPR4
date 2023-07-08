package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.meetingmanagement.application.ScheduleMeetingController;
import eapli.elearning.meetingmanagement.application.ScheduleMeetingControllerImpl;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingparticipationmanagement.application.AddParticipationToMeetingController;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class MeetingBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(LectureBootstrapper.class);

    private final ScheduleMeetingControllerImpl ctrl = new ScheduleMeetingControllerImpl();
    private final AddParticipationToMeetingController addParticipationController = new AddParticipationToMeetingController();
    @Override
    public boolean execute() {

        Set<SystemUser> participants = new HashSet<>();

        participants.add(getSystemUserByUsername("vasco"));
        participants.add(getSystemUserByUsername("vicenteT"));

        Meeting m = ctrl.scheduleMeeting("Gui Sauce's Meeting", LocalDateTime.of(LocalDate.of(
                2023, 10, 10), LocalTime.of(10, 0)), 60);

        addParticipationController.addParticipationOwnerToMeeting(m, getSystemUserByUsername("guisauce"));
        participants.forEach(e -> addParticipationController.addParticipationToMeeting(m, e));

        LOGGER.debug("»»» Demo Meetings created{}", id);
        return true;
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        return controller.getSystemUserByUsername(username);
    }
}
