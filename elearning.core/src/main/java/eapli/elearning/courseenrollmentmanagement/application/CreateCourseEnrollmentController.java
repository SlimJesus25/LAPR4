package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.*;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.application.ListOpenEnrollmentCoursesService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@UseCaseController
public class CreateCourseEnrollmentController {
    FindStudentByUsernameService findStudentByUsernameService = new FindStudentByUsernameService();
    FindCourseByCourseCodeService findCourseByCourseCodeService = new FindCourseByCourseCodeService();
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

//        newCourseEnrollment.updateCourse(course);
//        newCourseEnrollment.updateStudent(student);

        return repo.save(newCourseEnrollment);
    }

    public CourseEnrollment createCourseEnrollment(CourseDTO selectedCourse, Optional<UserSession> session, StudentEnrollmentState studentEnrollmentState) {
        Student student = findStudentByUsernameService.findStudentByUsername(session.get().authenticatedUser().identity());
        Course course= findCourseByCourseCodeService.findCourseByCourseCode(selectedCourse.getCourseCode());
        createCourseEnrollment(course,student,new CourseEnrollmentDate(LocalDate.now()),studentEnrollmentState);
        return null;
    }

}
