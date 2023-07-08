package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class LectureBuilder implements DomainFactory<Lecture> {
    private Lecture theLecture;
    private LectureInitialTime lectureInitialTime;
    private LectureFinalTime lectureFinalTime;
    private LectureInitialDate lectureInitialDate;
    private LectureFinalDate lectureFinalDate;
    private LectureWeekDay lectureWeekDay;
    private LectureType lectureType;
    private Course course;
    private Teacher teacher;

    public LectureBuilder withLectureInitalTime(LocalTime lectureInitalTime) {
        this.lectureInitialTime = new LectureInitialTime(lectureInitalTime);
        return this;
    }
    public LectureBuilder withLectureFinalTime(LocalTime lectureFinalTime) {
        this.lectureFinalTime = new LectureFinalTime(lectureFinalTime);
        return this;
    }
    public LectureBuilder withLectureInitalDate(LocalDate lectureInitialDate) {
        this.lectureInitialDate = new LectureInitialDate(lectureInitialDate);
        return this;
    }
    public LectureBuilder withLectureFinalDate(LocalDate lectureFinalDate) {
        this.lectureFinalDate = new LectureFinalDate(lectureFinalDate);
        return this;
    }
    public LectureBuilder withLectureWeekDay(LectureWeekDay lectureWeekDay) {
        this.lectureWeekDay = lectureWeekDay;
        return this;
    }
    public LectureBuilder withLectureTeacher(LectureType lectureType) {
        this.lectureType = lectureType;
        return this;
    }
    public LectureBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }
    public LectureBuilder withLectureTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public Lecture build() {
        final Lecture lecture = buildOrThrow();
        theLecture = null;
        return lecture;
    }
    private Lecture buildOrThrow(){
        if (theLecture != null)
            return theLecture;
        else if (lectureInitialTime != null && lectureFinalTime != null && lectureInitialDate != null
                && lectureFinalDate != null && lectureWeekDay != null && lectureType != null){
            theLecture = new Lecture(lectureInitialTime,lectureFinalTime,lectureInitialDate
             ,lectureFinalDate,lectureWeekDay,lectureType, teacher, course);
            return theLecture;
        } else throw new IllegalStateException();
    }
}
