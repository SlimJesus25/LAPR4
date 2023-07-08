package eapli.elearning.usermanagement.dto;

import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.elearning.usermanagement.domain.TaxPayNumber;
import eapli.framework.validations.Preconditions;

import java.util.Date;

public class UserDTO {
    private Integer userID;
    private TaxPayNumber taxPayNumber;
    private Date birthDate;
    private String userPassword;

    public UserDTO(Integer userID, TaxPayNumber taxPayNumber,Date birthDate,String userPassword) {
        Preconditions.noneNull(userID,taxPayNumber,birthDate,userPassword);
        this.userID=userID;
        this.taxPayNumber = taxPayNumber;
        this.birthDate=birthDate;
        this.userPassword=userPassword;
    }
}
