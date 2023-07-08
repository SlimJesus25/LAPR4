package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionStatement;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaExamQuestionRepository extends JpaAutoTxRepository<ExamQuestion, Integer, Integer>
        implements ExamQuestionRepository {
    public JpaExamQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExamQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    // TODO: Ver forma de retornar apenas do course especificado!
    @Override
    public List<ExamQuestion> listQuestionsByTypeAndCourse(Course course, Set<ExamQuestionType> questionTypes) {
//        final TypedQuery<ExamQuestion> query = entityManager().createQuery("SELECT e.examSection FROM Exam e " +
//                        "JOIN e.examSection s " +
//                        "WHERE e.course = :course " +
//                        "AND s.questions IN :validTypes"
//                , ExamQuestion.class);
        final TypedQuery<ExamQuestion> query = entityManager().createQuery("SELECT a FROM ExamQuestion a " +
                        "WHERE a.questionType IN :validTypes"
                , ExamQuestion.class);
        query.setParameter("validTypes", questionTypes);
        return query.getResultList();
    }

    public Iterable<ExamQuestion> findQuestionByStatement(ExamQuestionStatement statement){
        final TypedQuery<ExamQuestion> query = entityManager().createQuery("SELECT q FROM ExamQuestion q WHERE upper(q.statement)" +
                " = upper(:statement)", ExamQuestion.class);
        query.setParameter("statement", statement);
        return query.getResultList();
    }

    @Override
    public Iterable<ExamQuestion> listQuestions() {
        final TypedQuery<ExamQuestion> query = entityManager().createQuery("SELECT q FROM ExamQuestion q", ExamQuestion.class);
        return query.getResultList();
    }


}
