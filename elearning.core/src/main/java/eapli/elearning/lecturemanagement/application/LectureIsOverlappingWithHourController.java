package eapli.elearning.lecturemanagement.application;

import eapli.elearning.lecturemanagement.dto.LectureDTO;

import java.time.LocalTime;

public class LectureIsOverlappingWithHourController {
    public LocalTime lectureIsOverlappingWithHour(LocalTime time, LectureDTO lecture) {
            LocalTime timeSurplus= LocalTime.of(time.getHour()+1,0);
            if(lecture.getLectureInitialTime().initialTime().isAfter(time) && lecture.getLectureInitialTime().initialTime().isBefore(timeSurplus))
                return lecture.getLectureInitialTime().initialTime();
            else if(lecture.getLectureFinalTime().finalTime().isAfter(time) && lecture.getLectureFinalTime().finalTime().isBefore(timeSurplus))
                return lecture.getLectureFinalTime().finalTime();
            return null;

    }
}
