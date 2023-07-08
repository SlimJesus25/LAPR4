package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamTitle;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="FormerExam")
public class FormerExam implements AggregateRoot<FormerExamID>, DTOable<FormerExamDTO> {

    @EmbeddedId
    @Column(name = "formerExam_id", nullable = false, length = 10)
    private FormerExamID formerExamID;
    @Column(name="grade", nullable=false)
    @Embedded
    private FormerExamGrade formerExamGrade;

    public FormerExam(Student student, Exam exam, Integer formerExamGrade) {
        Preconditions.noneNull(student, exam, formerExamGrade);
        validateGrade(formerExamGrade);
        this.formerExamID = new FormerExamID(student,exam);
        this.formerExamGrade = new FormerExamGrade(formerExamGrade);
    }

    private void validateGrade(Integer formerExamGrade) {
        if(formerExamGrade < 0 || formerExamGrade > 20){
            throw new IllegalArgumentException("The former exam grade must be between 0 and 20!");
        }
    }

    public FormerExam(){}

    public FormerExamDTO toDTO() {
        return new FormerExamDTO(formerExamGrade.grade(), formerExamID.student().toDTO(), formerExamID.exam().toDTO());
    }
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        FormerExam that = (FormerExam) other;
        return Objects.equals(formerExamID, that.formerExamID);
    }
    @Override
    public FormerExamID identity() {return formerExamID;}
}
