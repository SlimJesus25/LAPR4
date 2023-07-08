package eapli.elearning.courseenrollmentmanagement.dto;

import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@DTO
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrollmentDTO implements Serializable {
    private Integer id;
    private LocalDate enrollmentDate;
    private StudentEnrollmentState enrollmentState;
    private CourseDTO enrollmentCourse;
    private StudentDTO enrollmentStudent;

}
