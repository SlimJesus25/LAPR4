package eapli.elearning.lecturemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

public enum LectureWeekDay implements ValueObject {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday,
}
