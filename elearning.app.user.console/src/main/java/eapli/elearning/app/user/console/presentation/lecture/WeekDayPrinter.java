package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.framework.visitor.Visitor;

public class WeekDayPrinter implements Visitor<LectureWeekDay> {
    @Override
    public void visit(LectureWeekDay visitee) {
        System.out.println(visitee.name());
    }
}