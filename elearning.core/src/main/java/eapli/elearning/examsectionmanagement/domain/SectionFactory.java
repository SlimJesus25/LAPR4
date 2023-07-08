package eapli.elearning.examsectionmanagement.domain;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examsectionmanagement.domain.ExamSection;

import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SectionFactory {
    public static ExamSection createSection(String examSectionTextualDescription, Set<ExamQuestion> questions){
        return new ExamSection(examSectionTextualDescription, questions);
    }
}
