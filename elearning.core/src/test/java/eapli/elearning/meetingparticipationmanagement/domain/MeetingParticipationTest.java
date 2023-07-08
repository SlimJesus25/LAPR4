package eapli.elearning.meetingparticipationmanagement.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MeetingParticipationTest {

    @Test
    public void ensureMeetingInvitationIsAcceptable(){
        MeetingParticipation meetingParticipation =
                new MeetingParticipation(null, null, ParticipationState.NO_ANSWER);

        Assertions.assertDoesNotThrow(meetingParticipation::acceptMeetingRequest);

        Assertions.assertSame(meetingParticipation.participationState(), ParticipationState.ACCEPTED);

    }

    @Test
    public void ensureMeetingInvitationIsRefusable(){
        MeetingParticipation meetingParticipation =
                new MeetingParticipation(null, null, ParticipationState.NO_ANSWER);
        Assertions.assertDoesNotThrow(meetingParticipation::rejectMeetingRequest);

        Assertions.assertSame(meetingParticipation.participationState(), ParticipationState.REFUSED);
    }

    @Test
    public void ensureInvitationCantBeAcceptedAfterBeingAnswered(){
        MeetingParticipation meetingParticipation =
                new MeetingParticipation(null, null, ParticipationState.ACCEPTED);
        Assertions.assertThrows(IllegalArgumentException.class, meetingParticipation::acceptMeetingRequest);
        Assertions.assertThrows(IllegalArgumentException.class, meetingParticipation::rejectMeetingRequest);
    }

    @Test
    public void ensureInvitationCantBeRefusedAfterBeingAnswered(){
        MeetingParticipation meetingParticipation =
                new MeetingParticipation(null, null, ParticipationState.REFUSED);
        Assertions.assertThrows(IllegalArgumentException.class, meetingParticipation::acceptMeetingRequest);
        Assertions.assertThrows(IllegalArgumentException.class, meetingParticipation::rejectMeetingRequest);
    }

    @Test
    public void ensureParticipationStateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> new MeetingParticipation(null, null, null));
    }

    @Test
    public void ensureGiveOwnerMembershipWorks(){
        MeetingParticipation meetingParticipation = new MeetingParticipation(null, null);
        meetingParticipation.giveMeetingOwnerShip();
        Assertions.assertSame(meetingParticipation.participationState(), ParticipationState.OWNER);
    }

    @Test
    public void ensureCantGiveOwnerMembershipToAnOwner(){
        MeetingParticipation meetingParticipation = new MeetingParticipation(null, null, ParticipationState.OWNER);
        Assertions.assertThrows(IllegalArgumentException.class, meetingParticipation::giveMeetingOwnerShip);

    }
}
