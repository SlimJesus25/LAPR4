package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.elearning.formerexammanagement.domain.FormerExamID;
import eapli.elearning.formerexammanagement.persistence.FormerExamRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaFormerExamRepository extends JpaAutoTxRepository<FormerExam, FormerExamID, FormerExamID> implements FormerExamRepository {
    public JpaFormerExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "formerexam_id");
    }

    public JpaFormerExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "formerexam_id");
    }

    @Override
    public Iterable<FormerExam> listFormerExamsByCourse(String courseCode) {
        TypedQuery<FormerExam> query = entityManager().
                createQuery("SELECT fe FROM FormerExam fe " +
                                "WHERE upper(fe.formerExamID.exam.course.courseCode) = upper(:course)",
                        FormerExam.class);
        query.setParameter("course", courseCode);
        return query.getResultList();
    }

    @Override
    public Iterable<FormerExam> listAllGrades(List<CourseCode> coursesCode) {
        TypedQuery<FormerExam> query = entityManager().
                createQuery("SELECT fe FROM FormerExam fe " +
                                "WHERE upper(fe.formerExamID.exam.course.courseCode) IN (:courseCodes)",
                        FormerExam.class);
        query.setParameter("courseCodes", coursesCode);
        return query.getResultList();
    }
}
