package eapli.elearning.examquestionmanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.examquestionmanagement.domain.*;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;

import java.util.HashMap;
import java.util.List;

@ApplicationService
public class ExamQuestionService {
    final ExamQuestionRepository examQuestionRepo = PersistenceContext.repositories().examQuestions();

    public Iterable<ExamQuestion> listQuestions(){
        return examQuestionRepo.listQuestions();
    }

    public ExamQuestion addQuestion(ExamQuestionType questionType, List<String> solutions, Integer value,
                            HashMap<ExamQuestionResult,String> feedbacks, String statement){
        final ExamQuestion question = QuestionFactory.createQuestion(questionType, solutions, value, feedbacks,statement);
        return examQuestionRepo.save(question);
    }

    public Iterable<ExamQuestion> findQuestionByStatement(String statement){
        return examQuestionRepo.findQuestionByStatement(new ExamQuestionStatement(statement));
    }

    public ExamQuestion updateQuestion(String examQuestionS){
        //ExamQuestion examQuestion = new ExamQuestion();
        //examQuestionRepo.save(examQuestion);
        return null;
    }


}
