package eapli.elearning.studentmanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class StudentFactory {
    public static Student createStudent(String taxPayerNumber, LocalDate dateOfBirth, SystemUser systemUser){
        return new Student(taxPayerNumber, dateOfBirth, systemUser);
    }
}
