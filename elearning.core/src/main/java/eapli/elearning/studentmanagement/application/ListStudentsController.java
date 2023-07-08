package eapli.elearning.studentmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListStudentsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentRepository repo = PersistenceContext.repositories().students();
    public Iterable<Student> listStudents() {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR,ElearningRoles.TEACHER);
        return repo.findAllStudents();
    }
}
