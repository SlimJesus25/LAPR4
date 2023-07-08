package eapli.elearning.postitmanagement.application;

import eapli.elearning.postitmanagement.dto.PostItDTO;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.application.UseCaseController;

import java.io.IOException;

@UseCaseController
public interface CreatePostItController {
    PostItDTO createPostIt(Integer row, Integer column, String content, SharedBoard sharedBoard);
}
