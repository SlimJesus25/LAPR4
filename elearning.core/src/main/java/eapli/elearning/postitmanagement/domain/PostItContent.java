package eapli.elearning.postitmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Embeddable
public class PostItContent implements ValueObject {
    private String contentP;

    public PostItContent(String content) {
        Preconditions.nonEmpty(content);
        this.contentP = content;
    }

    protected PostItContent() {
    }

    public String content() {
        return contentP;
    }
}
