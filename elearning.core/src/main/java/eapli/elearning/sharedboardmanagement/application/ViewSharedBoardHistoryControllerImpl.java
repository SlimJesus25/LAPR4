package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.BoardAction;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;

import java.util.Stack;

public class ViewSharedBoardHistoryControllerImpl implements ViewSharedBoardHistoryController{
    public Stack<BoardAction> viewHistoryOfUpdates(SharedBoard sharedBoard){
        return sharedBoard.viewHistoryOfUpdates();
    }
}
