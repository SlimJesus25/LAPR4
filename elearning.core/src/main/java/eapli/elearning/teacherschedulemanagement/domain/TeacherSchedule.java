package eapli.elearning.teacherschedulemanagement.domain;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teacherschedulemanagement.dto.TeacherScheduleDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TeacherSchedule")
public class TeacherSchedule implements AggregateRoot<Integer>, DTOable<TeacherScheduleDTO> {
    //n deveria ter um teacher associado?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherSchedule_id", nullable = false, length = 10)
    private Integer teacherScheduleID;
    @OneToMany
    private List<Lecture> lectures;
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        TeacherSchedule that = (TeacherSchedule) other;
        return Objects.equals(teacherScheduleID, that.teacherScheduleID);
    }

    public TeacherSchedule(List<Lecture> lectures) {
        this.teacherScheduleID = teacherScheduleID;
        this.lectures=lectures;
    }
    public TeacherSchedule(){}
    @Override
    public Integer identity() {
        return teacherScheduleID;
    }

    @Override
    public TeacherScheduleDTO toDTO() {
        return new TeacherScheduleDTO(teacherScheduleID);
    }

}
