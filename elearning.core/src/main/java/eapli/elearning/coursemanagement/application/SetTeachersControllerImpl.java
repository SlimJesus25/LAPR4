package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.application.ListTeachersService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UseCaseController
public class SetTeachersControllerImpl implements SetTeachersController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepo = PersistenceContext.repositories().courses();

    private final TeacherRepository teacherRepo = PersistenceContext.repositories().teachers();
    private final SetTeachersService service = new SetTeachersService();

    private final ListCoursesService listCoursesservice = new ListCoursesService();

    private final ListTeachersService listTeachersService = new ListTeachersService();

    @Override
    public CourseDTO setTeachersTo(String courseCode, Set<TeacherDTO> teachers) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR,ElearningRoles.POWER_USER);
        Set<Teacher> teachersList = new HashSet<>();
        Course theCourse = courseRepo.findCourseByCode(courseCode);

        for (TeacherDTO t : teachers) {
            teachersList.add(teacherRepo.findTeacherByAcronym(t.getAcronym()));
        }

        service.setTeachers(theCourse, teachersList);
        return theCourse.toDTO();
    }
    public Iterable<CourseDTO> listCourses(){
       return listCoursesservice.allCourses();
    }

    public List<TeacherDTO> listTeachers(){
        return listTeachersService.allTeachers();
    }
}
