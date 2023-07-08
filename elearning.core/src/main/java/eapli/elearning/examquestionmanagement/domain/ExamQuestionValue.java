package eapli.elearning.examquestionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

public class ExamQuestionValue implements ValueObject {

    private Integer value;

    public ExamQuestionValue(Integer value) {
        this.value = value;
    }

    public ExamQuestionValue() {
    }

    public Integer value() {
        return value;
    }
}
