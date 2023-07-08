package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

public enum UserPermission implements ValueObject {
    READ,
    WRITE,
    ADMIN
}
