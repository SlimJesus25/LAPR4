package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.app.user.console.presentation.courseenrollment.CourseDTOPrinter;
import eapli.elearning.coursemanagement.application.ListCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.formerexammanagement.application.ListExamGradesStudentController;
import eapli.elearning.formerexammanagement.dto.FormerExamDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class ListExamGradesStudentUI extends AbstractUI {
    private final ListExamGradesStudentController ctrl = new ListExamGradesStudentController();
    private final ListCoursesService coursesService = new ListCoursesService();

    @Override
    protected boolean doShow() {
        try{
                Iterable<CourseDTO> courses = coursesService.studentCourses();
                System.out.println("Select a course to list the grades of his respective exams: ");
                final SelectWidget<CourseDTO> courseDTOSelectWidget = new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
                courseDTOSelectWidget.show();
                CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
                if(selectedCourse == null){
                    System.out.println("Exiting...");
                    return false;
                }

                Iterable<FormerExamDTO> formerExamList = ctrl.listExamsGrades(selectedCourse);
                int cont = 0;
                System.out.println("Grades");
                for (FormerExamDTO exam : formerExamList) {
                    System.out.println(exam.getExam().getExamTitle() + " - " + exam.getFormerExamGrade());
                    cont++;
                }
                if(cont == 0){
                    System.out.println("At the current moment the course doesnt have exams to show the grades of!");
                }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "List Exam Grades of Student";
    }
}
