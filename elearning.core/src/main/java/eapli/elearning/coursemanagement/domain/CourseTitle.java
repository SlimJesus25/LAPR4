package eapli.elearning.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class CourseTitle implements ValueObject {

    private String courseTitle;

    public CourseTitle(String courseTitle) {
        Preconditions.noneNull(courseTitle);
        verifyCourseTitle(courseTitle);
        this.courseTitle = courseTitle;
    }

    public CourseTitle() {
    }

    public String title() {
        return courseTitle;
    }

    private void verifyCourseTitle(String courseTitle){
        if(courseTitle.isEmpty()){
            throw new IllegalArgumentException("Course title cannot be empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTitle that = (CourseTitle) o;
        return Objects.equals(courseTitle, that.courseTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseTitle);
    }

    @Override
    public String toString() {
        return "CourseTitle{" +
                "courseTitle='" + courseTitle + '\'' +
                '}';
    }
}
