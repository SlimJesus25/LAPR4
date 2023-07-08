package eapli.elearning.lectureparticipantmanagement.domain;

import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.framework.domain.model.DomainFactory;

public class LectureParticipantsBuilder implements DomainFactory<LectureParticipant> {
    //Vazio por ter duvidas
    @Override
    public LectureParticipant build() {
        //final Lecture lecture = buildOrThrow();
        //thisLecture = null;
        final LectureParticipant lectureParticipant = null;
        return lectureParticipant;
    }
    /*private Lecture buildOrThrow(){
        if (thisLecture != null)
            return thisLecture;
        else if (lectureInitalTime != null && lectureFinalTime != null && lectureInitialDate != null
                && lectureFinalDate != null && lectureWeekDay != null && lectureType != null){
            //thisLecture = new Lecture(lectureInitalTime,lectureFinalTime,lectureInitialDate
            // ,lectureFinalDate,lectureWeekDay,lectureType);
            return thisLecture;
        } else throw new IllegalStateException();
    }*/
}
