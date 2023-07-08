package eapli.elearning.sharedboardparticipationmanagement.dto;

import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserStatus;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DTO
public class SharedBoardParticipationDTO implements Serializable {
    private UserPermission userPermission;
    private UserStatus userStatus;
    private SystemUser systemUser;
    private SharedBoardDTO sharedBoardDTO;
}
