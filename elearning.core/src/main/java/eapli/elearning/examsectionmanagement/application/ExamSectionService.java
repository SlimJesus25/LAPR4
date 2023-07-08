package eapli.elearning.examsectionmanagement.application;

import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.domain.ExamSectionTextualDescription;
import eapli.elearning.examsectionmanagement.domain.SectionFactory;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;

import java.util.Set;

@ApplicationService
public class ExamSectionService {
    final ExamSectionRepository examSectionRepo = PersistenceContext.repositories().examSections();

    public ExamSection createSection(String examSectionTextualDescription, Set<ExamQuestion> questions){
        return examSectionRepo.save(SectionFactory.createSection(examSectionTextualDescription, questions));
    }

    public Iterable<ExamSection> findSectionByDescription(String examSectionTextualDescription){
        return examSectionRepo.findSectionByDescription(new ExamSectionTextualDescription(examSectionTextualDescription));
    }
}
