package eapli.elearning.courseenrollmentmanagement.domain;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.application.ListOpenEnrollmentCoursesService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@DomainService
public class ListOpenEnrollmentCoursesAvailableToEnrollStudentSessionService {
    Iterable<CourseDTO> openCoursesIterator= allOpenEnrollmentCourses();
    List<Course> openCourses= new ArrayList<>();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();
    private final CourseRepository courseRepo = PersistenceContext.repositories().courses();
    private final StudentRepository studentRepo = PersistenceContext.repositories().students();

    public List<CourseDTO> allOpenEnrollmentCoursesAvailableToEnrollStudentSessionService(AuthorizationService authz){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.STUDENT);
        Student student;
        if(authz.session().isPresent())
            student=findStudentByUsername(authz.session().get().authenticatedUser().identity());
        else return null;
        if(openCoursesIterator==null)
            return null;
        openCoursesIterator.forEach(a -> openCourses.add(findCourseByCourseCode(a.getCourseCode())));
        List<CourseDTO> coursesAvailable= new ArrayList<>();
        for (Course course : openCourses) {
            Iterable<Course> iterableCoursesStudentEnrolled=repo.checkIfStudentEnrolledInCourse(course,student);
            List<Course> coursesStudentEnrolled= new ArrayList<>();
            iterableCoursesStudentEnrolled.forEach(coursesStudentEnrolled::add);
           if(coursesStudentEnrolled.size()==0)
               coursesAvailable.add(course.toDTO());
        }
        return coursesAvailable.isEmpty() ? null : coursesAvailable;
    }
    public Iterable<CourseDTO> allOpenEnrollmentCourses(){
        try{
        Iterable<Course> courses = courseRepo.listAllOpenEnrollmentCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
        }catch (Exception e){
            return null;
        }
    }
    public Student findStudentByUsername(Username userName) {
        return studentRepo.findStudentByUserName(userName);
    }
    public Course findCourseByCourseCode(String courseCode){
        return courseRepo.findCourseByCode(courseCode);
    }
}
