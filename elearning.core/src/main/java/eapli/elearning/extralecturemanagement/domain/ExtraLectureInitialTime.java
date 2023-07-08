package eapli.elearning.extralecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.util.Objects;
@Embeddable
public class ExtraLectureInitialTime implements ValueObject {
    private LocalTime initialTime;

    public ExtraLectureInitialTime(LocalTime initialTime) {
        Preconditions.noneNull(initialTime);
        this.initialTime = initialTime;
    }

    public ExtraLectureInitialTime() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraLectureInitialTime that = (ExtraLectureInitialTime) o;
        return Objects.equals(initialTime, that.initialTime);
    }

    public LocalTime initialTime() {
        return initialTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialTime);
    }

    @Override
    public String toString() {
        return "ExtraLectureInitialTime{" +
                "extraLectureInitialTime='" + initialTime + '\'' +
                '}';
    }
}
