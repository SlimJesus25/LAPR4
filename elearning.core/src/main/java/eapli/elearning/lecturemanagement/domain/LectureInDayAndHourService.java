package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.lecturemanagement.application.LectureIsOverlappingWithHourController;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.framework.domain.services.DomainService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@DomainService
public class LectureInDayAndHourService {
    LectureIsOverlappingWithHourController lectureIsOverlappingWithHour=new LectureIsOverlappingWithHourController();
    public List<LectureDTO> getLecturesRelevantToHour(LocalTime time, Iterable<LectureDTO> visitee) {
        List<LectureDTO> lecturesRelevantToHour= new ArrayList<>();
        for (LectureDTO lecture:visitee) {
            if(lecture.getLectureInitialTime().initialTime().equals(time) || lecture.getLectureFinalTime().finalTime().equals(time) || (lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time)))
                lecturesRelevantToHour.add(lecture);
            if(time.getHour()!=23 && !lecturesRelevantToHour.contains(lecture))
                if(lectureIsOverlappingWithHour.lectureIsOverlappingWithHour(time,lecture)!=null)
                    lecturesRelevantToHour.add(lecture);
        }
        return lecturesRelevantToHour;
    }
    public LectureDTO lectureInThisWeekDay(List<LectureDTO> lecturesRelevantToHour, LectureWeekDay day) {
        for(LectureDTO lecture:lecturesRelevantToHour){
            if(lecture.getLectureWeekDay().equals(day))
                return lecture;
        }
        return null;
    }
    public List<LectureDTO> lecturesInThisWeekDay(List<LectureDTO> lecturesRelevantToHour, LectureWeekDay day) {
        List<LectureDTO> lecturesInThisDay= new ArrayList<>();
        for(LectureDTO lecture:lecturesRelevantToHour){
            if(lecture.getLectureWeekDay().equals(day))
                lecturesInThisDay.add(lecture);
        }
        return lecturesInThisDay;
    }
    public List<LectureDTO> lecturesInThisWeekDay(List<LectureDTO> scheduleList, LocalDate date) {
        List<LectureDTO> lecturesInThisDay= new ArrayList<>();
        for(LectureDTO lecture:scheduleList){
            if(lectureHasThisWeekDate(lecture,date))
                lecturesInThisDay.add(lecture);
        }
        return lecturesInThisDay;
    }

    private boolean lectureHasThisWeekDate(LectureDTO lecture, LocalDate date) {
        if(lecture.getLectureInitialDate().initialDate().isAfter(date)||lecture.getLectureFinalDate().finalDate().isBefore(date))
            return false;
        return lecture.getLectureWeekDay().toString().equalsIgnoreCase(date.getDayOfWeek().toString());
    }
    private boolean isLectureInThisDay(LectureDTO lecture, LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate) {
        return !(lecture.getLectureInitialDate().initialDate().isAfter(updatedFinalDate.finalDate()) || lecture.getLectureFinalDate().finalDate().isBefore(updatedInitialDate.initialDate()));
    }
    public LectureDTO lecturesInThisWeekDayAndHour(List<LectureDTO> lectures, LectureWeekDay day, LocalTime time) {
        for(LectureDTO lecture:lectures){
            if(lecture.getLectureWeekDay().equals(day) && (isLectureOccurringInHour(lecture,time)))
                return lecture;
        }
        return null;
    }
    public boolean lecturesInThisHour(List<LectureDTO> lecturesInThisDay, LocalTime startHours, LocalTime endHours) {
        if(lecturesInThisDay.isEmpty())
            return false;
        for(LectureDTO lecture:lecturesInThisDay){
            if(!(lecture.getLectureInitialTime().initialTime().isAfter(endHours) || lecture.getLectureFinalTime().finalTime().isBefore(startHours)))
                return true;
        }
        return false;
    }
    private boolean isLectureOccurringInHour(LectureDTO lecture, LocalTime time) {
        if(lecture.getLectureInitialTime().initialTime().equals(time))
            return true;
        if(lecture.getLectureFinalTime().finalTime().equals(time))
            return true;
        return lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time);
    }

    public List<LectureDTO> lecturesStartingOrEndingInInterval(List<LectureDTO> lectures, LocalTime initialTime, LocalTime finalTime) {
       List<LectureDTO> lecturesStartingOrEndingInInterval= new ArrayList<>();
        for (LectureDTO lecture:lectures) {
            if(lecture.getLectureInitialTime().initialTime().isAfter(initialTime) && lecture.getLectureInitialTime().initialTime().isBefore(finalTime))
                lecturesStartingOrEndingInInterval.add(lecture);
            if(lecture.getLectureFinalTime().finalTime().isAfter(initialTime) && lecture.getLectureFinalTime().finalTime().isBefore(finalTime))
                lecturesStartingOrEndingInInterval.add(lecture);
        }
        return lecturesStartingOrEndingInInterval;
    }

    public boolean isLectureInThisHour(LectureDTO lecture, LectureInitialTime startHours, LectureFinalTime endHours) {
        if(lecture==null)
            return false;
        return !(lecture.getLectureInitialTime().initialTime().isAfter(endHours.finalTime()) || lecture.getLectureFinalTime().finalTime().isBefore(startHours.initialTime()));
    }
    public boolean areLecturesInDateHourAndWeekDay(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, List<LectureDTO> schedule) {
        for(LectureDTO lecture:schedule){
            if(lecture.getLectureWeekDay().equals(updatedWeekDay))
                if(isLectureInThisDay(lecture,updatedInitialDate,updatedFinalDate))
                    if(isLectureInThisHour(lecture,updatedInitialTime,updatedFinalTime))
                        return true;
        }
        return false;
    }

    public boolean isMeetingInDateHourAndWeekDay(LocalTime initialTime, LocalTime finalTime, LocalDate initialDate, LocalDate finalDate, String weekDay, Meeting meeting) {
        if(isMeetingInThisWeekDay(meeting,weekDay))
            if(isMeetingInThisDay(meeting,initialDate,finalDate))
                return isMeetingInThisHour(meeting, initialTime, finalTime);
        return false;
    }

    private boolean isMeetingInThisHour(Meeting meeting, LocalTime initialTime, LocalTime finalTime) {
        LocalTime initialTimeMeeting = meeting.toDTO().getMeetingDateTime().toLocalTime();
        LocalTime finalTimeMeeting = meeting.toDTO().getMeetingDateTime().toLocalTime().plus(meeting.toDTO().getMeetingDuration(), ChronoUnit.MINUTES);
        return !(initialTimeMeeting.isAfter(finalTime) || finalTimeMeeting.isBefore(initialTime));
    }

    private boolean isMeetingInThisDay(Meeting meeting, LocalDate initialDate, LocalDate finalDate) {
        LocalDate date = meeting.toDTO().getMeetingDateTime().toLocalDate();
        return !(date.isBefore(initialDate) || date.isAfter(finalDate));
    }
    private boolean isMeetingInThisWeekDay(Meeting meeting, String weekDay) {
        return getMeetingWeekDay(meeting).name().equalsIgnoreCase(weekDay);
    }
    private DayOfWeek getMeetingWeekDay(Meeting meeting) {
        return meeting.toDTO().getMeetingDateTime().getDayOfWeek();
    }
}

