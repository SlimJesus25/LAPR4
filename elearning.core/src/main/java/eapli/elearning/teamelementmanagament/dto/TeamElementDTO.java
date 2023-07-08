package eapli.elearning.teamelementmanagament.dto;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DTO
public class TeamElementDTO implements Serializable {
    private LocalDate adhesionDate;
    private CourseDTO courseDTO;
    private TeacherDTO teacherDTO;
}