package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.teachermanagement.domain.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class LectureTest {
    LectureInitialTime initialTime;
    LectureFinalTime finalTime;
    LectureInitialDate initialDate;
    LectureFinalDate finalDate;
    LectureWeekDay weekDay;
    LectureType type;
    private Teacher teacher;
    private Course course;

    @BeforeEach
    void setUp() {
        initialTime = new LectureInitialTime(LocalTime.of(9, 0));
        finalTime = new LectureFinalTime(LocalTime.of(11, 0));
        initialDate = new LectureInitialDate(LocalDate.of(2023,12,12));
        finalDate = new LectureFinalDate(LocalDate.of(2024,12,12));
        weekDay = LectureWeekDay.Monday;
        type = LectureType.T;
        teacher = new Teacher("AMS", "21321312", LocalDate.of(1990,12, 3), null);
        course = new Course("JAVA", "Java Collections Framework", "Java Collections Framework", CourseState.CLOSE, teacher);
    }
    @Test
    public void ensureLectureTypeCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, initialDate, finalDate, weekDay, null,teacher, course));
    }
    @Test
    public void ensureLectureWeekDayCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, initialDate, finalDate, null, type,teacher, course));
    }
    @Test
    public void ensureLectureInitialTimeCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(null, finalTime, initialDate, finalDate, weekDay, type,teacher, course));
    }
    @Test
    public void ensureLectureFinalTimeCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, null, initialDate, finalDate, weekDay, type,teacher, course));
    }
    @Test
    public void ensureLectureInitialDateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, null, finalDate, weekDay, type,teacher, course));
    }
    @Test
    public void ensureLectureFinalDateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, initialDate, null, weekDay, type,teacher, course));
    }
    @Test
    public void ensureLectureTeacherCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, initialDate, finalDate, weekDay, type,null, course));
    }
    @Test
    public void ensureLectureCourseCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, initialDate, finalDate, weekDay, type,teacher, null));
    }
    @Test
    public void ensureLectureInitialTimeCantBeAfterFinalTime(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(new LectureInitialTime(finalTime.finalTime()), new LectureFinalTime(initialTime.initialTime()), initialDate, finalDate, weekDay, type,teacher, course));
    }
    @Test
    public void ensureLectureInitialDateCantBeAfterFinalDate(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Lecture(initialTime, finalTime, new LectureInitialDate(finalDate.finalDate()), new LectureFinalDate(initialDate.initialDate()), weekDay, type,teacher, course));
    }
}
