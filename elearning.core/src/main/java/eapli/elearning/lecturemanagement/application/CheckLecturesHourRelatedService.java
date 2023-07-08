package eapli.elearning.lecturemanagement.application;

import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.application.ApplicationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ApplicationService
public class CheckLecturesHourRelatedService {
    private final LectureInDayAndHourService lectureInDayAndHourService = new LectureInDayAndHourService();

    public List<LectureDTO> lecturesInThisWeekDay(List<LectureDTO> lecturesRelevantToHour, LectureWeekDay day) {
        return lectureInDayAndHourService.lecturesInThisWeekDay(lecturesRelevantToHour, day);
    }
    public List<LectureDTO> lecturesInThisWeekDay(List<LectureDTO> scheduleList, LocalDate date) {
        return lectureInDayAndHourService.lecturesInThisWeekDay(scheduleList, date);
    }
    public boolean lecturesInThisHour(List<LectureDTO> lecturesInThisDay, LocalTime startHours, LocalTime endHours) {
        return lectureInDayAndHourService.lecturesInThisHour(lecturesInThisDay, startHours, endHours);
    }
}
