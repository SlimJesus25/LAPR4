package eapli.elearning.app.user.console.presentation.extralecture;

import eapli.elearning.extralecturemanagement.domain.ExtraLectureType;
import eapli.elearning.lecturemanagement.domain.LectureType;
import eapli.framework.visitor.Visitor;

public class ExtraLectureTypePrinter implements Visitor<ExtraLectureType> {
    @Override
    public void visit(ExtraLectureType visitee) {
        System.out.println("Extra Lecture Type: " + visitee);
    }
}
