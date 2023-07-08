package eapli.elearning.app.user.console.presentation.postit;

import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.visitor.Visitor;

public class SharedBoardPrinter implements Visitor<SharedBoardDTO> {
    @Override
    public void visit(SharedBoardDTO visitee) {
        System.out.println("Title: " + visitee.getSharedBoardTitle()
                + "\nCreation timestamp: " + visitee.getSharedBoardCreationTimestamp());
    }
}
