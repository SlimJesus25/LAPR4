package eapli.elearning.extralecturemanagement.domain;


import eapli.elearning.coursemanagement.domain.Course;

import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class ExtraLectureBuilder implements DomainFactory<ExtraLecture> {
    private ExtraLecture theExtraLecture;
    private ExtraLectureInitialTime extraLectureInitialTime;
    private ExtraLectureFinalTime extraLectureFinalTime;
    private ExtraLectureDate extraLectureDate;
    private ExtraLectureType extraLectureType;
    private Course course;
    private Teacher teacher;

    public ExtraLectureBuilder withExtraLectureInitialTime(LocalTime extraLectureInitialTime) {
        this.extraLectureInitialTime = new ExtraLectureInitialTime(extraLectureInitialTime);
        return this;
    }

    public ExtraLectureBuilder withExtraLectureFinalTime(LocalTime extraLectureFinalTime) {
        this.extraLectureFinalTime = new ExtraLectureFinalTime(extraLectureFinalTime);
        return this;
    }

    public ExtraLectureBuilder withExtraLectureDate(LocalDate extraLectureDate) {
        this.extraLectureDate = new ExtraLectureDate(extraLectureDate);
        return this;
    }

    public ExtraLectureBuilder withExtraLectureType(ExtraLectureType extraLectureType) {
        this.extraLectureType = extraLectureType;
        return this;
    }

    public ExtraLectureBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }

    public ExtraLectureBuilder withExtraLectureTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
    @Override
    public ExtraLecture build() {
        final ExtraLecture extraLecture = buildOrThrow();
        theExtraLecture = null;
        return extraLecture;
    }

    private ExtraLecture buildOrThrow() {
        if (theExtraLecture != null)
            return theExtraLecture;
        else if (extraLectureInitialTime != null && extraLectureFinalTime != null && extraLectureDate != null
                && extraLectureType != null) {
            theExtraLecture = new ExtraLecture(extraLectureType, extraLectureInitialTime, extraLectureFinalTime, extraLectureDate, course, teacher);
            return theExtraLecture;
        } else throw new IllegalStateException();
    }
}