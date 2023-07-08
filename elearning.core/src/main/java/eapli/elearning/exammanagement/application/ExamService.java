package eapli.elearning.exammanagement.application;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamFactory;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DomainService
public class ExamService implements IExamService{
    private final ExamRepository repo = PersistenceContext.repositories().exams();
    public Iterable<ExamDTO> listUserExams(SystemUser user) {
        Iterable<Exam> exams = repo.listAllExamsOfCoursesOfStudent(user);
        List<ExamDTO> result = new ArrayList<>();
        exams.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Iterable<ExamDTO> listExams(CourseCode courseCode){
        Iterable<Exam> exams = repo.listAllExamsOfCourseByCode(courseCode);
        List<ExamDTO> result = new ArrayList<>();
        exams.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Exam createExam(String title, String header, Set<ExamSection> sections, Course course, ExamType type, LocalDateTime initalDateTime, LocalDateTime finalDateTime){
        return repo.save(ExamFactory.createExam(title, header, sections, course, type, initalDateTime, finalDateTime));
    }

    public Iterable<Exam> findExamByTitle(String title){
        return  repo.ExistExamsSameTitle(title);
    }

}
