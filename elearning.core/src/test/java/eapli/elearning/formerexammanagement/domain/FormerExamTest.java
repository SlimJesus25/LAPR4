package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FormerExamTest {
    private Integer grade;
    private Student student;
    private Exam exam;
    @BeforeEach
    void setUp() {
        grade=10;
        student = new Student("21321312", LocalDate.of(1990,12, 3), null);
        exam = new Exam("title", "header", null, null, ExamType.FORMATIVE
                , LocalDateTime.now().plusSeconds(50), LocalDateTime.now().plusYears(1));
    }
    @Test
    public void ensureGradeCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FormerExam(student,exam, null));
    }
    @Test
    public void ensureStudentCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FormerExam(null,exam, grade));
    }
    @Test
    public void ensureExamCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FormerExam(student, null, grade));
    }
    @Test
    public void examGradeBetween0and20(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FormerExam(student, exam, 21));
    }

}
