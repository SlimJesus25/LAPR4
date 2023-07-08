package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.ListOpenEnrollmentCoursesAvailableToEnrollStudentSessionService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.util.List;
import java.util.Optional;

@ApplicationService
public class OpenEnrollmentCoursesAvailableToEnrollStudentSessionService {
    private final ListOpenEnrollmentCoursesAvailableToEnrollStudentSessionService listOpenEnrollmentCoursesService = new ListOpenEnrollmentCoursesAvailableToEnrollStudentSessionService();
    public List<CourseDTO> allOpenEnrollmentCoursesAvailableToEnrollStudentSessionService(AuthorizationService authz){
        return listOpenEnrollmentCoursesService.allOpenEnrollmentCoursesAvailableToEnrollStudentSessionService(authz);
    }
}
