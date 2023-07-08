package eapli.elearning.app.user.console.presentation.postit;

import eapli.elearning.postitmanagement.domain.PostIt;
import eapli.elearning.postitmanagement.dto.PostItDTO;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.visitor.Visitor;

public class PostItPrinter implements Visitor<PostItDTO> {

    @Override
    public void visit(PostItDTO visitee) {
//        System.out.println("Content: "+visitee.getContent()
//                + "\nRow: " + visitee.getRow()
//                + "\nColumn: " + visitee.getColumn()
//                + "\nShared Board: " + visitee.getSharedBoardDTO().getSharedBoardTitle());
    }
}
