package eapli.elearning.postitmanagement.domain;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.domain.services.DomainService;

@DomainService
public class PostItChangeService {

    public void changePostIt(int newRow, int newColumn, int exRow, int exColumn, String content, SharedBoard sharedBoard){

        if (content!=null){
         sharedBoard.changePostItContent(newRow,newColumn,content);
        }
        if(newRow!=exRow){
            sharedBoard.changePostItPosition(newRow,newColumn,exRow,exColumn);
        }
    }


}
