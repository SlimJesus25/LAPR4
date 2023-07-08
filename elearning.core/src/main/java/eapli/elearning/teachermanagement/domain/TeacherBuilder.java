package eapli.elearning.teachermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

public class TeacherBuilder implements DomainFactory<Teacher> {
    private Teacher theTeacher;
    private String teacherAcronym;
    private String taxPayerNumber;
    private LocalDate dateOfBirth;
    private SystemUser systemUser;

    public TeacherBuilder withTeacherAcronym(String teacherAcronym) {
        this.teacherAcronym = teacherAcronym;
        return this;
    }
    public TeacherBuilder withTeacherTaxPayerNumber(String taxPayerNumber) {
        this.taxPayerNumber = taxPayerNumber;
        return this;
    }
    public TeacherBuilder withTeacherDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public TeacherBuilder withTeacherSystemUser(SystemUser systemUser) {
        this.systemUser= systemUser;
        return this;
    }
    @Override
    public Teacher build() {
        final Teacher student = buildOrThrow();
        theTeacher = null;
        return student;
    }
    private Teacher buildOrThrow(){
        if (theTeacher != null)
            return theTeacher;
        else if (teacherAcronym != null && taxPayerNumber != null && dateOfBirth != null && systemUser != null){
            theTeacher = new Teacher(teacherAcronym, taxPayerNumber, dateOfBirth, systemUser);
            return theTeacher;
        } else throw new IllegalStateException();
    }
}
