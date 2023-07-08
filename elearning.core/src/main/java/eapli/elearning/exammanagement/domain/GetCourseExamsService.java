package eapli.elearning.exammanagement.domain;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DomainService
public class GetCourseExamsService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentRepository studentRepo = PersistenceContext.repositories().students();
    private final CourseEnrollmentRepository courseEnrollmentRepository = PersistenceContext.repositories().courseEnrollments();
    private final ExamRepository repo = PersistenceContext.repositories().exams();
    public List<ExamDTO> getCoursesExams(){
        Student student= getStudent();
        List<Course> studentCourses= getStudentCourses(student);
        List<ExamDTO> getCoursesExams= getCoursesExams(studentCourses);
        return studentToDoExams(getCoursesExams);
    }
    private List<Course> getStudentCourses(Student student) {
        return StreamSupport.stream(courseEnrollmentRepository.coursesThatStudentIsEnrolledOn
                        (student.identity().toString()).spliterator(), false)
                .collect(Collectors.toList());
    }
    private List<ExamDTO> getCoursesExams(List<Course> studentCourses) {
        List<ExamDTO> coursesExamsAndCourses = new ArrayList<>();
        for(Course course: studentCourses){
            coursesExamsAndCourses.addAll(getCourseExams(course,ExamType.NORMAL));
        }
        return coursesExamsAndCourses;
    }
    private List<ExamDTO> getCourseExams(Course course, ExamType examType) {
        Iterable<Exam> exams = repo.listAllExamsOfCourseByCodeAndType(course.identity(), examType);
        return StreamSupport.stream(exams.spliterator(), false)
                .map(Exam::toDTO)
                .collect(Collectors.toList());
    }
    private List<ExamDTO> studentToDoExams(List<ExamDTO> getCoursesExams) {
        List<ExamDTO> studentToDoExams = new ArrayList<>();
        for(ExamDTO examDTO : getCoursesExams){
            if(examDTO.getInitialDateTime().isBefore(LocalDateTime.now()) && examDTO.getFinalDateTime().isAfter(LocalDateTime.now())){
                studentToDoExams.add(examDTO);
            }
        }
        return studentToDoExams;
    }
    private Student getStudent() {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.STUDENT);
        return studentRepo.findStudentByUserName(authz.session().get().authenticatedUser().username());
    }

    public List<ExamDTO> getCoursesFormativeExams() {
        Student student= getStudent();
        List<Course> studentCourses= getStudentCourses(student);
        List<ExamDTO> getCoursesFormativeExams= getCoursesFormativeExams(studentCourses);
        return getCoursesFormativeExams;
    }

    private List<ExamDTO> getCoursesFormativeExams(List<Course> studentCourses) {
        List<ExamDTO> coursesExamsAndCourses = new ArrayList<>();
        for(Course course: studentCourses){
            coursesExamsAndCourses.addAll(getCourseExams(course,ExamType.FORMATIVE));
        }
        return coursesExamsAndCourses;
    }
}
