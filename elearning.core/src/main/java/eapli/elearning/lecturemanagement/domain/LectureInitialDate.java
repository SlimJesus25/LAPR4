package eapli.elearning.lecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class LectureInitialDate implements ValueObject {
    private LocalDate initialDate;

    public LectureInitialDate(LocalDate initialDate) {
        Preconditions.noneNull(initialDate);
        this.initialDate = initialDate;
    }

    public LectureInitialDate() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureInitialDate that = (LectureInitialDate) o;
        return Objects.equals(initialDate, that.initialDate);
    }

    public LocalDate initialDate() {
        return initialDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialDate);
    }

    @Override
    public String toString() {
        return "LectureInitialDate{" +
                "lectureInitialDate='" + initialDate + '\'' +
                '}';
    }

}
