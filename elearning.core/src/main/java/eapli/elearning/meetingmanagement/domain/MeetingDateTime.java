package eapli.elearning.meetingmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class MeetingDateTime implements ValueObject {
    private LocalDateTime dateTime;

    public MeetingDateTime(LocalDateTime dateTime) {
        Preconditions.noneNull(dateTime);
        verifyDateTime(dateTime);
        this.dateTime = dateTime;
    }

    private void verifyDateTime(LocalDateTime dateTime){
        if(dateTime.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Date/Time must be later than now!");
        }
    }

    public MeetingDateTime() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingDateTime that = (MeetingDateTime) o;
        return Objects.equals(dateTime, that.dateTime);
    }

    public LocalDateTime dateNTime() {
        return dateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }

    @Override
    public String toString() {
        return "MeetingDateTime{" +
                "meetingDateTime='" + dateTime + '\'' +
                '}';
    }
}
