package eapli.elearning.app.user.console.presentation.postit;

import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.application.ListWritableSharedBoardsService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

public class CreatePostItUI extends AbstractUI {
    private final SendRequestService req = new SendRequestService();
    private final ListWritableSharedBoardsService svc
            = new ListWritableSharedBoardsService();

    @Override
    protected boolean doShow() {

        try{
            List<SharedBoardDTO> sharedBoards = svc.listWritableSharedBoards();
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

            Integer row = Console.readInteger("Row: ");
            Integer column = Console.readInteger("Column: ");
            String content = Console.readNonEmptyLine("Content: ", "");
            String feedback = req.sendPostItCreationRequest(row, column, content, selectedBoard);
            if(feedback.isEmpty()) {
                System.out.println("Post-it created successfully!");
            }else{
                System.out.println("An error occurred: " + feedback);
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create post-it";
    }
}
