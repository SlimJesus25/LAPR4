package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseBuilder;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.application.FindTeacherByAcronymService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public class CreateCourseController {
    private final FindTeacherByAcronymService svcFindTeacher = new FindTeacherByAcronymService();
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final CourseRepository repo = PersistenceContext.repositories().courses();

    public Course createCourse(String courseCode, String courseTitle, String courseDescription,
                               CourseState state, String regentAcronym){
        auth.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        Teacher regent = svcFindTeacher.findTeacherByAcronym(regentAcronym);

        final Course newCourse = new CourseBuilder()
                .withCourseCode(courseCode)
                .withCourseTitle(courseTitle)
                .withCourseDescription(courseDescription)
                .withCourseState(state)
                //.withTeachers(teachers)
                .withRegent(regent)
                .build();

        return repo.save(newCourse);
    }



}
