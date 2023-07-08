package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.framework.domain.services.DomainService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
@DomainService
public class ValidateExtraClassesService {
    public boolean allTeacherExtraClassesValidated(List<ExtraLectureDTO> teacherExtraClasses, LectureInitialTime startHours, LectureFinalTime endHours, LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay selectedWeekDay) {
        if(teacherExtraClasses.isEmpty())
            return true;
        for(ExtraLectureDTO extraLectureDTO : teacherExtraClasses) {
           if (!validateExtraLecture(extraLectureDTO,startHours, endHours, startDate, finalDate, selectedWeekDay))
               return false;
       }
        return true;
    }
    public boolean allTeacherExtraClassesValidated(List<ExtraLectureDTO> teacherExtraClasses, LocalTime startHours, LocalTime endHours, LocalDate date) {
        if(teacherExtraClasses.isEmpty())
            return true;
        for(ExtraLectureDTO extraLectureDTO : teacherExtraClasses) {
            if (!validateExtraLecture(extraLectureDTO,startHours, endHours, date))
                return false;
        }
        return true;
    }

    private boolean validateExtraLecture(ExtraLectureDTO extraLectureDTO, LocalTime startHours, LocalTime endHours, LocalDate date) {
        if(extraLectureDTO.getDate().equals(date)){
            return !isInTimeInterval(extraLectureDTO.getTimeInitial(), extraLectureDTO.getTimeFinal(), startHours, endHours);
        }
        return true;
    }

    private boolean validateExtraLecture(ExtraLectureDTO extraLectureDTO, LectureInitialTime startHours, LectureFinalTime endHours, LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay selectedWeekDay) {
            if(isInDateInterval(extraLectureDTO.getDate(),startDate.initialDate(),finalDate.finalDate())){
                if(isDayInDayWeek(extraLectureDTO.getDate(),selectedWeekDay)){
                    return !isInTimeInterval(extraLectureDTO.getTimeInitial(), extraLectureDTO.getTimeFinal(), startHours.initialTime(), endHours.finalTime());
                }
            }
        return true;
    }

    private boolean isInTimeInterval(LocalTime timeInitial, LocalTime timeFinal, LocalTime initialTime, LocalTime finalTime) {
        return !timeInitial.isAfter(finalTime) && !timeFinal.isBefore(initialTime);
    }

    private boolean isDayInDayWeek(LocalDate date, LectureWeekDay selectedWeekDay) {
        return date.getDayOfWeek().name().equals(selectedWeekDay.name().toUpperCase(Locale.ROOT));
    }

    private boolean isInDateInterval(LocalDate date, LocalDate initialDate, LocalDate finalDate) {
        return (date.isAfter(initialDate) && date.isBefore(finalDate))|| date.equals(initialDate) || date.equals(finalDate);
    }

    public void eliminateExtraClasses(List<ExtraLecture> teacherExtraClasses, LectureInitialTime startHours, LectureFinalTime endHours, LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay selectedWeekDay) {
        // query to delete extra class in the database
    }
}
