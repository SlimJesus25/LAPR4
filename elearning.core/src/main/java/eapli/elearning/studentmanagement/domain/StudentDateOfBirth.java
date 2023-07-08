package eapli.elearning.studentmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class StudentDateOfBirth implements ValueObject {

    private LocalDate dateOfBirth;

    public StudentDateOfBirth(LocalDate dateOfBirth) {
        Preconditions.noneNull(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public StudentDateOfBirth() {
    }

    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDateOfBirth that = (StudentDateOfBirth) o;
        return Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth);
    }

    @Override
    public String toString() {
        return "StudentDateOfBirth{" +
                "studentDateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
