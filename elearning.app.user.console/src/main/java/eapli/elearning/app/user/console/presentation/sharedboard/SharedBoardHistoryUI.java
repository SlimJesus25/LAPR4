package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.app.user.console.presentation.postit.SharedBoardPrinter;
import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.application.ListAllSharedBoardsService;
import eapli.elearning.sharedboardparticipationmanagement.application.ListWritableSharedBoardsService;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class SharedBoardHistoryUI extends AbstractUI {
    @Override
    public String headline() {
        return "View the history of updates on a board!";
    }
    ListAllSharedBoardsService listSharedBoards = new ListAllSharedBoardsService();
    private final SendRequestService req = new SendRequestService();
    @Override
    protected boolean doShow() {
        try{

            List<SharedBoardDTO> sharedBoards = listSharedBoards.lisAllSharedBoards();
            if(sharedBoards.isEmpty()){
                System.out.println("You don't have Shared Boards available");
                return false;
            }
            System.out.println("Select a shared board");
            final SelectWidget<SharedBoardDTO> sharedBoardDTOSelectWidget =
                    new SelectWidget<>("Shared Boards", sharedBoards, new SharedBoardPrinter());
            sharedBoardDTOSelectWidget.show();
            SharedBoardDTO selectedBoard = sharedBoardDTOSelectWidget.selectedElement();
            if (selectedBoard == null) {
                System.out.println("Exiting...");
                return false;
            }

            String a=req.sendViewHistorySharedBoardRequest(selectedBoard.getSharedBoardTitle());
            System.out.println(a);









        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }
}
