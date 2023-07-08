package eapli.elearning.meetingmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class MeetingDuration implements ValueObject {
    private Integer duration;
    private static Integer MINUTES_IN_A_DAY = 24*60;

    public MeetingDuration(Integer duration) {
        Preconditions.noneNull(duration);
        verifyDuration(duration);
        this.duration = duration;
    }

    private void verifyDuration(Integer duration){
        if(duration <= 0){
            throw new IllegalArgumentException("Duration cannot be negative!");
        }
        if(duration >= MINUTES_IN_A_DAY){
            throw new IllegalArgumentException("Duration cannot exceed a day!");
        }
    }

    public MeetingDuration() {
    }

    public Integer duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingDuration that = (MeetingDuration) o;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }

    @Override
    public String toString() {
        return "MeetingDuration{" +
                "meetingDuration='" + duration + '\'' +
                '}';
    }
}
