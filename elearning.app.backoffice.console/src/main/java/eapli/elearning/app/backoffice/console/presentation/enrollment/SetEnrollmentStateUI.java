package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.coursemanagement.application.ListCoursesController;
import eapli.elearning.coursemanagement.application.SetCourseEnrollmentStateController;
import eapli.elearning.coursemanagement.application.SetCourseEnrollmentStateControllerImpl;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SetEnrollmentStateUI extends AbstractUI {

    private final SetCourseEnrollmentStateController setStateController = new SetCourseEnrollmentStateControllerImpl();
    private final ListCoursesController listCoursesController = new ListCoursesController();


    @Override
    protected boolean doShow() {
        Iterable<CourseDTO> courses = listCoursesController.allCourses();

        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("Select a course to open/close enrollments", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }

        System.out.println("Select to open/close enrollments in this course");
        System.out.println("1.Open with enrollments\n2.Open without enrollments");
        CourseState selectedEnrollmentState = Console.readOption(1, 2, 0) == 1
                ? CourseState.OPEN_WITH_ENROLLMENTS : CourseState.OPEN_WITHOUT_ENROLLMENTS;

        try{
            setStateController.setCourseEnrollmentStateTo(selectedCourse.getCourseCode(), selectedEnrollmentState);
            System.out.println("The course " + selectedCourse.getCourseTitle() + " is now " + selectedEnrollmentState);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Set enrollment state to a course";
    }
}
