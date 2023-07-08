package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import java.util.Objects;
@Embeddable
public class FormerExamID implements ValueObject, Comparable<FormerExamID> {
    @ManyToOne
    private Student student;
    @ManyToOne
    private Exam exam;

    public FormerExamID(Student student, Exam exam) {
        Preconditions.noneNull(student,exam);
        verifyStudent(student);
        verifyExam(exam);
        this.student = student;
        this.exam = exam;
    }
    public FormerExamID() {}
    public Student student() {
        return student;
    }
    public Exam exam() {
        return exam;
    }
    private void verifyStudent(Student student){}
    private void verifyExam(Exam exam) {}
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FormerExamID that = (FormerExamID) o;
        return Objects.equals(student, that.student) && Objects.equals(exam, that.exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, exam);
    }

    @Override
    public int compareTo(FormerExamID o) {
        int isEqualStudent=this.student.identity().compareTo(o.student.identity());
        if(isEqualStudent != 0)
            return isEqualStudent;
        return this.exam.identity().compareTo(o.exam.identity());
    }
}
