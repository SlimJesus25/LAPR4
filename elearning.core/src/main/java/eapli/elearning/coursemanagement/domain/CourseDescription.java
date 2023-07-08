package eapli.elearning.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class CourseDescription implements ValueObject {

    private String courseDescription;

    public CourseDescription(String courseDescription) {
        Preconditions.noneNull(courseDescription);
        verifyCourseDescription(courseDescription);
        this.courseDescription = courseDescription;
    }

    public CourseDescription() {
    }

    private void verifyCourseDescription(String courseDescription){
        if(courseDescription.isEmpty()){
            throw new IllegalArgumentException("Course description cannot be empty!");
        }
    }

    public String description() {
        return courseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDescription that = (CourseDescription) o;
        return Objects.equals(courseDescription, that.courseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseDescription);
    }

    @Override
    public String toString() {
        return "CourseDescription{" +
                "courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
