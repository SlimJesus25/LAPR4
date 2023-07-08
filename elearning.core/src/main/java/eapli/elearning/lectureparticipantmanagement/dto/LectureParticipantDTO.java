package eapli.elearning.lectureparticipantmanagement.dto;
import java.io.Serializable;

public class LectureParticipantDTO implements Serializable {
    private Integer lectureParticipantID;

    public LectureParticipantDTO(Integer lectureParticipantID) {
        this.lectureParticipantID = lectureParticipantID;
    }
}