package eapli.elearning.studentmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

public class StudentBuilder implements DomainFactory<Student> {
    private Student theStudent;
    private StudentMechanographicalNumber mechanographicalNumber;
    private StudentTaxPayerNumber taxPayerNumber;
    private StudentDateOfBirth dateOfBirth;

    private SystemUser user;

    public StudentBuilder withStudentMechanographicalNumber(Integer year) {
        this.mechanographicalNumber = new StudentMechanographicalNumber(year);
        return this;
    }
    public StudentBuilder withStudentTaxPayerNumber(String taxPayerNumber) {
        this.taxPayerNumber = new StudentTaxPayerNumber(taxPayerNumber);
        return this;
    }
    public StudentBuilder withStudentDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = new StudentDateOfBirth(dateOfBirth);
        return this;
    }

    public StudentBuilder withStudentSystemUser(SystemUser user) {
        this.user = user;
        return this;
    }
    @Override
    public Student build() {
        final Student student = buildOrThrow();
        theStudent = null;
        return student;
    }
    private Student buildOrThrow(){
        if (theStudent != null)
            return theStudent;
        else if (mechanographicalNumber != null && taxPayerNumber != null && dateOfBirth != null){
            theStudent = new Student(taxPayerNumber.taxPayerNumber(), dateOfBirth.dateOfBirth(), user);
            return theStudent;
        } else throw new IllegalStateException();
    }
}
