package eapli.elearning.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class ExamInitalDateTime implements ValueObject {

    private LocalDateTime initialDateTime;

    public ExamInitalDateTime(LocalDateTime initialDateTime) {
        verifyInitialDateTime(initialDateTime);
        this.initialDateTime = initialDateTime;
    }

    private void verifyInitialDateTime(LocalDateTime initialDateTime){
        if(initialDateTime.isBefore(LocalDateTime.now()) || initialDateTime.isEqual(LocalDateTime.now())){
            throw new IllegalArgumentException("Initial date must be after the actual time!");
        }
    }

    protected ExamInitalDateTime() {
    }

    public LocalDateTime dateTime() {
        return initialDateTime;
    }
}
