package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingmanagement.application.CancelMeetingController;
import eapli.elearning.meetingmanagement.application.CancelMeetingControllerImpl;
import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingparticipationmanagement.application.ListOwnedUserMeetingsService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CancelMeetingUI extends AbstractUI {
    private final CancelMeetingController ctrl = new CancelMeetingControllerImpl();
    private final ListOwnedUserMeetingsService svc = new ListOwnedUserMeetingsService();
    @Override
    protected boolean doShow() {
        try{
            List<MeetingDTO> ownedMeetings = svc.listOwnedUserMeetings();
            if(ownedMeetings.isEmpty()){
                System.out.println("You have no scheduled meetings to cancel!");
                return false;
            }
            System.out.println("Select a meeting to cancel");
            final SelectWidget<MeetingDTO> meetingDTOSelectWidget =
                    new SelectWidget<>("Meetings", ownedMeetings, new MeetingPrinter());
            meetingDTOSelectWidget.show();
            MeetingDTO selectedMeeting = meetingDTOSelectWidget.selectedElement();
            if (selectedMeeting == null) {
                System.out.println("Exiting...");
                return false;
            }

            System.out.println("Are you sure you want to cancel this meeting\n1.Yes\n2.No");
            int option = Console.readOption(1, 2, 0);
            if(option == 1){
                ctrl.cancelMeeting(selectedMeeting.getMeetingID());
                System.out.println("Meeting was canceled successfully!");
            }else{
                System.out.println("Meeting wasn't canceled!");
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Cancel meeting";
    }
}
