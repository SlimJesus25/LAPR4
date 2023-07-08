package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.domain.LectureType;
import eapli.framework.visitor.Visitor;

public class LectureTypePrinter implements Visitor<LectureType> {
    @Override
    public void visit(LectureType visitee) {
        System.out.println("Lecture Type: " + visitee);
    }
}
