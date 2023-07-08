package eapli.elearning.lecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.util.Objects;
@Embeddable
public class LectureInitialTime implements ValueObject {
    private LocalTime initialTime;

    public LectureInitialTime(LocalTime initialTime) {
        Preconditions.noneNull(initialTime);
        this.initialTime = initialTime;
    }

    public LectureInitialTime() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureInitialTime that = (LectureInitialTime) o;
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
        return "LectureInitalTime{" +
                "lectureInitalTime='" + initialTime + '\'' +
                '}';
    }
}
