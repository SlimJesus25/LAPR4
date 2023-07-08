package eapli.elearning.courseenrollmentmanagement.domain;

import eapli.framework.domain.model.ValueObject;


public enum StudentEnrollmentState implements ValueObject {
    CANDIDATE,
    ACCEPTED,
    REJECTED,
    ENROLLED
}
