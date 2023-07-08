package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

public enum UserStatus implements ValueObject {
    GUEST,
    PARTICIPANT,
    OWNER
}
