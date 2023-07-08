package eapli.elearning.postitmanagement.domain;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.domain.SharedBoardBuilder;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class PostItTest {

    SharedBoard sb = dummySharedBoard("dummy board");

    public static SharedBoard dummySharedBoard(final String title) {
        final SharedBoardBuilder builder = new SharedBoardBuilder();
        return builder.withSharedBoardTitle(title).withSharedBoardCreationTimestamp(LocalDateTime.now()).build();
    }

    @Test
    public void ensurePostItContentCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostIt(null));
    }

    @Test
    public void ensurePostItContentCantBeEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostIt(""));
    }
}
