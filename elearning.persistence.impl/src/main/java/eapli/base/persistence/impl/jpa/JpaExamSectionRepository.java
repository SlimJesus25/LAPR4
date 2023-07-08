package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionStatement;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.examsectionmanagement.domain.ExamSectionTextualDescription;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaExamSectionRepository extends JpaAutoTxRepository<ExamSection, Integer, Integer> implements ExamSectionRepository {
    public JpaExamSectionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExamSectionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<ExamSection> findSectionByDescription(ExamSectionTextualDescription examSectionTextualDescription){
        final TypedQuery<ExamSection> query = entityManager().createQuery("SELECT s FROM ExamSection s WHERE s.sectionDescription" +
                " =:discription", ExamSection.class);
        query.setParameter("discription", examSectionTextualDescription);
        return query.getResultList();
    }
}
