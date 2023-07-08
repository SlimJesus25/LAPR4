package eapli.elearning.examquestionmanagement.domain;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class QuestionFactory {
    public static ExamQuestion createQuestion(ExamQuestionType questionType, List<String> solutions, Integer value,
                                              HashMap<ExamQuestionResult,String> feedbacks, String statement){
        return new ExamQuestion(questionType, solutions, value, feedbacks, statement);
    }
}
