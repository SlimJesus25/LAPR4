package eapli.elearning.studentmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Embeddable
public class StudentMechanographicalNumber implements ValueObject, Comparable<StudentMechanographicalNumber> {

    private String mechanographicalNumber;
    private static final Integer MECANOGRAPHIC_NUMBER_LENGTH = 5;

    public StudentMechanographicalNumber(Integer year) {
        Preconditions.noneNull(year);
        generateMechanographicalNumber(year);
    }

    private void generateMechanographicalNumber(Integer year){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(year);

        for(int i=0;i<MECANOGRAPHIC_NUMBER_LENGTH;i++){
            sb.append(random.nextInt(9));
        }
        mechanographicalNumber = sb.toString();
    }

    protected StudentMechanographicalNumber() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentMechanographicalNumber that = (StudentMechanographicalNumber) o;
        return Objects.equals(mechanographicalNumber, that.mechanographicalNumber);
    }

    public String studentMechanograpicalNumber() {
        return mechanographicalNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechanographicalNumber);
    }

    @Override
    public String toString() {
        return mechanographicalNumber;
    }

    @Override
    public int compareTo(StudentMechanographicalNumber studentMechanographicalNumber) {
        return this.studentMechanograpicalNumber().compareTo(studentMechanographicalNumber.mechanographicalNumber);
    }
}
