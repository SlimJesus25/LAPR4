package eapli.elearning.extralecturemanagement.application;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
@ApplicationService
public class ListExtraClassesOfTeacherService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExtraLectureRepository repo = PersistenceContext.repositories().extraLectures();

    public List<ExtraLectureDTO> allExtraClassesOfTeacher(Teacher teacher){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Iterable<ExtraLecture> extraClasses = repo.listAllExtraLecturesOfTeacher(teacher.toDTO().getAcronym());
        List<ExtraLectureDTO> result = new ArrayList<>();
        extraClasses.forEach(a -> result.add(a.toDTO()));
        return new ArrayList<>(result);
    }
}
