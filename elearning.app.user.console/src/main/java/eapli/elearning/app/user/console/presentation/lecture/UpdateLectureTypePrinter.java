package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.domain.LectureType;
import eapli.framework.visitor.Visitor;

public class UpdateLectureTypePrinter implements Visitor<LectureType> {
    @Override
    public void visit(LectureType visitee) {
        switch (visitee) {
            case T:
                System.out.print(" - THEORETICAL ||");
                break;
            case TP:
                System.out.print(" - THEORETICAL-PRACTICAL ||");
                break;
            case PL:
                System.out.print(" - PRACTICAL-LAB ||");
                break;
        }
    }
}
