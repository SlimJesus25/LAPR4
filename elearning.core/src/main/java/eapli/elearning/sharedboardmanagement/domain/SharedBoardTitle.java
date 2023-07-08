package eapli.elearning.sharedboardmanagement.domain;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class SharedBoardTitle implements ValueObject {
    private String title;

    public SharedBoardTitle(String title) {
        Preconditions.noneNull(title);
        verifyTitle(title);
        this.title = title;
    }

    private void verifyTitle(String title){
        if(title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null!");
        }
    }

    public SharedBoardTitle() {
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedBoardTitle that = (SharedBoardTitle) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "SharedBoardTitle{" +
                "sharedBoardTitle='" + title + '\'' +
                '}';
    }
}
