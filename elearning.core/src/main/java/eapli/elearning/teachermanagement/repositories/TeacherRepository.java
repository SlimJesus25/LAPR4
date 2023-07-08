package eapli.elearning.teachermanagement.repositories;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface TeacherRepository extends DomainRepository<TeacherAcronym, Teacher>{

    Teacher findTeacherByUserName(Username username);

    Teacher findTeacherByAcronym(String acronym);

    Teacher regentOfCourse(Course course);

    Iterable<Teacher> listTeachers();
}
