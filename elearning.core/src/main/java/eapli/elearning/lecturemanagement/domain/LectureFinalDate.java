package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentDate;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
@Embeddable
public class LectureFinalDate implements ValueObject {
    private LocalDate finalDate;

    public LectureFinalDate(LocalDate finalDate) {
        Preconditions.noneNull(finalDate);
        this.finalDate = finalDate;
    }

    public LectureFinalDate() {
    }

    public LocalDate finalDate() {
        return finalDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureFinalDate that = (LectureFinalDate) o;
        return Objects.equals(finalDate, that.finalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalDate);
    }

    @Override
    public String toString() {
        return "LectureFinalDate{" +
                "lectureFinalDate='" + finalDate + '\'' +
                '}';
    }
}
