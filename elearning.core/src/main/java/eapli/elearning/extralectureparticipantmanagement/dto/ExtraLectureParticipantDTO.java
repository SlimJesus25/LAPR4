package eapli.elearning.extralectureparticipantmanagement.dto;

import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DTO
@AllArgsConstructor
@NoArgsConstructor
public class ExtraLectureParticipantDTO {
    private ExtraLectureDTO extraLecture;
    private StudentDTO student;
}
