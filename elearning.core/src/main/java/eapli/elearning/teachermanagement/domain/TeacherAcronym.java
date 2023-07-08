package eapli.elearning.teachermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Embeddable
public class TeacherAcronym implements ValueObject, Comparable<TeacherAcronym> {

    private static final long serialVersionUID = 1L;

    private String teacherAcronym;

    public TeacherAcronym(String teacherAcronym) {
        Preconditions.noneNull(teacherAcronym);
        verifyTeacherAcronym(teacherAcronym);
        this.teacherAcronym = teacherAcronym;
    }

    private void verifyTeacherAcronym(String teacherAcronym){
        if(teacherAcronym.isEmpty()){
            throw new IllegalArgumentException("Teacher acronym cannot be empty");
        }
    }

    public TeacherAcronym() {
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherAcronym that = (TeacherAcronym) o;
        return Objects.equals(teacherAcronym, that.teacherAcronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherAcronym);
    }

    @Override
    public String toString() {
        return "TeacherAcronym{" +
                "teacherAcronym='" + teacherAcronym + '\'' +
                '}';
    }

    public String acronym() {
        return teacherAcronym;
    }

    @Override
    public int compareTo(TeacherAcronym o) {
        return this.teacherAcronym.compareTo(o.teacherAcronym);
    }
}
