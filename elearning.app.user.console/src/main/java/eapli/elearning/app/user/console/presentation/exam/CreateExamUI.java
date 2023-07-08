package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.exammanagement.application.CreateExamController;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.Scanner;

public class CreateExamUI extends AbstractUI {
    private final CreateExamController theController = new CreateExamController();
    @Override
    protected boolean doShow() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try {
            ExamDTO exam = theController.createExam(userInput);
            System.out.println(exam.toString());
        } catch (IOException e) {
            System.out.println("Error creating exam!");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Exam";
    }
}
