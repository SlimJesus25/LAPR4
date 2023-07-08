package eapli.elearning.teachermanagement.dto;

import eapli.elearning.studentmanagement.domain.StudentDateOfBirth;
import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import eapli.elearning.studentmanagement.domain.StudentTaxPayerNumber;
import eapli.framework.representations.dto.DTO;
import eapli.framework.representations.dto.GeneralDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO implements Serializable {
    private String acronym;
    private String taxPayerNumber;
    private LocalDate dateOfBirth;
    private GeneralDTO systemUser;
}
