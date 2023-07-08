package eapli.elearning.teachermanagement.domain;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Entity
@Table(name="Teacher")
public class Teacher implements AggregateRoot<TeacherAcronym>, DTOable<TeacherDTO> {

    @EmbeddedId
    @Column(name="Acronym", nullable=false)
    private TeacherAcronym teacherAcronym;
    @Column(name="taxPayerNumber", nullable=false)
    @Embedded
    private TeacherTaxPayerNumber taxPayerNumber;
    @Column(name="dateOfBirth", nullable=false)
    @Embedded
    private TeacherDateOfBirth dateOfBirth;
    @OneToOne()
    private SystemUser systemUser;

    public Teacher(String teacherAcronym, String taxPayerNumber, LocalDate dateOfBirth, SystemUser systemUser) {
        this.teacherAcronym = new TeacherAcronym(teacherAcronym);
        this.taxPayerNumber = new TeacherTaxPayerNumber(taxPayerNumber);
        this.dateOfBirth = new TeacherDateOfBirth(dateOfBirth);
        this.systemUser = systemUser;
    }

    public Teacher() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Teacher that = (Teacher) other;
        return Objects.equals(teacherAcronym, that.teacherAcronym);
    }

    @Override
    public TeacherAcronym identity() {
        return teacherAcronym;
    }

    @Override
    public TeacherDTO toDTO() {
        return new TeacherDTO(teacherAcronym.acronym(), taxPayerNumber.taxPayerNumber(),dateOfBirth.dateOfBirth(),systemUser.toDTO());
    }

    public void scheduleClass(){

    }
    public void scheduleExtraClass(){

    }
    public void updateClassSchedule(){

    }
    public void updateExam(){

    }
    public void createExam(){

    }
    public void addAutoExamQuestion(){

    }
    public void updateAutoExamQuestion(){

    }
    public void createAutoExam(){

    }
    public void updateAutoExam(){

    }
    public void listAllExamsOfCourse(){

    }
}
