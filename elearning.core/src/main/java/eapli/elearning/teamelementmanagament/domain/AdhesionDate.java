package eapli.elearning.teamelementmanagament.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.*;
import java.time.LocalDate;
@Embeddable
public class AdhesionDate implements ValueObject {

    @Column(name="adhesionDate", nullable=false)
    private LocalDate adhesionDate;

    public AdhesionDate(LocalDate adhesionDate) {
        this.adhesionDate = adhesionDate;
    }
    protected AdhesionDate(){}

    public LocalDate adhesionDate() {
        return adhesionDate;
    }
}