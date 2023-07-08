package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.app.user.console.presentation.courseenrollment.CourseDTOPrinter;
import eapli.elearning.coursemanagement.application.ListCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.exammanagement.application.ListExamsController;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class ListExamsUI extends AbstractUI {
    private final ListExamsController examcontror = new ListExamsController();
    private final ListCoursesService coursesService = new ListCoursesService();
    @Override
    protected boolean doShow() {
        Iterable<CourseDTO> courses = coursesService.teacherCourses();
        System.out.println("Select a course to list the exams");
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }
        Iterable<ExamDTO> examsLists = examcontror.listExams(selectedCourse);
        int cont = 0;
        for (ExamDTO exam : examsLists) {
            System.out.println(exam.toString());
            cont++;
        }
        if(cont == 0){
            System.out.println("The course doesnt have any Exams!");
        }

        return false;
    }

    @Override
    public String headline() {
        return "List Exams";
    }
}
