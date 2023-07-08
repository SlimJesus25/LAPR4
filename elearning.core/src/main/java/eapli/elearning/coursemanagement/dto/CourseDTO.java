package eapli.elearning.coursemanagement.dto;

import eapli.elearning.coursemanagement.domain.*;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO implements Serializable {

    private String courseTitle;
    private String courseCode;
    private String courseDescription;
    private CourseState courseState;
    //private Set<TeacherDTO> teachers;
    private TeacherDTO teacher;
    public String identity() {
        return this.courseCode;
    }

}
