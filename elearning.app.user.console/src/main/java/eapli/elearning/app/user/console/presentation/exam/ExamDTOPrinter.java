package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.visitor.Visitor;

public class ExamDTOPrinter implements Visitor<ExamDTO> {

    @Override
    public void visit(ExamDTO visitee) {
        System.out.println("Course: "+visitee.getCourse().getCourseTitle()+" Exam:"+visitee.getExamTitle()+"\n");
    }
}
