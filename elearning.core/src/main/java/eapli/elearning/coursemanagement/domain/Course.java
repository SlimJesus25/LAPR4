package eapli.elearning.coursemanagement.domain;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.util.Objects;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

@Entity
@Table(name="Course")
public class Course implements AggregateRoot<CourseCode>, DTOable<CourseDTO> {
    @EmbeddedId
    @Column(name="Code", nullable=false)
    private CourseCode courseCode;
    @Embedded
    @Column(name="Title", nullable=false)
    private CourseTitle courseTitle;
    @Embedded
    @Column(name="Description", nullable=true)
    private CourseDescription courseDescription;
    @ManyToOne
    private Teacher regent;

    @Enumerated(EnumType.STRING)
    @Column(name = "State", nullable = false)
    private CourseState courseState;


    public Course(String courseCode, String courseTitle, String courseDescription,
                  CourseState courseState, Teacher regent) {
        Preconditions.noneNull(courseCode, courseTitle, courseState, courseDescription, regent);
        this.courseCode = new CourseCode(courseCode);
        this.courseTitle = new CourseTitle(courseTitle);
        this.courseDescription = new CourseDescription(courseDescription);
        this.courseState = courseState;
        this.regent = regent;
    }

    protected Course() {
    }

    public void openCourse(){
        if(this.courseState == CourseState.CLOSE) {
            this.courseState = CourseState.OPEN;
        }else{
            throw new IllegalArgumentException("A course can only be opened if was closed!");
        }
    }

    public void closeCourse(){
        if(this.courseState == CourseState.OPEN_WITHOUT_ENROLLMENTS) {
            this.courseState = CourseState.CLOSE;
        }else{
            throw new IllegalArgumentException("A course can only be closed if was open without enrollments!");
        }
    }

    public void openCourseWithEnrollments(){
        if(this.courseState == CourseState.OPEN) {
            this.courseState = CourseState.OPEN_WITH_ENROLLMENTS;
        }else{
            throw new IllegalArgumentException("A course can only be opened with enrollments if was opened!");
        }
    }

    public void openCourseWithoutEnrollments(){
        if(this.courseState == CourseState.OPEN_WITH_ENROLLMENTS) {
            this.courseState = CourseState.OPEN_WITHOUT_ENROLLMENTS;
        }else{
            throw new IllegalArgumentException("A course can only be opened without enrollments if was opened with enrollments!");
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Course that = (Course) other;
        return Objects.equals(courseCode, that.courseCode);
    }

    @Override
    public CourseDTO toDTO() {
        return new CourseDTO(courseTitle.title(), courseCode.code(),
                courseDescription.description(), courseState, regent.toDTO());
    }

    @Override
    public CourseCode identity() {
        return this.courseCode;
    }

    @Override
    public String toString() {
        return courseCode.code() + "|" + courseTitle.title();
    }

}
