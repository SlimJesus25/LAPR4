package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.application.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class GetSumExamQuestionValuesService {
    public Float getSumExamQuestionValues(List<ExamQuestionDTO> questions) {
        Float sum=0f;
        for(ExamQuestionDTO question: questions){
            sum+=question.getQuestionValue();
        }
        return sum;
    }
    public Float getSumExamQuestionValues(ExamDTO exam) {
        Float sum=0f;
        for(ExamSectionDTO section: exam.getExamSection()){
            for(ExamQuestionDTO question: section.getQuestions()){
                sum+=question.getQuestionValue();
            }
        }
        return sum;
    }

    public Integer getGradeInScale(Float finalGrade, Float sum) {
        Float percentualGrade = (finalGrade/sum)*20;
        return Math.round(percentualGrade);
    }
}
