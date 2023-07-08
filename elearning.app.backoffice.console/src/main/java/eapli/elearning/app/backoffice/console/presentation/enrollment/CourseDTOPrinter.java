package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseDTOPrinter implements Visitor<CourseDTO> {
    @Override
    public void visit(CourseDTO visitee) {
        System.out.println(visitee.getCourseTitle() + " + " + visitee.getCourseCode() + " + " + visitee.getCourseState());
    }
}
