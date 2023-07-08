package eapli.elearning.app.user.console.presentation.extralecture;

import eapli.elearning.studentmanagement.application.CreateStudentController;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.visitor.Visitor;

public class StudentPrinter implements Visitor<StudentDTO> {
    CreateStudentController controller = new CreateStudentController();
    @Override
    public void visit(StudentDTO visitee) {
        System.out.println("Student "+visitee.getSystemUser().username()+" : " + visitee.getMechanographicalNumber());
    }
}
