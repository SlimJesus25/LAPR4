package eapli.elearning.exammanagement.dto;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO implements Serializable {
    private Integer examID;
    private String examTitle;
    private String examHeader;
    private Set<ExamSectionDTO> examSection;
    private CourseDTO course;
    private LocalDateTime initialDateTime;
    private LocalDateTime finalDateTime;
    public String toString(){
        return (examTitle + " - " + examHeader);
    }
}
