package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.application.ListOwnedAndActiveSharedBoardsService;
import eapli.elearning.sharedboardmanagement.application.VisualizeSharedBoardController;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class VisualizeSharedBoardUI extends AbstractUI {
    private final SendRequestService requestSvc = new SendRequestService();
    private final ListOwnedAndActiveSharedBoardsService svc = new ListOwnedAndActiveSharedBoardsService();
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

            String boardAspect = requestSvc.sendVisualizeSharedBoardRequest(selectedSharedBoard.getSharedBoardTitle());

            System.out.println(boardAspect);

        }catch (Exception e){
            System.out.println("An error occurred: " + e);
        }
        return false;
    }

    @Override
    public String headline() {
        return "";
    }
}
