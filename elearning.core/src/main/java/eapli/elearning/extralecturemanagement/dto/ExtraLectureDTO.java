package eapli.elearning.extralecturemanagement.dto;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.extralecturemanagement.domain.ExtraLectureType;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@DTO
@AllArgsConstructor
@NoArgsConstructor
public class ExtraLectureDTO {
    private ExtraLectureType type;
    private LocalDate date;
    private LocalTime timeInitial;
    private LocalTime timeFinal;
    private CourseDTO course;
    private TeacherDTO teacher;
}
