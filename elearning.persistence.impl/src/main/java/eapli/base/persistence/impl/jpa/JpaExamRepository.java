package eapli.base.persistence.impl.jpa;


import eapli.elearning.Application;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaExamRepository extends JpaAutoTxRepository<Exam, Integer, Integer> implements ExamRepository {

    public JpaExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Exam> listAllExamsOfCourseByCode(CourseCode code) {
        //final TypedQuery<Course> query = entityManager().createQuery("SELECT c FROM Course c WHERE c.courseCode=:code", Course.class);
        final TypedQuery<Exam> query = entityManager().createQuery("SELECT e FROM Exam e JOIN Course c ON " +
                "c.courseCode=e.course.courseCode AND e.course.courseCode=:code", Exam.class);
        query.setParameter("code", code);
        return query.getResultList();
    }
    @Override
    public Iterable<Exam> listAllExamsOfCourseByCodeAndType(CourseCode code, ExamType examType) {
        final TypedQuery<Exam> query = entityManager().createQuery("SELECT e FROM Exam e JOIN Course c ON " +
                "c.courseCode = e.course.courseCode WHERE c.courseCode = :code AND e.examType = :examType", Exam.class);
        query.setParameter("code", code);
        query.setParameter("examType", examType);
        return query.getResultList();
    }
    @Override
    public Iterable<Exam> listAllExamsOfCoursesOfStudent(SystemUser user) {
        final TypedQuery<Exam> query = entityManager().createQuery("SELECT e FROM CourseEnrollment c  INNER JOIN Exam" +
                " e ON e.course = c.courseEnrollmentCourse AND c.courseEnrollmentStudent.systemUser = :user AND " +
                "c.studentEnrollmentState = :ENROLLED ", Exam.class);
        query.setParameter("ENROLLED", StudentEnrollmentState.ENROLLED);
        query.setParameter("user",user);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    public Iterable<FormerExam> listFormerExamsOfCourse(CourseDTO course){
        CourseCode codeC = new CourseCode(course.getCourseCode());
        //SELECT fe FROM FormerExam fe JOIN fe.formerExamID.exam e WHERE e.course = :code
        //SELECT fe FROM FormerExam fe JOIN Exam e ON fe.formerExamID.exam.course=:code
        final TypedQuery<FormerExam> query = entityManager().createQuery("SELECT fe FROM FormerExam fe WHERE fe.formerExamID.exam.course.courseCode=:code", FormerExam.class);
        query.setParameter("code", codeC);
        return query.getResultList();
    }

    public Iterable<FormerExam> listAllFormerExams(){
        final TypedQuery<FormerExam> query = entityManager().createQuery("SELECT fe FROM FormerExam fe", FormerExam.class);
        return query.getResultList();
    }

    @Override
    public List<Exam> findExamByTitle(String title) {
        final TypedQuery<Exam> query = entityManager().createQuery("SELECT a FROM Exam a WHERE upper(a.examTitle)" +
                " = upper(:title)", Exam.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public Iterable<Exam> ExistExamsSameTitle(String title) {
        final TypedQuery<Exam> query = entityManager().createQuery("SELECT a FROM Exam a WHERE upper(a.examTitle)" +
                " = upper(:title)", Exam.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
