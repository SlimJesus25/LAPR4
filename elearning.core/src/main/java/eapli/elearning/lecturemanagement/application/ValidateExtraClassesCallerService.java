package eapli.elearning.lecturemanagement.application;

import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.framework.application.ApplicationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ApplicationService
public class ValidateExtraClassesCallerService {
    private final ValidateExtraClassesService validateExtraClassesService = new ValidateExtraClassesService();
    public boolean allTeacherExtraClassesValidated(List<ExtraLectureDTO> teacherExtraClasses, LectureInitialTime startHours, LectureFinalTime endHours, LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay selectedWeekDay) {
        return validateExtraClassesService.allTeacherExtraClassesValidated(teacherExtraClasses, startHours, endHours, startDate, finalDate, selectedWeekDay);
    }
    public boolean allTeacherExtraClassesValidated(List<ExtraLectureDTO> teacherExtraClasses, LocalTime startHours, LocalTime endHours, LocalDate date) {
        return validateExtraClassesService.allTeacherExtraClassesValidated(teacherExtraClasses, startHours, endHours, date);
    }
}
