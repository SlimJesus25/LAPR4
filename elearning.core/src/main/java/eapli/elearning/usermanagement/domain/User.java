package eapli.elearning.usermanagement.domain;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.usermanagement.dto.UserDTO;
import eapli.framework.domain.model.AggregateRoot;

import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.representations.dto.DTOable;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="User")
public class User implements AggregateRoot<Integer>, DTOable<UserDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userID;

    @Column(name="userTaxPayNumber", nullable=false)
    @Embedded
    private TaxPayNumber taxPayNumber;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="userPassword", nullable=false)
    private String userPassword;

    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        User that = (User) other;
        return Objects.equals(userID, that.userID);
    }

    @Override
    public Integer identity() {
        return userID;
    }

   public UserDTO toDTO() {
        return new UserDTO(userID,taxPayNumber,birthDate,userPassword);
    }

}
