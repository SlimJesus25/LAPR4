package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.visitor.Visitor;

import java.time.format.DateTimeFormatter;

public class MeetingParticipationPrinter implements Visitor<MeetingParticipationDTO> {

    @Override
    public void visit(MeetingParticipationDTO visitee) {
        System.out.println("Meeting: " + visitee.getMeeting().getMeetingName() + "|"
                + visitee.getMeeting().getMeetingDateTime().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
