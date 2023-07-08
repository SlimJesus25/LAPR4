package eapli.elearning.lecturemanagement.application;

import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.domain.UtilsLectureValidationService;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.application.ApplicationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@ApplicationService
public class UtilsLectureService {
    private final UtilsLectureValidationService utilsLectureValidationService = new UtilsLectureValidationService();
    public boolean isValidDate(String dateString) {
        return utilsLectureValidationService.isValidDate(dateString);
    }
    public boolean isValidDate(String dateString, String format){
        return utilsLectureValidationService.isValidDate(dateString, format);
    }

    public boolean isInInterval(LocalDate initialDate, LocalDate finalDate, LectureWeekDay chosenWeekDay) {
        return utilsLectureValidationService.isInInterval(initialDate, finalDate, chosenWeekDay);
    }
    public LocalTime parseTimeString(String timeString) {
        return utilsLectureValidationService.parseTimeString(timeString);
    }
    public boolean selectedIntervalIsInsideLectureInterval(LectureDTO lecture, LocalTime end, LocalTime start) {
        return lecture.getLectureInitialTime().initialTime().isAfter(start)&&lecture.getLectureFinalTime().finalTime().isBefore(end);
    }
}
