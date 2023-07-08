package eapli.elearning.myelearninguser.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class GetSystemUserByUsernameController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SystemUserRepository repo = PersistenceContext.repositories().systemUsers();
    public SystemUser getSystemUserByUsername(String username) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        return repo.findSystemUserByUsername(username);
    }
}
