package eapli.elearning.extralecturemanagement.application;

import eapli.elearning.courseenrollmentmanagement.application.GetCourseEnrolledStudentsService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.application.ListTeacherAppliedCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.extralecturemanagement.domain.*;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.extralectureparticipantmanagement.application.CreateExtraLectureParticipantController;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.application.GetTeacherScheduleService;
import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.domain.ValidateExtraClassesService;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.meetingmanagement.domain.CheckAvailabilityService;
import eapli.elearning.studentmanagement.application.FindStudentByMechanographicalNumberService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class CreateExtraLectureController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExtraLectureRepository repo = PersistenceContext.repositories().extraLectures();
    private final ValidateExtraClassesService validateExtraClassesService = new ValidateExtraClassesService();
    private final CreateExtraLectureParticipantController createExtraLectureParticipantController = new CreateExtraLectureParticipantController();

    public ExtraLecture createExtraLecture(LocalTime extraLectureInitialTime, LocalTime extraLectureFinalTime, LocalDate extraLectureDate, ExtraLectureType extraLectureType, Teacher teacher, Course course) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        ExtraLecture l = new ExtraLecture(extraLectureType, new ExtraLectureInitialTime(extraLectureInitialTime), new ExtraLectureFinalTime(extraLectureFinalTime),
                new ExtraLectureDate(extraLectureDate), course, teacher);
        return repo.save(l);
    }
    public ExtraLectureParticipant createExtraLectureParticipant(ExtraLecture extraLecture, Student student) {
        return createExtraLectureParticipantController.createExtraLectureParticipant(extraLecture, student);
    }

}