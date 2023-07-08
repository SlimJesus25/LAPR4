package eapli.elearning.teamelementmanagament.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.dto.TeamElementDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="TeamElement")
public class TeamElement implements AggregateRoot<Integer>, DTOable<TeamElementDTO> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private AdhesionDate adhesionDate;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    public TeamElement(LocalDate adhesionDate, Course course, Teacher teacher) {
        Preconditions.noneNull(adhesionDate, course, teacher);
        this.adhesionDate = new AdhesionDate(adhesionDate);
        this.course = course;
        this.teacher = teacher;
    }

    protected TeamElement() {
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
    public TeamElementDTO toDTO() {
        return new TeamElementDTO(adhesionDate.adhesionDate(), course.toDTO(), teacher.toDTO());
    }

    public AdhesionDate adhesionDate() {
        return adhesionDate;
    }
}
