package eapli.elearning.meetingparticipationmanagement.dto;

import eapli.elearning.meetingmanagement.dto.MeetingDTO;
import eapli.elearning.meetingparticipationmanagement.domain.ParticipationState;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DTO
public class MeetingParticipationDTO {
    private Integer id;
    private SystemUser user;
    private MeetingDTO meeting;
    private ParticipationState state;
}
