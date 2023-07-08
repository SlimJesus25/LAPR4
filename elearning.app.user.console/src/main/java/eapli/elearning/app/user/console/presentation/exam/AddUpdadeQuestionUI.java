package eapli.elearning.app.user.console.presentation.exam;
import eapli.elearning.app.user.console.presentation.courseenrollment.CourseDTOPrinter;
import eapli.elearning.automaticformativeexammanagement.application.AddUpdadeQuestionController;
import eapli.elearning.coursemanagement.application.ListCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddUpdadeQuestionUI extends AbstractUI {
    private final AddUpdadeQuestionController ctrl = new AddUpdadeQuestionController();
    @Override
    protected boolean doShow() {
        System.out.println("Unfornutally this feature doesn't work with Numerical and Short Answer Questions");
        try{
            Scanner scanner = new Scanner(System.in);
            int userInput;

            do {
                System.out.print("1.Add a Question\n2.Update a Question\n0.Exit\n\n");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid value (1 or 2).");
                    System.out.print("Enter a value (1 or 2): ");
                    scanner.next();
                }
                userInput = scanner.nextInt();
            } while (userInput != 1 && userInput != 2 && userInput != 0);
            if(userInput == 1){
                String questionpath = Console.readLine("Insert file with the question:");
                ArrayList<String> results = ctrl.validateQuestion(questionpath);
                for (int i = 0; i < results.size(); i++) {
                    System.out.println(results.get(i));
                }

            }else if(userInput == 2){
                List<ExamQuestionDTO> questions = ctrl.listQuestions();
                System.out.println("Select a question to update");
                final SelectWidget<ExamQuestionDTO> questionDTOSelectWidget = new SelectWidget<>("All Questions", questions);
                questionDTOSelectWidget.show();
                ExamQuestionDTO selectedQuestion = questionDTOSelectWidget.selectedElement();
                if(selectedQuestion == null){
                    System.out.println("Exiting...");
                    return false;
                }

                String questionpath = Console.readLine("Insert file with the question:");
                ArrayList<String> results = ctrl.updateQuestion(questionpath,selectedQuestion);
                for (int i = 0; i < results.size(); i++) {
                    System.out.println(results.get(i));
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add or Update a Question to the Repository";
    }
}
