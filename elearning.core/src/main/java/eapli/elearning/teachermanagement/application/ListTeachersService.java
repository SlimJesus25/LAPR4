package eapli.elearning.teachermanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class ListTeachersService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeacherRepository repo = PersistenceContext.repositories().teachers();
    public List<TeacherDTO> allTeachers(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER);
        Iterable<Teacher> teachers = repo.findAll();

        List<TeacherDTO> result = new ArrayList<>();
        teachers.forEach(a -> result.add(a.toDTO()));
        return result;
    }
}
