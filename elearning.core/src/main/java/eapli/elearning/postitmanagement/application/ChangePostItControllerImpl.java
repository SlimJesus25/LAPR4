package eapli.elearning.postitmanagement.application;


import eapli.elearning.postitmanagement.domain.PostItChangeService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;

public class ChangePostItControllerImpl implements ChangePostItController{
    PostItChangeService svc = new PostItChangeService();
    public void changePostIt(int newRow, int newColumn, int exRow, int exColumn, String content, SharedBoard sharedBoard){
        svc.changePostIt(newRow,newColumn,exRow,exColumn,content,sharedBoard);
    }
}
