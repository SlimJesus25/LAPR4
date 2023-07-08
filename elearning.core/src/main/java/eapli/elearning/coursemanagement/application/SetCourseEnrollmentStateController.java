package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.application.UseCaseController;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public interface SetCourseEnrollmentStateController {
    CourseDTO setCourseEnrollmentStateTo(String courseId, CourseState state);
}
