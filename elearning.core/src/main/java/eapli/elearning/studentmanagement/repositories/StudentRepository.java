package eapli.elearning.studentmanagement.repositories;

import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface StudentRepository extends DomainRepository<StudentMechanographicalNumber, Student> {
    public Student findStudentByMechanographicalNumber(String mechanographicalNumber);
    public Student findStudentByUserName(Username username);

    Iterable<Student> findAllStudents();
}
