package eapli.elearning.lecturemanagement.application;


import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.extralecturemanagement.application.ListExtraClassesOfTeacherService;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.meetingmanagement.domain.CheckAvailabilityService;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@UseCaseController
public class CreateLectureController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final LectureRepository repo = PersistenceContext.repositories().lectures();
    public Lecture createLecture(LocalTime lectureInitialTime, LocalTime lectureFinalTime, LocalDate lectureInitialDate
            , LocalDate lectureFinalDate, LectureWeekDay lectureWeekDay, LectureType lectureType, Teacher teacher,
                                 Course course) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Lecture l = LectureFactory.createLecture(new LectureInitialTime(lectureInitialTime), new LectureFinalTime(lectureFinalTime),
                new LectureInitialDate(lectureInitialDate), new LectureFinalDate(lectureFinalDate),
                lectureWeekDay, lectureType, teacher, course);

        return repo.save(l);
    }
}