package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.studentmanagement.dto.StudentDTO;
import eapli.framework.application.UseCaseController;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@UseCaseController
public interface AnswerStudentApplication {
    CourseEnrollmentDTO answerStudentApplication(Integer identity, CourseDTO courseCode, StudentDTO studentMechanographicalNumber,
                                                 StudentEnrollmentState approval);
}
