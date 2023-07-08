package eapli.elearning.lecturemanagement.application;

import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.util.Optional;

public class UpdateLectureController {
    FindTeacherByUsernameService findTeacher= new FindTeacherByUsernameService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final LectureRepository repo = PersistenceContext.repositories().lectures();
    private final FindLectureByLectureIDController findLectureByLectureIDController = new FindLectureByLectureIDController();
    private final FindCourseByCourseCodeService findCourseByCourseCodeService = new FindCourseByCourseCodeService();
    private final Optional<UserSession> user=authz.session();

    public boolean updateLecture(LectureDTO lectureDTO, LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, CourseDTO updatedLectureCourse) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Teacher teacher;
        if(user.isPresent()) {
            teacher = findTeacher.findTeacherByUsername(user.get().authenticatedUser().identity());
            Lecture lecture = findLectureByLectureIDController.FindLectureByLectureID(lectureDTO.getLectureID());
            Course course = findCourseByCourseCodeService.findCourseByCourseCode(updatedLectureCourse.getCourseCode());
            repo.updateLecture(lecture, updatedInitialDate, updatedFinalDate, updatedWeekDay, updatedInitialTime, updatedFinalTime, updatedLectureType, teacher, course);
            return true;
        }
        return false;
    }
}
