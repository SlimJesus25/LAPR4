package eapli.elearning.meetingmanagement.application;

import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.GeneralDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface ScheduleMeetingController {
    public Map<SystemUser, Boolean> checkUsersAvailability(LocalDateTime meetingDateNTime,
                                                    Integer meetingDuration, List<SystemUser> guests);
    public Meeting scheduleMeeting(String meetingName, LocalDateTime meetingDateNTime,
                                   Integer meetingDuration);
}
