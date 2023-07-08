package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.app.user.console.presentation.courseenrollment.CourseDTOPrinter;
import eapli.elearning.coursemanagement.application.ListCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.application.ListExamsGradesController;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;
import java.util.Scanner;

public class ListCoursesExamsGradesUI extends AbstractUI {
    private final ListExamsGradesController listExamGrades = new ListExamsGradesController();
    private final ListCoursesService coursesService = new ListCoursesService();
    @Override
    protected boolean doShow() {

        try{
            Scanner scanner = new Scanner(System.in);
            int userInput;

            do {
                System.out.print("1.List Grades of All Courses\n2.List Grades of one Course\n0.Exit\n\n");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid value (1/2/0).");
                    scanner.next();
                }
                userInput = scanner.nextInt();
            } while (userInput != 1 && userInput != 2 && userInput != 0);
            if(userInput == 1){
                Iterable<FormerExamDTO> formerexamsLists = listExamGrades.listAllGrades();
                int cont = 0;
                System.out.println("Grades");
                for (FormerExamDTO exam : formerexamsLists) {
                    System.out.println(exam.getExam().getExamTitle() + " - " + exam.getFormerExamGrade());
                    cont++;
                }
                if(cont == 0){
                    System.out.println("At the current moment the course doesnt have exams to show the grades of!");
                }
                return false;
            }else if(userInput == 2){
                Iterable<CourseDTO> courses = coursesService.teacherCourses();
                System.out.println("Select a course to list the questions");
                final SelectWidget<CourseDTO> courseDTOSelectWidget = new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
                courseDTOSelectWidget.show();
                CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
                if(selectedCourse == null){
                    System.out.println("Exiting...");
                    return false;
                }

                Iterable<FormerExamDTO> formerexamsLists = listExamGrades.listExamsGrades(selectedCourse);
                int cont = 0;
                System.out.println("Grades");
                for (FormerExamDTO exam : formerexamsLists) {
                    System.out.println(exam.getExam().getExamTitle() + " - " + exam.getFormerExamGrade());
                    cont++;
                }
                if(cont == 0){
                    System.out.println("At the current moment the course doesnt have exams to show the grades of!");
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "List Exams Grades";
    }
}
