package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.lecturemanagement.application.CreateLectureController;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.lecturemanagement.domain.LectureType;
import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.teachermanagement.application.FindTeacherByAcronymService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class LectureBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(LectureBootstrapper.class);

    private final CreateLectureController controller = new CreateLectureController();
    @Override
    public boolean execute() {
        Teacher t1= findTeacherByAcronym("DDCC");
        Course c1= findCourseByCourseCode("SEM02-JAVA");
        LOGGER.debug("»»» Demo Lectures created{}", id);
        Lecture l1 = createLecture(LocalTime.of(9, 0), LocalTime.of(10, 0),
                LocalDate.of(2023, 5, 1), LocalDate.of(2023, 6, 18),
                LectureWeekDay.Monday, LectureType.T, t1, c1);
        Lecture l2 = createLecture(LocalTime.of(7, 0), LocalTime.of(23, 0),
                LocalDate.of(2023, 5, 1), LocalDate.of(2023, 6, 18),
                LectureWeekDay.Sunday, LectureType.TP, t1, c1);
        Lecture l3 = createLecture(LocalTime.of(7, 30), LocalTime.of(12, 43),
                LocalDate.of(2023, 5, 1), LocalDate.of(2023, 6, 18),
                LectureWeekDay.Thursday, LectureType.PL, t1, c1);
        Lecture l4 = createLecture(LocalTime.of(8, 15), LocalTime.of(9, 5),
                LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 18),
                LectureWeekDay.Tuesday, LectureType.PL, t1, c1);
        Lecture l5 = createLecture(LocalTime.of(12, 10), LocalTime.of(14, 55),
                LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 10),
                LectureWeekDay.Tuesday, LectureType.PL, t1, c1);
        return true;
    }

    private Course findCourseByCourseCode(String courseCode) {
        FindCourseByCourseCodeService controller = new FindCourseByCourseCodeService();
        return controller.findCourseByCourseCode(courseCode);
    }

    private Teacher findTeacherByAcronym(String acronym) {
        FindTeacherByAcronymService controller = new FindTeacherByAcronymService();
        return controller.findTeacherByAcronym(acronym);
    }

    private Lecture createLecture(LocalTime lectureInitalTime, LocalTime lectureFinalTime, LocalDate lectureInitialDate
            , LocalDate lectureFinalDate, LectureWeekDay lectureWeekDay, LectureType lectureType, Teacher teacher,
                                  Course course){
        return controller.createLecture(lectureInitalTime, lectureFinalTime, lectureInitialDate,
                lectureFinalDate, lectureWeekDay, lectureType, teacher, course);
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
