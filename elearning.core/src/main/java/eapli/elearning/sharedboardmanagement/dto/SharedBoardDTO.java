package eapli.elearning.sharedboardmanagement.dto;

import eapli.elearning.usermanagement.domain.User;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Gabriel Silva 1210808
 **/

@Data
@DTO
@AllArgsConstructor
@NoArgsConstructor
public class SharedBoardDTO implements Serializable {
    private Integer id;
    private String sharedBoardTitle;
    private LocalDateTime sharedBoardCreationTimestamp;
}
