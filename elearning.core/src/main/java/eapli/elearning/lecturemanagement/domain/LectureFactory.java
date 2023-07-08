package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;

import java.time.LocalDate;
import java.time.LocalTime;

public class LectureFactory {
    public static Lecture createLecture(LectureInitialTime lectureInitialTime, LectureFinalTime lectureFinalTime,
                                        LectureInitialDate lectureInitialDate
            , LectureFinalDate lectureFinalDate, LectureWeekDay lectureWeekDay, LectureType lectureType, Teacher teacher,
                                        Course course) {
        return new Lecture(lectureInitialTime, lectureFinalTime, lectureInitialDate, lectureFinalDate, lectureWeekDay, lectureType, teacher, course);
    }
}
