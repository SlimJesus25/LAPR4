package eapli.elearning.lecturemanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@ApplicationService
public class GetTeacherScheduleService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final LectureRepository repo = PersistenceContext.repositories().lectures();
    FindTeacherByUsernameService findTeacher= new FindTeacherByUsernameService();
    public Iterable<LectureDTO> getTeacherSchedule(Optional<UserSession> user) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Teacher teacher;
        if(user.isPresent())
            teacher=findTeacher.findTeacherByUsername(user.get().authenticatedUser().identity());
        else return null;
        Iterable<Lecture> lectures = getTeacherLectures(teacher);
        return StreamSupport.stream(lectures.spliterator(), false).map(Lecture::toDTO).filter(dto -> (!dto.getLectureFinalDate().finalDate().isBefore(LocalDate.now()))).collect(Collectors.toList());
    }
    private Iterable<Lecture> getTeacherLectures(Teacher teacher) {
        return repo.listLecturesByTeacher(teacher.identity().acronym());
    }
}
