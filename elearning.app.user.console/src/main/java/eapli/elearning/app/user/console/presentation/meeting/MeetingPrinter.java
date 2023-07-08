package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.framework.visitor.Visitor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class MeetingPrinter implements Visitor<MeetingDTO> {
    @Override
    public void visit(MeetingDTO visitee) {
        System.out.print(visitee.getMeetingName() + ", " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(visitee.getMeetingDateTime())
                + ", " + visitee.getMeetingDuration() + " minutes");
        if(visitee.getMeetingDateTime().isBefore(LocalDateTime.now())){
            System.out.print(" (Already occurred)");
        }
        System.out.println();
    }
}
