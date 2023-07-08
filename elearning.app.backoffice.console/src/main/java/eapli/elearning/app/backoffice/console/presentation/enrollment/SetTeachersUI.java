package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.coursemanagement.application.*;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.teachermanagement.application.ValidTeachersToAddToTeamService;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.*;


public class SetTeachersUI extends AbstractUI {
    private final SetTeachersController controller = new SetTeachersControllerImpl();
    private final ValidTeachersToAddToTeamService svc = new ValidTeachersToAddToTeamService();

    @Override
    protected boolean doShow() {

        Scanner ler = new Scanner(System.in);
        Iterable<CourseDTO> courses = controller.listCourses();



        System.out.println("Select a course to set the teachers");
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("All Courses", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        CourseDTO selectedCourse = courseDTOSelectWidget.selectedElement();
        if(selectedCourse == null){
            System.out.println("Exiting...");
            return false;
        }

        List<TeacherDTO> teachers = controller.listTeachers();
        svc.validateTeachersToAddToTeam(teachers, selectedCourse);

        Set<TeacherDTO> listOfTeachers = new HashSet<>();
        Map<Integer, TeacherDTO> map = new HashMap<>();
        int i=1;
        int answer = 1;
        while (answer != 0 ) {

            for (TeacherDTO t :teachers) {
                System.out.println(i+" - Teacher "+t.getAcronym());
                map.put(i,t);
                i++;
            }

            System.out.println("0 - Exit");
            System.out.println("Select a teacher:");
            answer = ler.nextInt();
            if(answer!=0){
                //add na base dadps
                TeacherDTO add = map.get(answer);
                teachers.remove(answer-1);
                listOfTeachers.add(add);
            }else {
                answer = 0;
            }


        i=1;
        map = new HashMap<>();

        }
        try {
            controller.setTeachersTo(selectedCourse.getCourseCode(), listOfTeachers);
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
