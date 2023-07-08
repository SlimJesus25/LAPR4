package eapli.elearning.lecturemanagement.application;

import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.domain.ListTeacherAvailableWeekDaysService;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.application.ApplicationService;

import java.util.List;

@ApplicationService
public class TeacherAvailableWeekDaysService {
    private final ListTeacherAvailableWeekDaysService listTeacherAvailableWeekDaysService = new ListTeacherAvailableWeekDaysService();
    public Iterable<LectureWeekDay> listTeacherAvailableWeekDays(List<LectureDTO> lectures) {
        return listTeacherAvailableWeekDaysService.listTeacherAvailableWeekDays(lectures);
    }
}
