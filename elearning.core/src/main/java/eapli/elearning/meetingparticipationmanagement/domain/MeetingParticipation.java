package eapli.elearning.meetingparticipationmanagement.domain;

import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;

@Entity
public class MeetingParticipation implements AggregateRoot<Integer>, DTOable<MeetingParticipationDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne//(fetch = FetchType.EAGER)
    private SystemUser user;
    @ManyToOne//(fetch = FetchType.EAGER)
    private Meeting meeting;
    @Enumerated(EnumType.STRING)
    private ParticipationState state;

    public MeetingParticipation(SystemUser user, Meeting meeting) {
        this.user = user;
        this.meeting = meeting;
        this.state = ParticipationState.NO_ANSWER;
    }

    public MeetingParticipation(SystemUser user, Meeting meeting, ParticipationState state) {
        Preconditions.noneNull(state);
        this.user = user;
        this.meeting = meeting;
        this.state = state;
    }

    protected MeetingParticipation() {
    }

    public void acceptMeetingRequest(){
        if(this.state == ParticipationState.ACCEPTED || this.state == ParticipationState.REFUSED){
            throw new IllegalArgumentException("You've already answered the invite!");
        }
        this.state = ParticipationState.ACCEPTED;
    }

    public void rejectMeetingRequest(){
        if(this.state == ParticipationState.ACCEPTED || this.state == ParticipationState.REFUSED){
            throw new IllegalArgumentException("You've already answered the invite!");
        }
        this.state = ParticipationState.REFUSED;
    }

    public void giveMeetingOwnerShip(){
        if(this.state == ParticipationState.OWNER){
            throw new IllegalArgumentException("This user is already the owner!");
        }
        this.state = ParticipationState.OWNER;
    }

    public SystemUser user() {
        return user;
    }

    public Meeting meeting() {
        return meeting;
    }

    public ParticipationState participationState() {
        return state;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

    @Override
    public MeetingParticipationDTO toDTO() {
        return new MeetingParticipationDTO(id, user, meeting.toDTO(), state);
    }
}
