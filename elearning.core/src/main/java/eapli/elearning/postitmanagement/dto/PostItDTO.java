package eapli.elearning.postitmanagement.dto;

import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Data
@DTO
@NoArgsConstructor
@AllArgsConstructor
public class PostItDTO {
    private String content;
}
