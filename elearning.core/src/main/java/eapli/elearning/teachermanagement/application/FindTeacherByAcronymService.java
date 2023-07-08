package eapli.elearning.teachermanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class FindTeacherByAcronymService {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final TeacherRepository repo = PersistenceContext.repositories().teachers();
    public Teacher findTeacherByAcronym(String acronym) {
        auth.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        return repo.findTeacherByAcronym(acronym);
    }
}
