package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SharedBoardPrinter implements Visitor<SharedBoardDTO> {
    @Override
    public void visit(SharedBoardDTO visitee) {
        System.out.println(visitee.getSharedBoardTitle() + " || " + visitee.getSharedBoardCreationTimestamp());
    }
}
