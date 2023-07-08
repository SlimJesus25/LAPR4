package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingparticipationmanagement.application.ListMeetingParticipantsController;
import eapli.elearning.meetingparticipationmanagement.application.ListMeetingParticipantsControllerImpl;
import eapli.elearning.meetingparticipationmanagement.application.ListUserMeetingsService;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ListMeetingParticipantsUI extends AbstractUI {

    private final ListMeetingParticipantsController ctrl = new ListMeetingParticipantsControllerImpl();
    private final ListUserMeetingsService svc = new ListUserMeetingsService();
    @Override
    protected boolean doShow() {

        try{
            List<MeetingDTO> userMeetings = svc.listUserMeetings();
            if(userMeetings.isEmpty()){
                System.out.println("You have no meetings");
                return false;
            }
            System.out.println("Select a meeting");
            final SelectWidget<MeetingDTO> meetingDTOSelectWidget =
                    new SelectWidget<>("Meetings", userMeetings, new MeetingPrinter());
            meetingDTOSelectWidget.show();
            MeetingDTO selectedMeeting = meetingDTOSelectWidget.selectedElement();
            if (selectedMeeting == null) {
                System.out.println("Exiting...");
                return false;
            }

            System.out.println("Invited users");
            List<MeetingParticipationDTO> meetingParticipants = ctrl.listMeetingParticipants(selectedMeeting.getMeetingID());
            for(MeetingParticipationDTO mp : meetingParticipants){
                System.out.println(mp.getUser().name() + " -> "
                        + mp.getState().name().toLowerCase().replaceAll("_", " "));
            }

            Console.readLine("\nPress enter to continue");

        }catch (Exception e){
            System.out.println("An error occurred: " + e);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Participants in meeting";
    }
}
