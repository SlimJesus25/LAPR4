package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentBuilder;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentDate;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.infrastructure.persistence.PersistenceContext;

import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class CourseEnrollmentService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();
    public CourseEnrollment createCourseEnrollment(Course course, Student student,
                                                   CourseEnrollmentDate courseEnrollmentDate,
                                                   StudentEnrollmentState studentEnrollmentState){

        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT);

        final CourseEnrollment newCourseEnrollment = new CourseEnrollmentBuilder()
                .withCourseEnrollmentDate(courseEnrollmentDate.date())
                .withCourseEnrollmentState(studentEnrollmentState)
                .withCourse(course)
                .withStudent(student)
                .build();


        return repo.save(newCourseEnrollment);
    }
}
