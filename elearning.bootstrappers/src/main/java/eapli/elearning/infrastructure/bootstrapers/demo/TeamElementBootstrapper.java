package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.application.AddElementToTeamController;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class TeamElementBootstrapper implements Action {

    AddElementToTeamController ctrl = new AddElementToTeamController();
    @Override
    public boolean execute() {
        Teacher t1 = new Teacher("DDCC", "500200300", LocalDate.of(1995, Month.JUNE,
                1),getSystemUserByUsername("vicenteT"));
        Teacher t2 = new Teacher("DCBA", "300200100", LocalDate.of(1973, Month.JULY,
                31),getSystemUserByUsername("krillinT"));
        Course c1 = new Course("SEM02-JAVA", "JAVA", "Java Collections Framework2",
                CourseState.CLOSE, t1);

        ctrl.addElementToTeam(c1, t1, LocalDate.now());
        ctrl.addElementToTeam(c1, t2, LocalDate.now());
        return true;
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
