package eapli.elearning.lecturemanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.framework.domain.services.DomainService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DomainService
public class CollisionLectureAndLecturesCourseService {
    private final LectureRepository repo= PersistenceContext.repositories().lectures();
    public boolean isCollisionLectureAndLecturesCourse(Course course, LocalTime startHours, LocalTime endHours, LocalDate startDate, LocalDate finalDate, String selectedWeekDay) {
        ArrayList<Lecture> lecturesOfCourse = getLecturesOfCourse(course);
        for(Lecture lecture:lecturesOfCourse){
            if(isCollidingLecture(lecture,startHours,endHours,startDate,finalDate,selectedWeekDay)) return true;
        }
        return false;
    }

    private boolean isCollidingLecture(Lecture lecture, LocalTime startHours, LocalTime endHours, LocalDate startDate, LocalDate finalDate, String selectedWeekDay) {
        LectureDTO lectureDTO=lecture.toDTO();
        if(collidingWeekDay(lectureDTO.getLectureWeekDay(),selectedWeekDay)){
            if(collidingDate(lectureDTO,startDate,finalDate)){
                if(collidingHours(lectureDTO,startHours,endHours)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean collidingWeekDay(LectureWeekDay lectureWeekDay, String selectedWeekDay) {
        return lectureWeekDay.toString().equalsIgnoreCase(selectedWeekDay);
    }

    private boolean collidingHours(LectureDTO lectureDTO, LocalTime startHours, LocalTime endHours) {
        LocalTime initialTimeLecture = lectureDTO.getLectureInitialTime().initialTime();
        LocalTime finalTimeLecture = lectureDTO.getLectureFinalTime().finalTime();
        return !(initialTimeLecture.isAfter(endHours) || finalTimeLecture.isBefore(startHours));

    }

    private boolean collidingDate(LectureDTO lectureDTO, LocalDate startDate, LocalDate finalDate) {
        LocalDate initialDateLecture= lectureDTO.getLectureInitialDate().initialDate();
        LocalDate finalDateLecture= lectureDTO.getLectureFinalDate().finalDate();
        return !(initialDateLecture.isAfter(finalDate) || finalDateLecture.isBefore(startDate));
    }

    private ArrayList<Lecture> getLecturesOfCourse(Course course) {
        Iterable<Lecture> lectureIterable=repo.getLecturesOfCourse(course);
        return StreamSupport.stream(lectureIterable.spliterator(), false).collect(Collectors.toCollection(ArrayList::new));
    }
}
