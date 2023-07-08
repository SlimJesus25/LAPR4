package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.teachermanagement.application.RegisterTeacherController;
import eapli.elearning.teachermanagement.domain.Teacher;
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
public class TeacherBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherBootstrapper.class);

    private final RegisterTeacherController controller = new RegisterTeacherController();
    @Override
    public boolean execute() {

        Teacher t1 = registerTeacher("ABCD", "100200300", LocalDate.of(1995, Month.JUNE, 1),getSystemUserByUsername("venancioT"));
        Teacher t2 = registerTeacher("DCBA", "300200100", LocalDate.of(1973, Month.JULY, 31),getSystemUserByUsername("krillinT"));
        Teacher t3 = registerTeacher("DDCC", "500200300", LocalDate.of(1995, Month.JUNE, 1),getSystemUserByUsername("vicenteT"));
        Teacher t4 = registerTeacher("CCDD", "300200500", LocalDate.of(1973, Month.JULY, 31),getSystemUserByUsername("gabrielT"));
        Teacher t5 = registerTeacher("ZZXX", "150250350", LocalDate.of(1973, Month.JULY, 31),getSystemUserByUsername("ricardoT"));
        LOGGER.debug("»»» Demo Teacher created{}", id);
        return true;
    }

    private Teacher registerTeacher(String acronym, String taxPayerNumber, LocalDate dateOfBirth, SystemUser user){
        Teacher teacher1 = controller.registerTeacher(acronym, taxPayerNumber, dateOfBirth, user);
        return teacher1;
    }
    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
