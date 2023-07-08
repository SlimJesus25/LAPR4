package eapli.elearning.app.backoffice.console.presentation.course;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.visitor.Visitor;

    public class TeacherDTOPrinter implements Visitor<TeacherDTO> {
        @Override
        public void visit(TeacherDTO visitee) {
            System.out.println(visitee.getAcronym());
        }
    }
