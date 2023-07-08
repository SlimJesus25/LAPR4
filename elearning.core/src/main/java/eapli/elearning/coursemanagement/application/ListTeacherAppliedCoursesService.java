package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@ApplicationService
public class ListTeacherAppliedCoursesService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamElementRepository repo = PersistenceContext.repositories().courseTeams();
    FindTeacherByUsernameService findTeacher= new FindTeacherByUsernameService();


    public Iterable<CourseDTO> listTeacherAppliedCourses(Optional<UserSession> user) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Teacher teacher;
        if(user.isPresent())
            teacher=findTeacher.findTeacherByUsername(user.get().authenticatedUser().identity());
        else return null;
        Iterable<Course> coursesOfTeacher=findCoursesOfTeacher(teacher);
        return StreamSupport.stream(coursesOfTeacher.spliterator(), false).map(Course::toDTO).collect(Collectors.toList());
    }

    private Iterable<Course> findCoursesOfTeacher(Teacher teacher) {
        return repo.findCoursesOfTeacher(teacher);
    }
}
