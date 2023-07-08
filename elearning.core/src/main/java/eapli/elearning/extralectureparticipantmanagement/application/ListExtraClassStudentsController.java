package eapli.elearning.extralectureparticipantmanagement.application;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralectureparticipantmanagement.repositories.ExtraLectureParticipantRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListExtraClassStudentsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExtraLectureParticipantRepository repo = PersistenceContext.repositories().extraLectureParticipants();

    public Iterable<StudentDTO> listExtraClassStudents(ExtraLecture extraLecture) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR, ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        Iterable<Student> studentsOfExtraClass=findStudentsOfExtraClass(extraLecture);
        return StreamSupport.stream(studentsOfExtraClass.spliterator(), false).map(Student::toDTO).collect(Collectors.toList());
    }

    private Iterable<Student> findStudentsOfExtraClass(ExtraLecture extraLecture) {
        return repo.findExtraLectureParticipantsByExtraLecture(extraLecture);
    }
}
