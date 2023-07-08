package eapli.elearning.coursemanagement.domain;

import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.domain.model.DomainFactory;
import java.util.Set;

public class CourseBuilder implements DomainFactory<Course> {
    private Course theCourse;
    private String courseCode;
    private String courseTitle;
    private String courseDescription;
    private CourseState courseState;
    private Teacher regent;

    public CourseBuilder withCourseCode(String courseCode) {
        this.courseCode = courseCode;
        return this;
    }
    public CourseBuilder withCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
        return this;
    }
    public CourseBuilder withCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
        return this;
    }
    public CourseBuilder withCourseState(CourseState courseState) {
        this.courseState = courseState;
        return this;
    }
    public CourseBuilder withRegent(Teacher regent) {
        this.regent = regent;
        return this;
    }
    @Override
    public Course build() {
        final Course course = buildOrThrow();
        theCourse = null;
        return course;
    }
    private Course buildOrThrow(){
        if (theCourse != null)
            return theCourse;
        else if (courseCode != null && courseTitle != null && courseDescription != null &&
                courseState != null && regent != null){
            theCourse = new Course(courseCode, courseTitle, courseDescription, courseState, regent);
            return theCourse;
        } else throw new IllegalStateException();
    }
}
