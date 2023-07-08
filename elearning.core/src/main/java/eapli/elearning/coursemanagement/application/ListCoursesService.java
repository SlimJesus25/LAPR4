package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.application.StudentService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.application.TeacherService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class ListCoursesService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();
    private final StudentService stService = new StudentService();
    private final TeacherService tcService = new TeacherService();
    private final CourseService course = new CourseService();
    public Iterable<CourseDTO> allCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER,ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Iterable<Course> courses = repo.listAllCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }
    public Iterable<CourseDTO> teacherCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER,ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        //Teacher teacherLog = tcService.findTeacherByUserName(this.authz.session().get().authenticatedUser().username());
        Iterable<CourseDTO> result = course.teacherCourses(this.authz.session().get().authenticatedUser());
        return result;
    }

    public Iterable<CourseDTO> studentCourses(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.STUDENT,ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Student studentLog = stService.findStudentByUsername(this.authz.session().get().authenticatedUser().username());
        Iterable<CourseDTO> result = course.studentCourses(studentLog);
        return result;
    }
}
