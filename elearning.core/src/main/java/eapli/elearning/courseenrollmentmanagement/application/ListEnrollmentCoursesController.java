package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ListEnrollmentCoursesController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();

    public Iterable<CourseEnrollmentDTO> allCoursesWithApplications(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Iterable<CourseEnrollment> courses = repo.listCourseEnrollments();
        List<CourseEnrollmentDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }
}
