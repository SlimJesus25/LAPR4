package eapli.elearning.teachermanagement.domain;

import eapli.elearning.studentmanagement.domain.StudentDateOfBirth;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Embeddable
public class TeacherDateOfBirth implements ValueObject {

    private LocalDate dateOfBirth;

    private static final int AGE_OF_MAJORITY = 18;

    public TeacherDateOfBirth(LocalDate dateOfBirth) {
        Preconditions.noneNull(dateOfBirth);
        verifyTeacherDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    private void verifyTeacherDateOfBirth(LocalDate dateOfBirth){
        long age = LocalDate.from(dateOfBirth).until(LocalDate.now(), ChronoUnit.YEARS);
        if(age < AGE_OF_MAJORITY){
            throw new IllegalArgumentException("Teacher cannot be under " + AGE_OF_MAJORITY + "!");
        }
    }

    public TeacherDateOfBirth() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDateOfBirth that = (TeacherDateOfBirth) o;
        return Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth);
    }

    @Override
    public String toString() {
        return "TeacherDateOfBirth{" +
                "teacherDateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
