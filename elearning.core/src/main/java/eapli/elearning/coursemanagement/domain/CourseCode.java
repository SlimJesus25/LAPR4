package eapli.elearning.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class CourseCode implements ValueObject, Comparable<CourseCode> {
    public String code() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    private String courseCode;

    public CourseCode(String courseCode) {
        Preconditions.noneNull(courseCode);
        verifyCourseCode(courseCode);
        this.courseCode = courseCode;
    }

    public CourseCode() {
    }

    private void verifyCourseCode(String courseCode){
        if(courseCode.isEmpty()){
            throw new IllegalArgumentException("Course code cannot be empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CourseCode that = (CourseCode) o;
        return Objects.equals(courseCode, that.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public String toString() {
        return "CourseCode{" +
                "courseCode='" + courseCode + '\'' +
                '}';
    }

    @Override
    public int compareTo(CourseCode o) {
        return this.courseCode.compareTo(o.courseCode);
    }
}
