package eapli.elearning.lectureparticipantmanagement.domain;

import eapli.elearning.lectureparticipantmanagement.dto.LectureParticipantDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="LectureParticipant")
public class LectureParticipant implements AggregateRoot<Integer>, DTOable<LectureParticipantDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id", nullable = false, length = 10)
    private Integer lectureParticipantID;
    //n sera preciso ter aqui um atributo para user?
    @Override
    public LectureParticipantDTO toDTO() {
        return new LectureParticipantDTO(lectureParticipantID);
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        LectureParticipant that = (LectureParticipant) other;
        return Objects.equals(lectureParticipantID, that.lectureParticipantID);
    }
    @Override
    public Integer identity() {
        return lectureParticipantID;
    }

}
