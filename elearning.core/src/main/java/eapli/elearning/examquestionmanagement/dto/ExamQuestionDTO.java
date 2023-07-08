package eapli.elearning.examquestionmanagement.dto;

import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamQuestionDTO {
    private ExamQuestionType questionType;
    private ArrayList<String> questionSolution;
    private Integer questionValue;
    private HashMap<ExamQuestionResult,String> questionFeedback;
    private String questionStatement;
}
