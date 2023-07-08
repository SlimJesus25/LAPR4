package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.exammanagement.domain.ExamHeader;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FormerExamGrade implements ValueObject {
    private Integer grade;

    public FormerExamGrade(Integer grade) {
        Preconditions.noneNull(grade);
        this.grade = grade;
    }

    public FormerExamGrade() {
    }
    public Integer grade() {
        return grade;
    }
    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormerExamGrade that = (FormerExamGrade) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade);
    }

    @Override
    public String toString() {
        return "FormerExamGrade{" +
                "formerExamGrade='" + grade + '\'' +
                '}';
    }
}
