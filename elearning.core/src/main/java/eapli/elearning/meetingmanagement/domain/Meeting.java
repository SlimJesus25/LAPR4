package eapli.elearning.meetingmanagement.domain;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Entity
@Table(name="Meeting")
public class Meeting implements AggregateRoot<Integer>, DTOable<MeetingDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id", nullable = false, length = 10)
    private Integer meetingID;
    @Column(name="duration", nullable=false)
    @Embedded
    private MeetingDuration meetingDuration;
    @Column(name="time", nullable=false)
    @Embedded
    private MeetingDateTime meetingDateTime;
    @Column(name="name", nullable = false)
    @Embedded
    private MeetingName meetingName;
    @Enumerated(EnumType.STRING)
    private MeetingState meetingState;

    public Meeting(Integer meetingDuration, LocalDateTime meetingDateTime,
                   String meetingName) {
        this.meetingDuration = new MeetingDuration(meetingDuration);
        this.meetingDateTime = new MeetingDateTime(meetingDateTime);
        this.meetingName = new MeetingName(meetingName);
        this.meetingState = MeetingState.SCHEDULED;
    }


    public String name() {
        return meetingName.meetingName();
    }

    public MeetingDuration duration() {
        return meetingDuration;
    }

    public MeetingDateTime dateNTime() {
        return meetingDateTime;
    }

    public void cancelMeeting(){
        if(this.meetingDateTime.dateNTime().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("You can't cancel a meeting that already occurred!");
        }
        if(this.meetingState == MeetingState.CANCELED){
            throw new IllegalArgumentException("This meeting is already canceled!");
        }
        this.meetingState = MeetingState.CANCELED;
    }

    public MeetingState state() {
        return meetingState;
    }

    protected Meeting(){}
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Meeting that = (Meeting) other;
        return Objects.equals(meetingID, that.meetingID);
    }

    @Override
    public Integer identity() {
        return meetingID;
    }

    @Override
    public MeetingDTO toDTO() {
        return new MeetingDTO(this.meetingID,this.meetingDuration.duration()
                , this.meetingDateTime.dateNTime(), this.meetingName.meetingName());
    }
}
