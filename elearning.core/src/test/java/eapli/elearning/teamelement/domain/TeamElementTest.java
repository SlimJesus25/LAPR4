package eapli.elearning.teamelement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TeamElementTest {
    LocalDate adhesionDate;
    Course course;
    Teacher teacher;

    @BeforeEach
    void setUp() {
        adhesionDate = LocalDate.of(2023,12,12);
        teacher = new Teacher("AMS", "21321312", LocalDate.of(1990,12, 3), null);
        course = new Course("JAVA", "Java Collections Framework", "Java Collections Framework", CourseState.CLOSE, teacher);
    }

    @Test
    public void ensureTeamElementAdhesionDateCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TeamElement(null, course, teacher));
    }
    @Test
    public void ensureTeamElementCourseCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TeamElement(adhesionDate, null, teacher));
    }
    @Test
    public void ensureTeamElementTeacherCantBeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TeamElement(adhesionDate, course, null));
    }
}
