package eapli.elearning.teamelementmanagament.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;

import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class TeamElementFactory {

    public static TeamElement createTeamElement(Course course, Teacher teacher, LocalDate adhesionDate){
        return new TeamElement(adhesionDate, course, teacher);
    }
}
