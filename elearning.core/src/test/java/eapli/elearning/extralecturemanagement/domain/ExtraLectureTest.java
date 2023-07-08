package eapli.elearning.extralecturemanagement.domain;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.teachermanagement.domain.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

public class ExtraLectureTest {
    ExtraLectureType lectureType;
    ExtraLectureInitialTime timeInitial;
    ExtraLectureFinalTime timeFinal;
    ExtraLectureDate date;
    Course course;
    Teacher teacher;

    @BeforeEach
    void setUp() {
        lectureType = ExtraLectureType.T;
        timeInitial = new ExtraLectureInitialTime(LocalTime.of(12, 12));
        timeFinal = new ExtraLectureFinalTime(LocalTime.of(14, 14));
        date = new ExtraLectureDate(LocalDate.of(2021, 12, 12));
        teacher = new Teacher("AMS", "21321312", LocalDate.of(1990,12, 3), null);
        course = new Course("JAVA", "Java Collections Framework", "Java Collections Framework", CourseState.CLOSE, teacher);
    }

    @Test
    public void ensureExtraLectureLectureTypeCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(null, timeInitial, timeFinal, date, course, teacher));
    }
    @Test
    public void ensureExtraLectureTimeInitialCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(lectureType, null, timeFinal, date, course, teacher));
    }
    @Test
    public void ensureExtraLectureTimeFinalCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(lectureType, timeInitial, null, date, course, teacher));
    }
    @Test
    public void ensureExtraLectureDateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(lectureType, timeInitial, timeFinal, null, course, teacher));
    }
    @Test
    public void ensureExtraLectureCourseCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(lectureType, timeInitial, timeFinal, date, null, teacher));
    }
    @Test
    public void ensureExtraLectureTeacherCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLecture(lectureType, timeInitial, timeFinal, date, course, null));
    }
}
