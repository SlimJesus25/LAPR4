package eapli.elearning.courseenrollmentmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Embeddable
public class CourseEnrollmentDate implements ValueObject {

    private LocalDate courseEnrollmentDate;

    public CourseEnrollmentDate(LocalDate courseEnrollmentDate) {
        Preconditions.noneNull(courseEnrollmentDate);
        this.courseEnrollmentDate = courseEnrollmentDate;
    }

    protected CourseEnrollmentDate() {
    }

    public LocalDate date() {
        return courseEnrollmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEnrollmentDate that = (CourseEnrollmentDate) o;
        return Objects.equals(courseEnrollmentDate, that.courseEnrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseEnrollmentDate);
    }

    @Override
    public String toString() {
        return courseEnrollmentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
