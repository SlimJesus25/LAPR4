package eapli.elearning.extralecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class ExtraLecture implements AggregateRoot<Integer>, DTOable<ExtraLectureDTO> {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated (EnumType.STRING)
    private ExtraLectureType lectureType;

    @Embedded
    private ExtraLectureInitialTime timeInitial;
    @Embedded
    private ExtraLectureFinalTime timeFinal;
    @Embedded
    private ExtraLectureDate date;
    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    public ExtraLecture(ExtraLectureType lectureType, ExtraLectureInitialTime timeInitial, ExtraLectureFinalTime timeFinal, ExtraLectureDate date, Course course, Teacher teacher) {
        Preconditions.noneNull(lectureType, timeInitial, timeFinal, date, course, teacher);
        this.lectureType = lectureType;
        this.timeInitial = timeInitial;
        this.timeFinal = timeFinal;
        this.date = date;
        this.course = course;
        this.teacher = teacher;
    }

    public ExtraLectureInitialTime initialTime() {
        return timeInitial;
    }

    public ExtraLectureFinalTime finalTime() {
        return timeFinal;
    }

    public ExtraLectureDate date() {
        return date;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public ExtraLectureDTO toDTO() {
        return new ExtraLectureDTO(lectureType, date.date(),timeInitial.initialTime(),timeFinal.finalTime(), course.toDTO(), teacher.toDTO());
    }
    public ExtraLecture(){

    }

}
