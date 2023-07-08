package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.BoardAction;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.application.UseCaseController;

import java.util.Stack;

@UseCaseController
public interface ViewSharedBoardHistoryController {
    Stack<BoardAction> viewHistoryOfUpdates(SharedBoard sharedBoard);
}
