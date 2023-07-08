package eapli.elearning.teacherschedulemanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.teachermanagement.domain.*;
import eapli.elearning.teacherschedulemanagement.domain.TeacherSchedule;
import eapli.elearning.teacherschedulemanagement.domain.TeacherScheduleBuilder;
import eapli.elearning.teacherschedulemanagement.repositories.TeacherScheduleRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class CreateTeacherScheduleController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeacherScheduleRepository repo = PersistenceContext.repositories().teacherSchedules();

    public TeacherSchedule createTeacherSchedule(List<Lecture> lectures){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.TEACHER);
        final TeacherSchedule newTeacherSchedule = new TeacherScheduleBuilder()
                .withLectures(lectures)
                .build();
        return repo.save(newTeacherSchedule);
    }
}