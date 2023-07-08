package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.domain.services.DomainService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DomainService
public class UtilsLectureValidationService {

    public boolean isValidDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
            if(date.isBefore(LocalDate.now())) return false;
            return date.format(formatter).equals(dateString);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public boolean isValidDate(String dateString, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate date = LocalDate.parse(dateString, formatter);
            if(date.isBefore(LocalDate.now())) return false;
            return date.format(formatter).equals(dateString);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public boolean isInInterval(LocalDate initialDate, LocalDate finalDate, LectureWeekDay chosenWeekDay) {
        LocalDate date=initialDate;
        while(date.isBefore(finalDate)||date.equals(finalDate)){
            String dayOfWeekString = date.getDayOfWeek().toString();
            if(dayOfWeekString.toUpperCase().equals(chosenWeekDay.toString().toUpperCase()))
                return true;
            date=date.plusDays(1);
        }
        return false;
    }

    public LocalTime parseTimeString(String timeString) {
        if(!timeString.contains(":")) return null;
        List<String> splitString= Arrays.stream(timeString.split(":")).collect(Collectors.toList());
        if(splitString.size()!=2) return null;
        if (!isInteger(splitString.get(0)) || !isInteger(splitString.get(1)))return null;
        if(Integer.parseInt(splitString.get(0))<7||Integer.parseInt(splitString.get(0))>23) return null;
        if(Integer.parseInt(splitString.get(1))<0||Integer.parseInt(splitString.get(1))>59) return null;
        if(Integer.parseInt(splitString.get(0))==23&&Integer.parseInt(splitString.get(1))>0) return null;
        return LocalTime.of(Integer.parseInt(splitString.get(0)),Integer.parseInt(splitString.get(1)));
    }
    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
