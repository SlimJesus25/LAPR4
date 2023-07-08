package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.courseenrollmentmanagement.application.AnswerStudentApplication;
import eapli.elearning.courseenrollmentmanagement.application.AnswerStudentApplicationImpl;
import eapli.elearning.courseenrollmentmanagement.application.ListApplicatedStudentsController;
import eapli.elearning.courseenrollmentmanagement.application.ListEnrollmentCoursesController;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.stream.StreamSupport;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class AnswerStudentApplicationUI extends AbstractUI {

    private final AnswerStudentApplication theController = new AnswerStudentApplicationImpl();
    private final ListEnrollmentCoursesController coursesController = new ListEnrollmentCoursesController();
    private final ListApplicatedStudentsController studentsController = new ListApplicatedStudentsController();

    @Override
    protected boolean doShow() {

        Iterable<CourseEnrollmentDTO> courseEnrollments = coursesController.allCoursesWithApplications();

        if(courseEnrollments == null || StreamSupport.stream(courseEnrollments.spliterator(), false).findAny().isEmpty()){
            System.out.println("There isn't any application or there isn't any course opened for enrollments, exiting...");
            return true;
        }

        System.out.println("Select a course to list student applications");
        final SelectWidget<CourseEnrollmentDTO> courseDTOSelectWidget =
                new SelectWidget<>("Courses with student applications", courseEnrollments,
                        new CourseEnrollmentDTOPrinter());
        courseDTOSelectWidget.show();
        CourseEnrollmentDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }

        Iterable<CourseEnrollmentDTO> students = studentsController.allCoursesWithApplicationsTo(selectedCourse);

        System.out.println("Select a student to give the approval");
        final SelectWidget<CourseEnrollmentDTO> studentDTOSelectWidget =
                new SelectWidget<>("Students with applications to " + selectedCourse.getEnrollmentCourse().
                        getCourseTitle() + " course", students, new StudentDTOPrinter());
        studentDTOSelectWidget.show();
        CourseEnrollmentDTO selectedStudent = studentDTOSelectWidget.selectedElement();
        if(selectedStudent == null){
            System.out.println("Exiting...");
            return false;
        }

        System.out.println("Give the approval to the student application");
        System.out.println("1.Accept\n2.Reject");
        StudentEnrollmentState studentEnrollmentState = Console.readOption(1, 2, 0) == 1 ?
                StudentEnrollmentState.ACCEPTED : StudentEnrollmentState.REJECTED;

        try{
            theController.answerStudentApplication(selectedStudent.getId(), selectedCourse.getEnrollmentCourse(),
                    selectedStudent.getEnrollmentStudent(), studentEnrollmentState);
            System.out.println("The student " + selectedStudent.getEnrollmentStudent().getMechanographicalNumber()
                    + " was " + studentEnrollmentState + " in the course "
                    + selectedCourse.getEnrollmentCourse().getCourseTitle());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Answer student application";
    }
}
