package eapli.elearning.studentmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
@ApplicationService
public class FindStudentByUsernameService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentRepository repo = PersistenceContext.repositories().students();
    public Student findStudentByUsername(Username userName) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT);
        return repo.findStudentByUserName(userName);
    }
}
