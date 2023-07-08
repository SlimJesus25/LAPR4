package eapli.elearning.meetingmanagement.persistance;

import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface MeetingRepository extends DomainRepository<Integer, Meeting> {
    Meeting findMeetingByID(Integer meetingID);
}
