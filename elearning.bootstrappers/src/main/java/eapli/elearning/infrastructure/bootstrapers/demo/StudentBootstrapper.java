package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.studentmanagement.application.CreateStudentController;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.Month;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class StudentBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentBootstrapper.class);

    private final CreateStudentController controller = new CreateStudentController();
    @Override
    public boolean execute() {



        Student s1 = createStudent("200300400"
                , LocalDate.of(2002, Month.JUNE, 17), getSystemUserByUsername("guisauce"));

        Student s2 = createStudent("201303401"
                , LocalDate.of(2003, Month.AUGUST, 7), getSystemUserByUsername("vasco"));

        LOGGER.debug("»»» Demo Students created{}", id);

        return true;

    }

    private Student createStudent(String taxPayerNumber, LocalDate dateOfBirth, SystemUser user){
        return controller.createStudent(taxPayerNumber, dateOfBirth, user);
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }

}
