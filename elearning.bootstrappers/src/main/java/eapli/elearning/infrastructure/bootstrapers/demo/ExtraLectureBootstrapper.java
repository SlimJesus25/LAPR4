package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.application.CreateExtraLectureController;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.domain.ExtraLectureType;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.studentmanagement.application.FindStudentByMechanographicalNumberService;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.application.FindTeacherByAcronymService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class ExtraLectureBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtraLectureBootstrapper.class);

    private final CreateExtraLectureController controller = new CreateExtraLectureController();
    private final FindStudentByMechanographicalNumberService findStudentByMechanographicalNumberService = new FindStudentByMechanographicalNumberService();
    @Override
    public boolean execute() {
        Teacher t1= findTeacherByAcronym("DDCC");
        Course c1= findCourseByCourseCode("SEM02-JAVA");
        LOGGER.debug("»»» Demo ExtraLectures created{}", id);
        ExtraLecture el1 = createExtraLecture(LocalTime.of(10,0), LocalTime.of(12,0), LocalDate.of(2023, 12, 1), ExtraLectureType.T, t1, c1);
        ExtraLecture el2 = createExtraLecture(LocalTime.of(20,0), LocalTime.of(22,0), LocalDate.of(2023, 7, 26), ExtraLectureType.PL, t1, c1);
        return true;
    }

    private Set<Student> getSomeStudents() {
        Set<Student> students=new HashSet<>();
        students.add(findStudentByUsername("guisauce"));
        students.add(findStudentByUsername("vasco"));
        return students;
    }

    private Course findCourseByCourseCode(String courseCode) {
        FindCourseByCourseCodeService controller = new FindCourseByCourseCodeService();
        return controller.findCourseByCourseCode(courseCode);
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }

    private Student findStudentByUsername(String username) {
        SystemUser user = getSystemUserByUsername(username);
        FindStudentByUsernameService controller = new FindStudentByUsernameService();
        return controller.findStudentByUsername(user.username());
    }

    private Teacher findTeacherByAcronym(String acronym) {
        FindTeacherByAcronymService controller = new FindTeacherByAcronymService();
        return controller.findTeacherByAcronym(acronym);
    }

    private ExtraLecture createExtraLecture(LocalTime lectureInitalTime, LocalTime lectureFinalTime, LocalDate lectureDate, ExtraLectureType lectureType, Teacher teacher,
                                            Course course){
        return controller.createExtraLecture(lectureInitalTime, lectureFinalTime, lectureDate, lectureType, teacher, course);
    }
}
