package eapli.elearning.teamelementmanagament.application;


import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.AdhesionDate;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.elearning.teamelementmanagament.domain.TeamElementFactory;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDate;

public class AddElementToTeamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamElementRepository repo = PersistenceContext.repositories().courseTeams();
    public TeamElement addElementToTeam(Course course, Teacher teacher, LocalDate adhesionDate){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);

        final TeamElement theTeamElement = TeamElementFactory.createTeamElement(course, teacher, adhesionDate);

        return repo.save(theTeamElement);
    }
}
