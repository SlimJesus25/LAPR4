package eapli.elearning.studentmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.*;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.time.LocalDate;

public class CreateStudentController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentRepository repo = PersistenceContext.repositories().students();
    public Student createStudent(String taxPayerNumber, LocalDate dateOfBirth, SystemUser user){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        Student theStudent = StudentFactory.createStudent(taxPayerNumber, dateOfBirth, user);
        return repo.save(theStudent);
    }

}
