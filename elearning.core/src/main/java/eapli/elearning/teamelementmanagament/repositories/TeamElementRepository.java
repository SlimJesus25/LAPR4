package eapli.elearning.teamelementmanagament.repositories;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamElementRepository extends DomainRepository<Integer, TeamElement> {
    Iterable<Course> findCoursesOfTeacher(Teacher teacher);
}