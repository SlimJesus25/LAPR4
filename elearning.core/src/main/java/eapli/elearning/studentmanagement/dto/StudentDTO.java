package eapli.elearning.studentmanagement.dto;

import eapli.elearning.studentmanagement.domain.StudentDateOfBirth;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.elearning.studentmanagement.domain.StudentTaxPayerNumber;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@DTO
@AllArgsConstructor
public class StudentDTO implements Serializable {
    private StudentMechanographicalNumber mechanographicalNumber;
    private StudentTaxPayerNumber taxPayerNumber;
    private StudentDateOfBirth dateOfBirth;
    private SystemUser systemUser;
}
