package eapli.elearning.examsectionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ExamSectionTextualDescription implements ValueObject {

    private String textualDescription;

    public ExamSectionTextualDescription(String textualDescription) {
        this.textualDescription = textualDescription;
    }

    protected ExamSectionTextualDescription() {
    }

    public String description() {
        return textualDescription;
    }
}
