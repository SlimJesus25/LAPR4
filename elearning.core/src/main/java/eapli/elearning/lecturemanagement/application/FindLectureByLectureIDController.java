package eapli.elearning.lecturemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class FindLectureByLectureIDController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final LectureRepository repo = PersistenceContext.repositories().lectures();
    public Lecture FindLectureByLectureID(Integer id){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR, ElearningRoles.TEACHER);
        return repo.findLectureByID(id);
    }
}
