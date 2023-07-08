package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.coursemanagement.application.ListCoursesController;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class SetTheachersUI extends AbstractUI {
    private final ListCoursesController listCoursesController = new ListCoursesController();
    @Override
    protected boolean doShow() {
        Iterable<CourseDTO> courses = listCoursesController.allCourses();

        System.out.println("Select a course to set the teachers");
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }

        return true;
    }

    @Override
    public String headline() {
        return "Set enrollment state to a course";
    }
}
