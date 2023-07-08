package eapli.elearning.studentmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.domain.model.Username;


@ApplicationService
public class StudentService {
    private final StudentRepository repo = PersistenceContext.repositories().students();

    public Student findStudentByMechanographicalNumber(String mechaNumber) {
        return repo.findStudentByMechanographicalNumber(mechaNumber);
    }

    public Student findStudentByUsername(Username user){
        return  repo.findStudentByUserName(user);
    }
}
