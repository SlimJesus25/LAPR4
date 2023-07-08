package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.elearning.formerexammanagement.persistence.FormerExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.services.DomainService;

import java.util.ArrayList;
import java.util.List;

@DomainService
public class FormerExamService {
    private final FormerExamRepository repo = PersistenceContext.repositories().formerExams();
    public Iterable<FormerExamDTO> listExamsGrades(CourseDTO course){
        Iterable<FormerExam> exams = repo.listFormerExamsByCourse(course.getCourseCode());
        List<FormerExamDTO> result = new ArrayList<>();
        exams.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Iterable<FormerExamDTO> listAllGrades(Iterable<CourseDTO> courses){
        List<CourseCode> courseCodes = new ArrayList<>();

        for (CourseDTO course : courses) {
            CourseCode courseCode = new CourseCode(course.getCourseCode());
            courseCodes.add(courseCode);
        }

        Iterable<FormerExam> exams = repo.listAllGrades(courseCodes);
        List<FormerExamDTO> result = new ArrayList<>();
        exams.forEach(a -> result.add(a.toDTO()));
        return result;
    }
}
