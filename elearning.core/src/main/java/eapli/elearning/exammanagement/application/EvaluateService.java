package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.domain.EvaluateExamService;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.application.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class EvaluateService {
    EvaluateExamService evaluateExamService = new EvaluateExamService();
    public List<Float> evaluateExam(String examAnswers, ArrayList<ExamQuestionDTO> questions){
        return evaluateExamService.evaluateExam(examAnswers,questions);
    }
}
