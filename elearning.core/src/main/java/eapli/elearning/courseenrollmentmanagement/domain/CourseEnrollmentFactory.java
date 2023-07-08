package eapli.elearning.courseenrollmentmanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.studentmanagement.domain.Student;

public class CourseEnrollmentFactory {

    public static CourseEnrollment createCourseEnrollment(Course course, Student student,
                                                          CourseEnrollmentDate courseEnrollmentDate,
                                                          StudentEnrollmentState studentEnrollmentState){
        return new CourseEnrollment();
    }
}
