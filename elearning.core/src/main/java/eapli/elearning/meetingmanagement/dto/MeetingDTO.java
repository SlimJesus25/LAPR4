package eapli.elearning.meetingmanagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Data
@DTO
@AllArgsConstructor
public class MeetingDTO implements Serializable {
    private Integer meetingID;
    private Integer meetingDuration;
    private LocalDateTime meetingDateTime;
    private String meetingName;
}
