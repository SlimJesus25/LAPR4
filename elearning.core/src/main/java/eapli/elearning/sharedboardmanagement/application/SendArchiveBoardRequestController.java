package eapli.elearning.sharedboardmanagement.application;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.application.UseCaseController;

import java.io.IOException;
import java.util.List;

@UseCaseController
public interface SendArchiveBoardRequestController {
    String archiveBoard(SharedBoard sharedBoard, String username);
}
