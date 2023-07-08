package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CourseEnrollmentDTOPrinter implements Visitor<CourseEnrollmentDTO> {
    @Override
    public void visit(CourseEnrollmentDTO visitee) {
        System.out.println("Course code: " + visitee.getEnrollmentCourse().getCourseCode() +
                " | Course title: " + visitee.getEnrollmentCourse().getCourseTitle());
    }
}
