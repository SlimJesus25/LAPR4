package eapli.elearning.sharedboardmanagement.domain;

import eapli.elearning.postitmanagement.domain.PostIt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class SharedBoardTest {

    private SharedBoard sharedBoard;
    private PostIt postIt;

    @BeforeEach
    public void setUp(){
        sharedBoard = new SharedBoard("Test", LocalDateTime.now());
        postIt = new PostIt("Test");
    }

    @Test
    public void ensureSharedBoardTitleCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SharedBoard(null,
                new SharedBoardCreationTimestamp().timestamp()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SharedBoard("",
                new SharedBoardCreationTimestamp().timestamp())
        );
    }

    @Test
    public void ensureSharedBoardIsArchivable(){
        sharedBoard.archiveBoard();
        Assertions.assertSame(SharedBoardState.ARCHIVED, sharedBoard.boardState());
    }

    @Test
    public void ensureSharedBoardIsntArchivableAfterArchive(){
        sharedBoard.archiveBoard();
        Assertions.assertThrows(IllegalArgumentException.class, sharedBoard::archiveBoard);
    }

    @Test
    public void ensureSharedBoardIsRestorable(){
        SharedBoard sharedBoard = new SharedBoard("Test3", LocalDateTime.now());
        sharedBoard.archiveBoard();
        sharedBoard.restoreBoard();
        Assertions.assertSame(SharedBoardState.ACTIVE, sharedBoard.boardState());
    }

    @Test
    public void ensureSharedBoardIsntRestorableIfAlreadyActive(){
        Assertions.assertThrows(IllegalArgumentException.class, sharedBoard::restoreBoard);
    }

    @Test
    public void ensurePostItCantBeCreatedInSameCell(){
        sharedBoard.insertPostIt(3, 5, postIt);
        Assertions.assertThrows(IllegalArgumentException.class, () -> sharedBoard.insertPostIt(3, 5,
                postIt));
    }

    @Test
    public void ensureUndoPostItWorks(){
        sharedBoard.insertPostIt(3, 5, postIt);
        sharedBoard.undoLastChange();
        Assertions.assertDoesNotThrow(() -> sharedBoard.insertPostIt(3, 5, postIt));
    }

    @Test
    public void ensureUndoPostItDoesntWorkIfThereIsNoLastChange(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> sharedBoard.undoLastChange());
    }
}