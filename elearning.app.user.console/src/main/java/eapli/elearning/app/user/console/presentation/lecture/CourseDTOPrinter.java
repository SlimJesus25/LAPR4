package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseDTOPrinter implements Visitor<CourseDTO> {
    @Override
    public void visit(CourseDTO visitee) {
        System.out.println(visitee.getCourseTitle()+" - "+ visitee.getCourseDescription() + " - " + visitee.getCourseCode());
    }
}
