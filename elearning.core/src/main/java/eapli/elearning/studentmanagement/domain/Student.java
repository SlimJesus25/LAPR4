package eapli.elearning.studentmanagement.domain;

import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name="Student")
public class Student implements AggregateRoot<StudentMechanographicalNumber>, DTOable<StudentDTO> {
    @Column(name="mecanographicalNumber", nullable=false)
    @EmbeddedId
    private StudentMechanographicalNumber mechanographicalNumber;
    @Column(name="taxPayerNumber", nullable=false)
    @Embedded
    private StudentTaxPayerNumber taxPayerNumber;
    @Column(name="dateOfBirth", nullable=false)
    @Embedded
    private StudentDateOfBirth dateOfBirth;
    @OneToOne()
    private SystemUser systemUser;
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Student that = (Student) other;
        return Objects.equals(mechanographicalNumber, that.mechanographicalNumber);
    }

    public Student(String taxPayerNumber, LocalDate dateOfBirth, SystemUser systemUser) {
        this.mechanographicalNumber = new StudentMechanographicalNumber(LocalDate.now().getYear());
        this.taxPayerNumber = new StudentTaxPayerNumber(taxPayerNumber);
        this.dateOfBirth = new StudentDateOfBirth(dateOfBirth);
        this.systemUser = systemUser;
    }

    public Student(){}
    @Override
    public StudentMechanographicalNumber identity() {
        return mechanographicalNumber;
    }

    @Override
    public StudentDTO toDTO() {
        return new StudentDTO(mechanographicalNumber, taxPayerNumber, dateOfBirth, systemUser);
    }
    public void requestEnrollmentCourse(){

    }
    public void viewFutureExams() {

    }
}
