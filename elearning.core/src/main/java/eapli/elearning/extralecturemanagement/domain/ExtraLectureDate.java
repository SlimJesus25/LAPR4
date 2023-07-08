package eapli.elearning.extralecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;
@Embeddable
public class ExtraLectureDate implements ValueObject {
    private LocalDate date;

    public ExtraLectureDate(LocalDate date) {
        Preconditions.noneNull(date);
        this.date = date;
    }

    public ExtraLectureDate() {
    }

    public LocalDate date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraLectureDate that = (ExtraLectureDate) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "ExtraLectureDate{" +
                "extraLectureDate='" + date + '\'' +
                '}';
    }
}