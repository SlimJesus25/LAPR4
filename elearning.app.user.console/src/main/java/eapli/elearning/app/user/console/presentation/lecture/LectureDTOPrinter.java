package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.visitor.Visitor;

public class LectureDTOPrinter implements Visitor<LectureDTO> {
    @Override
    public void visit(LectureDTO visitee) {
        System.out.print("\n|| " + visitee.getCourse().getCourseTitle());
        switch (visitee.getLectureType()) {
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
        System.out.print("\n|| " + visitee.getLectureInitialDate()
                + " - " + visitee.getLectureFinalDate() + " ||\n|| " +
                visitee.getLectureInitialTime() + " - " +
                visitee.getLectureFinalTime() + " " +
                visitee.getLectureWeekDay().toString() + " ||\n");
    }
}
