package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.courseenrollmentmanagement.application.CreateCourseEnrollmentController;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentDate;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.application.CreateCourseController;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.studentmanagement.application.CreateStudentController;
import eapli.elearning.studentmanagement.application.FindStudentByMechanographicalNumberService;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseEnrollmentBootstrapper implements Action {
    private final CreateCourseEnrollmentController controller = new CreateCourseEnrollmentController();
    private final CreateCourseController courseController = new CreateCourseController();
    private final CreateStudentController studentController = new CreateStudentController();
    @Override
    public boolean execute(){
        Student s1= findStudentByUsername("guisauce");
        Student s2= findStudentByUsername("vasco");
        Course c1= findCourseByCourseCode("SEM02-JAVA");
        Course c2= findCourseByCourseCode("SEM02-PYTHON");
        CourseEnrollment ce1 = createCourseEnrollment(c1, s1, new CourseEnrollmentDate(LocalDate.of(2023, Month.JANUARY, 14)),
                StudentEnrollmentState.ENROLLED);
        CourseEnrollment ce2 = createCourseEnrollment(c1, s2, new CourseEnrollmentDate(LocalDate.of(2023, Month.JANUARY, 14)),
                StudentEnrollmentState.CANDIDATE);
        CourseEnrollment ce3 = createCourseEnrollment(c2, s2, new CourseEnrollmentDate(LocalDate.of(2023, Month.MAY, 5)),
                StudentEnrollmentState.CANDIDATE);
        return true;
    }

    private Course findCourseByCourseCode(String courseCode) {
        FindCourseByCourseCodeService controller = new FindCourseByCourseCodeService();
        return controller.findCourseByCourseCode(courseCode);
    }

    private Student findStudentByMechanographicalNumber(String mechaNumber) {
        FindStudentByMechanographicalNumberService controller = new FindStudentByMechanographicalNumberService();
        return controller.findStudentByMechanographicalNumber(mechaNumber);
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }

    private Student findStudentByUsername(String username) {
        SystemUser user = getSystemUserByUsername(username);
        FindStudentByUsernameService controller = new FindStudentByUsernameService();
        return controller.findStudentByUsername(user.username());
    }

    private CourseEnrollment createCourseEnrollment(Course course, Student student, CourseEnrollmentDate date, StudentEnrollmentState state) {
        CourseEnrollment ce;
        ce = controller.createCourseEnrollment(course, student, date, state);
        return ce;
    }
}
