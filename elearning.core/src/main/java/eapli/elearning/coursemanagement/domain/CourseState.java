package eapli.elearning.coursemanagement.domain;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

public enum CourseState {
    OPEN_WITH_ENROLLMENTS,
    OPEN_WITHOUT_ENROLLMENTS,
    OPEN,
    CLOSE;
}

