package eapli.elearning.studentmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class StudentTaxPayerNumber implements ValueObject {

    private String taxPayerNumber;

    public StudentTaxPayerNumber(String taxPayerNumber) {
        Preconditions.noneNull(taxPayerNumber);
        verifyTaxPayerNumber(taxPayerNumber);
        this.taxPayerNumber = taxPayerNumber;
    }

    public StudentTaxPayerNumber() {
    }

    private void verifyTaxPayerNumber(String taxPayerNumber){
        if(taxPayerNumber.isEmpty()){
            throw new IllegalArgumentException("Tax payer number cannot be empty!");
        }
    }

    public String taxPayerNumber() {
        return taxPayerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentTaxPayerNumber that = (StudentTaxPayerNumber) o;
        return Objects.equals(taxPayerNumber, that.taxPayerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxPayerNumber);
    }

    @Override
    public String toString() {
        return "StudentTaxPayerNumber{" +
                "studentTaxPayerNumber='" + taxPayerNumber + '\'' +
                '}';
    }
}
