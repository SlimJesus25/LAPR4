package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.app.user.console.presentation.lecture.CourseDTOPrinter;
import eapli.elearning.automaticformativeexammanagement.application.CreateUpdateAutomaticFormativeExamController;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class CreateUpdateAutomaticFormativeExamUI extends AbstractUI {
    private final CreateUpdateAutomaticFormativeExamController ctrl = new CreateUpdateAutomaticFormativeExamController();

    @Override
    protected boolean doShow() {
        try{
            System.out.println("1.Create\n2.Update");
            int action = Console.readOption(1, 2, 0);

            String path = Console.readNonEmptyLine("Path to exam: ", null);

            ExamDTO exam = null;

            switch(action){
                case 1:

                    List<CourseDTO> courses = ctrl.listTeacherCourses();
                    System.out.println("Select a course");
                    final SelectWidget<CourseDTO> courseDTOSelectWidget =
                            new SelectWidget<>("Courses", courses, new CourseDTOPrinter());
                    courseDTOSelectWidget.show();
                    CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
                    if (selectedCourse == null) {
                        System.out.println("Exiting...");
                        return false;
                    }

                    exam = ctrl.createAutomaticFormativeExamController(selectedCourse, path);
                    System.out.println("Automatic formative exam was successfully created!");
                    break;
                case 2:
                    exam = ctrl.updateAutomaticFormativeExamController(path);
                    System.out.println("Automatic formative exam was successfully updated!");
                    break;
            }
            ExamPrinter printer = new ExamPrinter();
            printer.visit(exam);

            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create/Update automatic formative exam";
    }
}
