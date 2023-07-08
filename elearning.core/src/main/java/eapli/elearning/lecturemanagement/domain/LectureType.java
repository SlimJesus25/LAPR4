package eapli.elearning.lecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

public enum LectureType implements ValueObject {
    T,
    TP,
    PL
}
