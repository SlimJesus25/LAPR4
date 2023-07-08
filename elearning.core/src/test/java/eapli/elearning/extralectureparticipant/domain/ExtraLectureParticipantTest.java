package eapli.elearning.extralectureparticipant.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.extralecturemanagement.domain.*;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExtraLectureParticipantTest {
    ExtraLecture extraLecture;
    Student student;

    @BeforeEach
    public void setUp() {
        Teacher teacher = new Teacher("AMS", "21321312", LocalDate.of(1990, 12, 3), null);
        Course course = new Course("JAVA", "Java Collections Framework", "Java Collections Framework", CourseState.CLOSE, teacher);
        extraLecture = new ExtraLecture(ExtraLectureType.PL,
        new ExtraLectureInitialTime(LocalTime.of(12, 12)),
        new ExtraLectureFinalTime(LocalTime.of(14, 10)),
        new ExtraLectureDate(LocalDate.of(2023, 12, 12)), course, teacher);
        student = new Student("12345678", LocalDate.now(), null);
    }

    @Test
    public void ensureExtraLectureParticipantExtraLectureCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLectureParticipant(null, student));
    }
    @Test
    public void ensureExtraLectureParticipantStudentCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ExtraLectureParticipant(extraLecture, null));
    }
}
