package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.application.ListOwnedAndActiveSharedBoardsService;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

public class ArchiveBoardUI extends AbstractUI {
    private final ListOwnedAndActiveSharedBoardsService svc = new ListOwnedAndActiveSharedBoardsService();
    private final SendRequestService svc2 = new SendRequestService();
    @Override
    protected boolean doShow() {

        try{
            List<SharedBoardDTO> ownedSharedBoards = svc.listOwnedAndActiveSharedBoards();

            if(ownedSharedBoards.isEmpty()){
                System.out.println("You don't have any active shared board!");
                return false;
            }

            System.out.println("Choose a board you own");
            final SelectWidget<SharedBoardDTO> sharedBoardDTOSelectWidget =
                    new SelectWidget<>("Shared Boards", ownedSharedBoards, new SharedBoardPrinter());
            sharedBoardDTOSelectWidget.show();
            SharedBoardDTO selectedSharedBoard = sharedBoardDTOSelectWidget.selectedElement();
            if (selectedSharedBoard == null) {
                System.out.println("Exiting...");
                return false;
            }

            System.out.println("Are you sure that you want to archive "
                    + selectedSharedBoard.getSharedBoardTitle() + " shared board?\n1.Yes\n2.No");
            if(Console.readOption(1, 2, 0) == 2){
                return false;
            }

            String feedback = svc2.sendArchiveBoardRequest(selectedSharedBoard.getSharedBoardTitle());

            if(feedback.isEmpty()){
                System.out.println("Shared board \"" + selectedSharedBoard.getSharedBoardTitle()
                        + "\" archived successfully!");
            }else{
                System.out.println("An error occurred trying to archive the shared board: " + feedback);
            }

        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Archive board";
    }
}
