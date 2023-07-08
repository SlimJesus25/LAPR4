package eapli.elearning.app.user.console.presentation.postit;
import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.application.ListWritableSharedBoardsService;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class UndoLastChangePostItUI extends AbstractUI {
    ListWritableSharedBoardsService listSharedBoards = new ListWritableSharedBoardsService();
    SendRequestService svc = new SendRequestService();
    @Override
    protected boolean doShow() {
        try{
            List<SharedBoardDTO> sharedBoards = listSharedBoards.listWritableSharedBoards();
            if(sharedBoards.isEmpty()){
                System.out.println("You don't have any writable shared boards");
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
            String feedback = svc.sendPostItUndoRequest(selectedBoard.getSharedBoardTitle());
            if(feedback.isEmpty()){
                System.out.println("The undo to \"" + selectedBoard.getSharedBoardTitle()
                        + "\" was made successfully!");
            }else{
                System.out.println("An error occurred trying to undo the shared board: " + feedback);
            }
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Undo the last change of a Post It";
    }
}
