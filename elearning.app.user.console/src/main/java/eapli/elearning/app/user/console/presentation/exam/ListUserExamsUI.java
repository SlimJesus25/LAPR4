package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.exammanagement.application.ListUserExamsController;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.presentation.console.AbstractUI;

public class ListUserExamsUI extends AbstractUI {

    private final ListUserExamsController userExamControlLer = new ListUserExamsController();
    @Override
    protected boolean doShow() {
        Iterable<ExamDTO> examsLists = userExamControlLer.listUserExams();
        int cont = 0;
        for(ExamDTO exam : examsLists) {
        System.out.println(exam);
        cont++;
        }
        if(cont == 0) {
            System.out.println("The student doesnt have any Exams!");
        }
        return false;
    }
        @Override
        public String headline() {return "List Exams";}
}
