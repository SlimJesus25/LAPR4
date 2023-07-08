package eapli.elearning.extralecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
@Embeddable
public class ExtraLectureFinalTime implements ValueObject {
    private LocalTime finalTime;

    public ExtraLectureFinalTime(LocalTime finalTime) {
        Preconditions.noneNull(finalTime);
        this.finalTime = finalTime;
    }

    public ExtraLectureFinalTime() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraLectureFinalTime that = (ExtraLectureFinalTime) o;
        return Objects.equals(finalTime, that.finalTime);
    }

    public LocalTime finalTime() {
        return finalTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalTime);
    }

    @Override
    public String toString() {
        return "ExtraLectureFinalTime{" +
                "extraLectureFinalTime='" + finalTime + '\'' +
                '}';
    }
}
