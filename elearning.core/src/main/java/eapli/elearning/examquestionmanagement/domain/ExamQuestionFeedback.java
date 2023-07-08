package eapli.elearning.examquestionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ExamQuestionFeedback implements ValueObject {

    @Lob
    private String questionFeedback;

    public ExamQuestionFeedback(String questionNumber) {
        this.questionFeedback = questionNumber;
    }

    protected ExamQuestionFeedback() {
    }

    public String questionFeedback() {
        return questionFeedback;
    }
}
