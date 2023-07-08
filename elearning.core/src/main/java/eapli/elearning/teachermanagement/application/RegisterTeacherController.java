package eapli.elearning.teachermanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.domain.StudentBuilder;
import eapli.elearning.teachermanagement.domain.*;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class RegisterTeacherController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeacherRepository repo = PersistenceContext.repositories().teachers();

    public Teacher createTeacher(TeacherAcronym teacherAcronym, TeacherTaxPayerNumber taxPayerNumber,
                                 TeacherDateOfBirth dateOfBirth, SystemUser systemUser){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
//        final Teacher newTeacher = new TeacherBuilder()
//                .withTeacherAcronym(teacherAcronym)
//                .withTeacherTaxPayerNumber(taxPayerNumber)
//                .withTeacherDateOfBirth(dateOfBirth)
//                .withTeacherSystemUser(systemUser)
//                .build();
//        return repo.save(newTeacher);
        return null;
    }

    //Depois de se alterar no bootstrap este metodo pode ser apagado
    public Teacher registerTeacher(String acronym, String taxPayerNumber, LocalDate dateOfBirth, SystemUser systemUser){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        Teacher t = new Teacher(acronym, taxPayerNumber, dateOfBirth,systemUser);
        return repo.save(t);
    }


}
