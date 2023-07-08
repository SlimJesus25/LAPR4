package eapli.elearning.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExamTitle implements ValueObject {
    private String title;

    public ExamTitle(String title) {
        Preconditions.noneNull(title);
        this.title = title;
    }

    public ExamTitle() {
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamTitle that = (ExamTitle) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "ExamTitle{" +
                "examTitle='" + title + '\'' +
                '}';
    }
}
