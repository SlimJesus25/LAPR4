package eapli.elearning.examsectionmanagement.dto;

import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSectionDTO {
    private String description;
    private Set<ExamQuestionDTO> questions;
}
