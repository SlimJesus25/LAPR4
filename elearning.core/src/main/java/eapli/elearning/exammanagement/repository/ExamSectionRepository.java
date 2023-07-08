package eapli.elearning.exammanagement.repository;

import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.domain.ExamSectionTextualDescription;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface ExamSectionRepository extends DomainRepository<Integer, ExamSection> {
    Iterable<ExamSection> findSectionByDescription(ExamSectionTextualDescription examSectionTextualDescription);
}
