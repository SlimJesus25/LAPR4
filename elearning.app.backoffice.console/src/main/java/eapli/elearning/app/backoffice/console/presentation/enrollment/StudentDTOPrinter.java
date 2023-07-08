package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class StudentDTOPrinter implements Visitor<CourseEnrollmentDTO> {
    @Override
    public void visit(CourseEnrollmentDTO visitee) {
        System.out.println("Name: " + visitee.getEnrollmentStudent().getSystemUser().name()
                + "\nMechanographical Number: " + visitee.getEnrollmentStudent().getMechanographicalNumber());
    }
}
