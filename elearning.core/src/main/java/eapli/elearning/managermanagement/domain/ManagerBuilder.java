package eapli.elearning.managermanagement.domain;

import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.framework.domain.model.DomainFactory;

public class ManagerBuilder implements DomainFactory<Manager> {
    //Vazio por ter duvidas
    @Override
    public Manager build() {
        //final Manager manager = buildOrThrow();
        //thisLecture = null;
        Manager manager = null;
        return manager;
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
