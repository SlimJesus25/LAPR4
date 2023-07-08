package eapli.elearning.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class ExamFinalDateTime implements ValueObject {
    private LocalDateTime finalDateTime;

    public ExamFinalDateTime(LocalDateTime finalDateTime) {
        this.finalDateTime = finalDateTime;
    }

    protected ExamFinalDateTime() {
    }

    public LocalDateTime dateTime() {
        return finalDateTime;
    }
}
