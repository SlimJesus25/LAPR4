package eapli.elearning.app.backoffice.console.presentation.course;
import eapli.elearning.coursemanagement.application.CreateCourseController;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.teachermanagement.application.ListTeacherService;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class AddCourseUI extends AbstractUI {
    CreateCourseController theController = new CreateCourseController();
    ListTeacherService theListTeacherService = new ListTeacherService();
    @Override
    protected boolean doShow() {
        final String code = Console.readLine("Code");
        final String title = Console.readLine("Title");
        final String description = Console.readLine("Description");
        //Set<Teacher> team = new HashSet<>();
        //final CourseTeam team = Console.readLine("Team"); //Call a query to choose a team for the Course

        //Add regent
        Iterable<TeacherDTO> regent = theListTeacherService.listAllTeachers();

        System.out.println("Select a teacher to be the regent of this course: ");
        final SelectWidget<TeacherDTO> teacherDTOSelectWidget =
                new SelectWidget<>("All Teachers: ", regent, new TeacherDTOPrinter());
        teacherDTOSelectWidget.show();
        TeacherDTO selectedTeacher = teacherDTOSelectWidget.selectedElement();
        if(selectedTeacher == null){
            System.out.println("Teacher was not successfully selected to be the regent");
            return false;
        }
        final CourseState state = CourseState.CLOSE;
        try {
            this.theController.createCourse(code, title, description, state, selectedTeacher.getAcronym());
            System.out.println("Success! \n");
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("Couldn't create course");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Course";
    }
}
