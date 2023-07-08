package eapli.elearning.teachermanagement.application;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.application.ApplicationService;
import java.util.List;

@ApplicationService
public class ValidTeachersToAddToTeamService {

    private final FindCourseRegentService findCourseRegent = new FindCourseRegentService();

    public void validateTeachersToAddToTeam(List<TeacherDTO> teacherList, CourseDTO code){
        TeacherDTO regent = findCourseRegent.findCourseRegent(code);
        teacherList.removeIf(e -> e.getAcronym().equals(regent.getAcronym()));
    }
}
