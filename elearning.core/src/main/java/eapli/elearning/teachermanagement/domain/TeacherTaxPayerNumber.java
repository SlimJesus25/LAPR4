package eapli.elearning.teachermanagement.domain;

import eapli.elearning.studentmanagement.domain.StudentTaxPayerNumber;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class TeacherTaxPayerNumber implements ValueObject {
    private String taxPayerNumber;

    public TeacherTaxPayerNumber(String taxPayerNumber) {
        Preconditions.noneNull(taxPayerNumber);
        verifyTeacherTaxPayerNumber(taxPayerNumber);
        this.taxPayerNumber = taxPayerNumber;
    }

    private void verifyTeacherTaxPayerNumber(String taxPayerNumber){
        if(taxPayerNumber.isEmpty()){
            throw new IllegalArgumentException("Tax payer number cannot be null!");
        }
    }

    public String taxPayerNumber() {
        return taxPayerNumber;
    }

    public TeacherTaxPayerNumber() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TeacherTaxPayerNumber that = (TeacherTaxPayerNumber) o;
        return Objects.equals(taxPayerNumber, that.taxPayerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxPayerNumber);
    }

    @Override
    public String toString() {
        return "TeacherTaxPayerNumber{" +
                "teacherTaxPayerNumber='" + taxPayerNumber + '\'' +
                '}';
    }
}
