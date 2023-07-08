package eapli.elearning.examquestionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ExamQuestionSolution implements ValueObject {

    @Lob
    private String solution;

    public ExamQuestionSolution(String solution) {
        this.solution = solution;
    }

    protected ExamQuestionSolution() {
    }

    public String solution() {
        return solution;
    }
}
