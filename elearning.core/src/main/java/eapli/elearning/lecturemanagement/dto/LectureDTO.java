package eapli.elearning.lecturemanagement.dto;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@DTO
@AllArgsConstructor
public class LectureDTO implements Serializable {
    private Integer lectureID;
    private LectureInitialTime lectureInitialTime;
    private LectureFinalTime lectureFinalTime;
    private LectureInitialDate lectureInitialDate;
    private LectureFinalDate lectureFinalDate;
    private LectureWeekDay lectureWeekDay;
    private LectureType lectureType;
    private TeacherDTO teacher;
    private CourseDTO course;
}