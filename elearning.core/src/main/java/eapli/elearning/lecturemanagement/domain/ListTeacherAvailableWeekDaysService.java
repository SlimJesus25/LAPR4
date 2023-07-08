package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.lecturemanagement.domain.LectureFinalTime;
import eapli.elearning.lecturemanagement.domain.LectureInitialTime;
import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.domain.services.DomainService;
import org.springframework.data.util.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@DomainService
public class ListTeacherAvailableWeekDaysService {
    public Iterable<LectureWeekDay> listTeacherAvailableWeekDays(List<LectureDTO> lectures){
        List<Pair<List<Pair<LectureInitialTime,LectureFinalTime>>,LectureWeekDay>> weekDayTimes= new ArrayList<>();
        for (LectureWeekDay weekDay : LectureWeekDay.values()){
            List<LectureDTO> lecturesInWeekDay = getLecturesOfWeekDay(weekDay,lectures);
            List<Pair<LectureInitialTime,LectureFinalTime>> thisDayAvailableTimes=getAvailableWeekDayTimes(lecturesInWeekDay);
            if(checkIfTimeIsAvailable(thisDayAvailableTimes)){
                weekDayTimes.add(Pair.of(thisDayAvailableTimes,weekDay));
            }
        }
        return weekDayTimes.stream().map(Pair::getSecond).collect(Collectors.toList());

    }

    private boolean checkIfTimeIsAvailable(List<Pair<LectureInitialTime, LectureFinalTime>> availableWeekDayTime) {
        return availableWeekDayTime.size() != 0;
    }

    private List<Pair<LectureInitialTime, LectureFinalTime>> getAvailableWeekDayTimes(List<LectureDTO> lecturesInWeekDay) {
        List<Pair<LocalTime,LocalTime>> availableWeekDayTimes= new ArrayList<>();
        availableWeekDayTimes.add(Pair.of(LocalTime.of(7, 00),LocalTime.of(23, 00)));
        for(LectureDTO lecture: lecturesInWeekDay){
            updateAvailableWeekDayTimes(lecture,availableWeekDayTimes);
        }
        return availableWeekDayTimes.stream().map(pair -> Pair.of(new LectureInitialTime(pair.getFirst()),new LectureFinalTime(pair.getSecond()))).collect(Collectors.toList());
    }

    private void updateAvailableWeekDayTimes(LectureDTO lecture, List<Pair<LocalTime, LocalTime>> availableWeekDayTimes) {
        List<Pair<LocalTime, LocalTime>> weekDayTimesCopy = new ArrayList<>(availableWeekDayTimes);
        for(Pair<LocalTime,LocalTime> availableWeekDayTime: weekDayTimesCopy){
            if(lecture.getLectureInitialTime().initialTime().isAfter(availableWeekDayTime.getFirst()) && lecture.getLectureFinalTime().finalTime().isBefore(availableWeekDayTime.getSecond())){
                updateAvailableWeekDayTimesWithLectureInsideInterval(lecture,availableWeekDayTimes,availableWeekDayTime);
            }
            else if(lecture.getLectureInitialTime().initialTime().equals(availableWeekDayTime.getFirst()) && lecture.getLectureFinalTime().finalTime().equals(availableWeekDayTime.getSecond())){
                updateAvailableWeekDayTimesWithLectureEqualsInterval(lecture,availableWeekDayTimes,availableWeekDayTime);
            }
            else if(lecture.getLectureInitialTime().initialTime().equals(availableWeekDayTime.getFirst()) && lecture.getLectureFinalTime().finalTime().isBefore(availableWeekDayTime.getSecond())){
                updateAvailableWeekDayTimesWithLectureEqualsInitial(lecture,availableWeekDayTimes,availableWeekDayTime);
            }
            else if(lecture.getLectureInitialTime().initialTime().isAfter(availableWeekDayTime.getFirst()) && lecture.getLectureFinalTime().finalTime().equals(availableWeekDayTime.getSecond())){
                updateAvailableWeekDayTimesWithLectureEqualsFinal(lecture,availableWeekDayTimes,availableWeekDayTime);
            }
        }
    }

    private void updateAvailableWeekDayTimesWithLectureEqualsFinal(LectureDTO lecture, List<Pair<LocalTime, LocalTime>> availableWeekDayTimes, Pair<LocalTime, LocalTime> availableWeekDayTime) {
        Pair<LocalTime,LocalTime> availableWeekDay2= Pair.of(lecture.getLectureFinalTime().finalTime(),availableWeekDayTime.getSecond());
        availableWeekDayTimes.add(availableWeekDay2);
        availableWeekDayTimes.remove(availableWeekDayTime);
    }

    private void updateAvailableWeekDayTimesWithLectureEqualsInitial(LectureDTO lecture, List<Pair<LocalTime, LocalTime>> availableWeekDayTimes, Pair<LocalTime, LocalTime> availableWeekDayTime) {
        Pair<LocalTime,LocalTime> availableWeekDay1= Pair.of(availableWeekDayTime.getFirst(),lecture.getLectureInitialTime().initialTime());
        availableWeekDayTimes.add(availableWeekDay1);
        availableWeekDayTimes.remove(availableWeekDayTime);
    }

    private void updateAvailableWeekDayTimesWithLectureEqualsInterval(LectureDTO lecture, List<Pair<LocalTime, LocalTime>> availableWeekDayTimes, Pair<LocalTime, LocalTime> availableWeekDayTime) {
        availableWeekDayTimes.remove(availableWeekDayTime);
    }

    private void updateAvailableWeekDayTimesWithLectureInsideInterval(LectureDTO lecture, List<Pair<LocalTime, LocalTime>> availableWeekDayTimes, Pair<LocalTime, LocalTime> availableWeekDayTime) {
        Pair<LocalTime,LocalTime> availableWeekDay1= Pair.of(availableWeekDayTime.getFirst(),lecture.getLectureInitialTime().initialTime());
        Pair<LocalTime,LocalTime> availableWeekDay2= Pair.of(lecture.getLectureFinalTime().finalTime(),availableWeekDayTime.getSecond());
        availableWeekDayTimes.remove(availableWeekDayTime);
        availableWeekDayTimes.add(availableWeekDay1);
        availableWeekDayTimes.add(availableWeekDay2);
    }

    private List<LectureDTO> getLecturesOfWeekDay(LectureWeekDay weekDay,List<LectureDTO> lectures) {
        return lectures.stream().filter(a -> a.getLectureWeekDay().equals(weekDay)).collect(Collectors.toList());
    }
}
