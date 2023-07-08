package eapli.elearning.teacherschedulemanagement.dto;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public class TeacherScheduleDTO implements Serializable {
    private Integer teacherScheduleID;
    public TeacherScheduleDTO(Integer teacherScheduleID) {
        Preconditions.noneNull(teacherScheduleID);
        this.teacherScheduleID=teacherScheduleID;
    }

}
