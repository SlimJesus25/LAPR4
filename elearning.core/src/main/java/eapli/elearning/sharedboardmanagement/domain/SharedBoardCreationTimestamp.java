package eapli.elearning.sharedboardmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Embeddable
public class SharedBoardCreationTimestamp implements ValueObject {
    public LocalDateTime timestamp;

    public SharedBoardCreationTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    protected SharedBoardCreationTimestamp() {
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }
}
