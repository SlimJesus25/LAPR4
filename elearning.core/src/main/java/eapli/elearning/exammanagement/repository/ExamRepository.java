package eapli.elearning.exammanagement.repository;

import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface ExamRepository extends DomainRepository<Integer, Exam> {
    public Iterable<Exam> listAllExamsOfCourseByCodeAndType(CourseCode code, ExamType examType);
    public Iterable<Exam> listAllExamsOfCourseByCode(CourseCode code);

    public Iterable<Exam> listAllExamsOfCoursesOfStudent(SystemUser user);

    public Iterable<FormerExam> listFormerExamsOfCourse(CourseDTO course);

    public Iterable<FormerExam> listAllFormerExams();
    public List<Exam> findExamByTitle(String title);

    public Iterable<Exam> ExistExamsSameTitle(String title);
}
