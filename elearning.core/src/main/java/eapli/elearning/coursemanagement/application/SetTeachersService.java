package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.elearning.teamelementmanagament.domain.TeamElementFactory;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@ApplicationService
public class SetTeachersService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamElementRepository teamElementRepo = PersistenceContext.repositories().courseTeams();

    public Course setTeachers(Course course, Set<Teacher> teachers) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        for(Teacher teacher : teachers) {
            TeamElement teamElement = TeamElementFactory.createTeamElement(course, teacher, LocalDate.now());
            teamElementRepo.save(teamElement);
        }
        return course;
    }
}
