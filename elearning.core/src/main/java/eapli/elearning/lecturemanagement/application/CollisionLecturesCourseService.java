package eapli.elearning.lecturemanagement.application;

import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.lecturemanagement.domain.CollisionLectureAndLecturesCourseService;
import eapli.framework.application.ApplicationService;

import java.time.LocalDate;
import java.time.LocalTime;

@ApplicationService
public class CollisionLecturesCourseService {
    CollisionLectureAndLecturesCourseService service = new CollisionLectureAndLecturesCourseService();
    FindCourseByCourseCodeService findCourseByCourseCodeService = new FindCourseByCourseCodeService();
    public boolean isCollisionLectureAndLecturesCourse(CourseDTO selectedCourse, LocalTime startHours, LocalTime endHours, LocalDate startDate, LocalDate finalDate, String selectedWeekDay) {
        Course course= findCourseByCourseCodeService.findCourseByCourseCode(selectedCourse.identity());
        return service.isCollisionLectureAndLecturesCourse(course,startHours,endHours,startDate,finalDate,selectedWeekDay);
    }
}
