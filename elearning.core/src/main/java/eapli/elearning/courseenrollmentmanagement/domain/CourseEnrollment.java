package eapli.elearning.courseenrollmentmanagement.domain;

import eapli.elearning.courseenrollmentmanagement.dto.CourseEnrollmentDTO;
import eapli.elearning.coursemanagement.domain.*;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="CourseEnrollment")
public class CourseEnrollment implements AggregateRoot<Integer>, DTOable<CourseEnrollmentDTO> {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "courseEnrollment_id", nullable = false, length = 10)
private Integer courseEnrollmentID;
@Embedded
@Column(name="courseEnrollmentDate", nullable=false)
private CourseEnrollmentDate courseEnrollmentDate;
@Enumerated(EnumType.STRING)
@Column(name="courseEnrollmentState", nullable=false)
private StudentEnrollmentState studentEnrollmentState;
@ManyToOne
private Course courseEnrollmentCourse;
@ManyToOne
private Student courseEnrollmentStudent;
    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        CourseEnrollment that = (CourseEnrollment) other;
        return Objects.equals(courseEnrollmentID, that.courseEnrollmentID);
    }


    public CourseEnrollment(LocalDate courseEnrollmentDate, StudentEnrollmentState studentEnrollmentState,
                            Course course, Student student) {
        Preconditions.noneNull(courseEnrollmentDate, studentEnrollmentState, course, student);
        this.courseEnrollmentDate= new CourseEnrollmentDate(courseEnrollmentDate);
        this.studentEnrollmentState = studentEnrollmentState;
        this.courseEnrollmentCourse= course;
        this.courseEnrollmentStudent=student;
    }

    protected CourseEnrollment() {
    }

    public StudentEnrollmentState enrollmentState() {
        return studentEnrollmentState;
    }

    public void updateStudentEnrollment(StudentEnrollmentState approval){
        this.studentEnrollmentState = approval;
    }

    public void acceptStudentApplication(){
        this.studentEnrollmentState = StudentEnrollmentState.ACCEPTED;
    }
    public void rejectStudentApplication(){
        this.studentEnrollmentState = StudentEnrollmentState.REJECTED;
    }

    public void updateStudent(Student student){
        this.courseEnrollmentStudent = student;
    }

    public void updateCourse(Course course){
        this.courseEnrollmentCourse = course;
    }
    @Override
    public CourseEnrollmentDTO toDTO() {
        return new CourseEnrollmentDTO(courseEnrollmentID, courseEnrollmentDate.date(), studentEnrollmentState,
                courseEnrollmentCourse.toDTO(),courseEnrollmentStudent.toDTO());
    }
    @Override
    public Integer identity() {
        return this.courseEnrollmentID;
    }
}
