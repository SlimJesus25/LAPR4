package eapli.elearning.extralectureparticipantmanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipantFactory;
import eapli.elearning.extralectureparticipantmanagement.repositories.ExtraLectureParticipantRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.elearning.teamelementmanagament.domain.TeamElementFactory;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
@Controller
public class CreateExtraLectureParticipantController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExtraLectureParticipantRepository repo = PersistenceContext.repositories().extraLectureParticipants();
    public ExtraLectureParticipant createExtraLectureParticipant(ExtraLecture extraLecture, Student student){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR,ElearningRoles.TEACHER);
        final ExtraLectureParticipant theExtraLectureParticipant = ExtraLectureParticipantFactory.createExtraLectureParticipant(extraLecture, student);
        return repo.save(theExtraLectureParticipant);
    }
}
