package eapli.elearning.teacherschedulemanagement.domain;

import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.teachermanagement.domain.*;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class TeacherScheduleBuilder implements DomainFactory<TeacherSchedule> {

    private TeacherSchedule theTeacherSchedule;
    private List<Lecture> lectures;

    public TeacherScheduleBuilder withLectures(List<Lecture> lectures) {
        this.lectures= lectures;
        return this;
    }
    @Override
    public TeacherSchedule build() {
        final TeacherSchedule teacherSchedule = buildOrThrow();
        theTeacherSchedule = null;
        return teacherSchedule;
    }
    private TeacherSchedule buildOrThrow(){
        if (theTeacherSchedule != null)
            return theTeacherSchedule;
        else if (lectures != null){
            theTeacherSchedule = new TeacherSchedule(lectures);
            return theTeacherSchedule;
        } else throw new IllegalStateException();
    }

}
