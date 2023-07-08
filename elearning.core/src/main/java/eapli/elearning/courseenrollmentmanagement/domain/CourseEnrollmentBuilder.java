package eapli.elearning.courseenrollmentmanagement.domain;


import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.model.DomainFactory;
import java.time.LocalDate;

public class CourseEnrollmentBuilder implements DomainFactory<CourseEnrollment> {
    private CourseEnrollment theCourseEnrollment;
    private CourseEnrollmentDate courseEnrollmentDate;
    private StudentEnrollmentState studentEnrollmentState;
    private Course course;
    private Student student;

    public CourseEnrollmentBuilder withCourseEnrollmentDate(LocalDate courseEnrollmentDate) {
        this.courseEnrollmentDate = new CourseEnrollmentDate(courseEnrollmentDate);
        return this;
    }
    public CourseEnrollmentBuilder withCourseEnrollmentState(StudentEnrollmentState studentEnrollmentState) {
        this.studentEnrollmentState = studentEnrollmentState;
        return this;
    }
    public CourseEnrollmentBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }
    public CourseEnrollmentBuilder withStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override
    public CourseEnrollment build() {
        final CourseEnrollment courseEnrollment = buildOrThrow();
        theCourseEnrollment = null;
        return courseEnrollment;
    }
    private CourseEnrollment buildOrThrow(){
        if (theCourseEnrollment != null)
            return theCourseEnrollment;
        else if (courseEnrollmentDate != null && studentEnrollmentState != null && course != null && student != null){
            theCourseEnrollment = new CourseEnrollment(courseEnrollmentDate.date(), studentEnrollmentState, course, student);
            return theCourseEnrollment;
        } else throw new IllegalStateException();
    }
}
