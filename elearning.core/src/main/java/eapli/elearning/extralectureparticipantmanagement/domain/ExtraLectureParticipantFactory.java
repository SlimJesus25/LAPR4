package eapli.elearning.extralectureparticipantmanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;

import java.time.LocalDate;

public class ExtraLectureParticipantFactory {
    public static ExtraLectureParticipant createExtraLectureParticipant(ExtraLecture extraLecture, Student student){
        return new ExtraLectureParticipant(extraLecture, student);
    }
}
