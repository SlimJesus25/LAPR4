package eapli.elearning.studentmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
@ApplicationService
public class FindStudentByMechanographicalNumberService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentRepository repo = PersistenceContext.repositories().students();
    public Student findStudentByMechanographicalNumber(String mechaNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.TEACHER);
        return repo.findStudentByMechanographicalNumber(mechaNumber);
    }
}
