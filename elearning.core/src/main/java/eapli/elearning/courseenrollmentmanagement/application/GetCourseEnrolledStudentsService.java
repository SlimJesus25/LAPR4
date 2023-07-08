package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
@ApplicationService
public class GetCourseEnrolledStudentsService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();

    public Iterable<Student> getCourseEnrolledStudents(CourseDTO course){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Iterable<Student> students = repo.listStudentsEnrolledInCourse(course.getCourseCode());
        List<Student> result = new ArrayList<>();
        students.forEach(result::add);
        return result;
    }
}
