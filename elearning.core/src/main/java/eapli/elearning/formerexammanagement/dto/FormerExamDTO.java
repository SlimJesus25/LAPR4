package eapli.elearning.formerexammanagement.dto;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.formerexammanagement.domain.FormerExamGrade;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@DTO
@AllArgsConstructor
public class FormerExamDTO implements Serializable {
    private Integer formerExamGrade;
    private StudentDTO student;
    private ExamDTO exam;
    // formerExamSections
}
