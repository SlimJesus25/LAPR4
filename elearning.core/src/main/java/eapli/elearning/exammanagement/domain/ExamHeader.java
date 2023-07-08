package eapli.elearning.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ExamHeader implements ValueObject {

    private String header;

    public ExamHeader(String header) {
        Preconditions.noneNull(header);
        this.header = header;
    }

    protected ExamHeader() {
    }

    public String header() {
        return header;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamHeader that = (ExamHeader) o;
        return Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header);
    }

    @Override
    public String toString() {
        return "ExamHeader{" +
                "examHeader='" + header + '\'' +
                '}';
    }
}
