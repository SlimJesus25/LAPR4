package eapli.elearning.app.user.console.presentation.courseenrollment;

import eapli.elearning.courseenrollmentmanagement.application.CreateCourseEnrollmentController;
import eapli.elearning.courseenrollmentmanagement.application.OpenEnrollmentCoursesAvailableToEnrollStudentSessionService;
import eapli.elearning.courseenrollmentmanagement.domain.ListOpenEnrollmentCoursesAvailableToEnrollStudentSessionService;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.data.util.Pair;

import java.util.List;

public class MakeCourseEnrollmentApplicationUI extends AbstractUI {
    private final CreateCourseEnrollmentController createCourseEnrollmentController= new CreateCourseEnrollmentController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OpenEnrollmentCoursesAvailableToEnrollStudentSessionService openEnrollmentCoursesService = new OpenEnrollmentCoursesAvailableToEnrollStudentSessionService();


    @Override
    protected boolean doShow() {
        List<CourseDTO> courses = openEnrollmentCoursesService.allOpenEnrollmentCoursesAvailableToEnrollStudentSessionService(authz);
        if(courses!=null) {
            final SelectWidget<CourseDTO> courseDTOSelectWidget =
                    new SelectWidget<>("Courses to enroll\n", courses, new CourseDTOPrinter());
            courseDTOSelectWidget.show();
            CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
            if (selectedCourse == null) {
                System.out.println("Exiting...");
                return false;
            }
            createCourseEnrollmentController.createCourseEnrollment(selectedCourse, authz.session(), StudentEnrollmentState.CANDIDATE);
            System.out.println("Your application has been submitted! Our team will start evaluating and answer you soon ...");
        }
        else{
            System.out.println("You have no courses to enroll! Possible reasons:");
            System.out.println(": You can only send an application to courses that are open and available to candidates." +
                    "\n: You can't send an application if you're enrolled in that course." +
                    "\n: You can't send an application if you already have one to be answered.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Apply for a course!";
    }
}
