package eapli.elearning.teachermanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.domain.model.Username;

@ApplicationService
public class TeacherService {
    private final TeacherRepository repo = PersistenceContext.repositories().teachers();
    public Teacher findTeacherByUserName(Username username){
        return repo.findTeacherByUserName(username);
    }
}
