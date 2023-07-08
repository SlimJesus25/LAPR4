package eapli.elearning.examquestionmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ExamQuestionStatement implements ValueObject {
    @Lob
    private String statement;

    public ExamQuestionStatement(String statement) {
        this.statement = statement;
    }

    protected ExamQuestionStatement() {
    }

    public String statement() {
        return statement;
    }
}
