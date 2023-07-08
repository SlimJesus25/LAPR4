package eapli.elearning.postitmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.application.UseCaseController;

@UseCaseController
public interface ChangePostItController {
    void changePostIt(int newRow, int newColumn, int exRow, int exColumn, String content, SharedBoard sharedBoard);
}
