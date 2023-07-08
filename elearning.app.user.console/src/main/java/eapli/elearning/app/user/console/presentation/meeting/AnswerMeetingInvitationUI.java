package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingparticipationmanagement.application.AnswerMeetingInvitationController;
import eapli.elearning.meetingparticipationmanagement.application.AnswerMeetingInvitationControllerImpl;
import eapli.elearning.meetingparticipationmanagement.application.ListMeetingByUserService;
import eapli.elearning.meetingparticipationmanagement.dto.MeetingParticipationDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

public class AnswerMeetingInvitationUI extends AbstractUI {

    private final ListMeetingByUserService svc = new ListMeetingByUserService();
    private final AnswerMeetingInvitationController ctrl = new AnswerMeetingInvitationControllerImpl();
    @Override
    protected boolean doShow() {

        try{
            List<MeetingParticipationDTO> unansweredMeetings = svc.listUnansweredMeetingsByUser();
            if(unansweredMeetings.isEmpty()){
                System.out.println("You have no meeting invitations");
                return false;
            }
            System.out.println("Select a meeting to answer");
            final SelectWidget<MeetingParticipationDTO> meetingDTOSelectWidget =
                    new SelectWidget<>("Meetings", unansweredMeetings, new MeetingParticipationPrinter());
            meetingDTOSelectWidget.show();
            MeetingParticipationDTO selectedMeeting = meetingDTOSelectWidget.selectedElement();
            if (selectedMeeting == null) {
                System.out.println("Exiting...");
                return false;
            }

            System.out.println("1.Accept\n2.Refuse");
            int option = Console.readOption(1, 2, 0);
            if(option == 1){
                ctrl.acceptMeetingInvitation(selectedMeeting);
                System.out.println("Invitation accepted successfully!");
            }else if(option == 2){
                ctrl.refuseMeetingInvitation(selectedMeeting);
                System.out.println("Invitation refused successfully!");
            }else{
                System.out.println("Exiting...");
                return false;
            }


        }catch (Exception e){
            System.out.println("An error occurred: " + e);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Accept Meeting Invitation";
    }
}
