package eapli.elearning.lecturemanagement.application;

import eapli.elearning.extralecturemanagement.domain.ExtraLectureDate;
import eapli.elearning.extralecturemanagement.domain.ExtraLectureFinalTime;
import eapli.elearning.extralecturemanagement.domain.ExtraLectureInitialTime;
import eapli.elearning.meetingmanagement.domain.CheckAvailabilityService;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@ApplicationService
public class CheckMeetingCollisionService {
    private final CheckAvailabilityService checkAvailabilityService= new CheckAvailabilityService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public boolean checkLectureAvailability(LocalTime initialTime, LocalTime finalTime, LocalDate initialDate, LocalDate finalDate, String weekDay, SystemUser teacher) {
        return checkAvailabilityService.checkLectureAvailability(initialTime, finalTime, initialDate, finalDate, weekDay, teacher);
    }
    public boolean checkLectureAvailability(ExtraLectureInitialTime startHours, ExtraLectureFinalTime endHours, ExtraLectureDate date, DayOfWeek dayOfWeek) {
        return checkAvailabilityService.checkLectureAvailability(startHours.initialTime(), endHours.finalTime(), date.date(), date.date(), dayOfWeek.name(), authz.session().get().authenticatedUser());
    }
}
