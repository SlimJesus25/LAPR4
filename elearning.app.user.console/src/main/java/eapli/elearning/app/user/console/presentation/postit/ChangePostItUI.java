package eapli.elearning.app.user.console.presentation.postit;

import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.application.ListWritableSharedBoardsService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;
public class ChangePostItUI extends AbstractUI{
    ListWritableSharedBoardsService listSharedBoards = new ListWritableSharedBoardsService();
    private final SendRequestService req = new SendRequestService();
    @Override
    public String headline() {
        return "Change post-it";
    }
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
            //mandar o titulo

            /*List<PostItDTO> postIts = listPostIts.listPostItsOfBoard(selectedBoard);
            if(postIts.isEmpty()){
                System.out.println("You don't have any Post It on that shared board");
                return false;
            }
            System.out.println("Select a Post-It");
            final SelectWidget<PostItDTO> PostItDTOSelectWidget =
                    new SelectWidget<>("Post-Its", postIts, new PostItPrinter());
            sharedBoardDTOSelectWidget.show();
            PostItDTO selectedPostIt = PostItDTOSelectWidget.selectedElement();
            if (selectedPostIt == null) {
                System.out.println("Exiting...");
                return false;
            }*/
            System.out.println("What postIt want to change?");
            Integer row = Console.readInteger("Row: ");
            Integer column = Console.readInteger("Column: ");
            String newContent=null;
            System.out.println("Do you want to content the row and column?");
            Integer opt = Console.readInteger("1-Yes  0-NO");

            if (opt==1)
               newContent = Console.readNonEmptyLine("New Content: ", "");

            System.out.println("Do you want to change the row and column ");
            opt = Console.readInteger("1-Yes  0-NO");
            if (opt==1) {
                    Integer newRow = Console.readInteger("New Row: ");
                    Integer newColumn = Console.readInteger("New Column: ");
                    req.sendPostItChangeRequest(newRow,newColumn,row,column,newContent,selectedBoard);
            }
            else
                req.sendPostItChangeRequest(row,column,row,column,newContent,selectedBoard);




          /*  if(feedback.isEmpty()) {
                System.out.println("Post-it Change successfully!");
            }else{
                System.out.println("An error occurred: " + feedback);
            }*/

        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;

    }
}
