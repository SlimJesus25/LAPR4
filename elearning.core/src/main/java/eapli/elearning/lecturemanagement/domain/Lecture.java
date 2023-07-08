package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Lecture")
public class Lecture implements AggregateRoot<Integer>, DTOable<LectureDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lectureID;
    @Embedded
    private LectureInitialTime lectureInitialTime;
    @Embedded
    private LectureFinalTime lectureFinalTime;
    @Embedded
    private LectureInitialDate lectureInitialDate;
    @Embedded
    private LectureFinalDate lectureFinalDate;
    @Enumerated(EnumType.STRING)
    private LectureWeekDay lectureWeekDay;
    @Enumerated(EnumType.STRING)
    private LectureType lectureType;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Course course;

    @Override
    public LectureDTO toDTO() {
        return new LectureDTO(lectureID, lectureInitialTime,lectureFinalTime,lectureInitialDate,lectureFinalDate,
                lectureWeekDay,lectureType, teacher.toDTO(), course.toDTO());
    }

    public Lecture(LectureInitialTime lectureInitialTime, LectureFinalTime lectureFinalTime,
                   LectureInitialDate lectureInitialDate, LectureFinalDate lectureFinalDate,
                   LectureWeekDay lectureWeekDay, LectureType lectureType, Teacher teacher, Course course) {
        Preconditions.noneNull(lectureWeekDay,lectureType,teacher,course,lectureInitialTime,lectureFinalTime,lectureInitialDate,lectureFinalDate);
        this.lectureInitialTime = lectureInitialTime;
        this.lectureFinalTime = lectureFinalTime;
        validateTimes();
        this.lectureInitialDate = lectureInitialDate;
        this.lectureFinalDate = lectureFinalDate;
        validateDates();
        this.lectureWeekDay = lectureWeekDay;
        this.lectureType = lectureType;
        this.teacher = teacher;
        this.course = course;
    }

    private void validateDates() {
        if(!lectureInitialDate.initialDate().isBefore(lectureFinalDate.finalDate())){
            throw new IllegalArgumentException("The initial date must be before the final date");
        }
    }

    public void validateTimes(){
        if(!lectureInitialTime.initialTime().isBefore(lectureFinalTime.finalTime())){
            throw new IllegalArgumentException("The initial time must be before the final time");
        }
    }
    public LectureInitialTime initialTime() {
        return lectureInitialTime;
    }

    public LectureFinalTime finalTime() {
        return lectureFinalTime;
    }

    public LectureInitialDate initialDate() {
        return lectureInitialDate;
    }

    public LectureFinalDate finalDate() {
        return lectureFinalDate;
    }

    public LectureWeekDay weekDay() {
        return lectureWeekDay;
    }

    protected Lecture(){}
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Lecture that = (Lecture) other;
        return Objects.equals(lectureID, that.lectureID);
    }
    @Override
    public Integer identity() {
        return lectureID;
    }

    public void updateLecture(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, Teacher teacher, Course course) {
        this.lectureInitialDate = updatedInitialDate;
        this.lectureFinalDate = updatedFinalDate;
        this.lectureWeekDay = updatedWeekDay;
        this.lectureInitialTime = updatedInitialTime;
        this.lectureFinalTime = updatedFinalTime;
        this.lectureType = updatedLectureType;
        this.teacher = teacher;
        this.course = course;
    }
}
