package eapli.elearning.lecturemanagement.persistance;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.ArrayList;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface LectureRepository extends DomainRepository<Integer, Lecture> {
    public Iterable<Lecture> listLecturesByCourse(String courseCode);
    public Iterable<Lecture> listLecturesByTeacher(String teacherAcronym);
    public Lecture updateLecture(Lecture lecture, LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, Teacher teacher, Course course);

    public Lecture findLectureByID(int parseInt);

    Iterable<Lecture> getLecturesOfCourse(Course selectedCourse);

}
