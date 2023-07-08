package eapli.elearning.formerexammanagement.persistence;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.elearning.formerexammanagement.domain.FormerExamID;

import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface FormerExamRepository  extends DomainRepository<FormerExamID, FormerExam> {
    public Iterable<FormerExam> listFormerExamsByCourse(String courseCode);

    public Iterable<FormerExam> listAllGrades(List<CourseCode> coursesCodes);
}
