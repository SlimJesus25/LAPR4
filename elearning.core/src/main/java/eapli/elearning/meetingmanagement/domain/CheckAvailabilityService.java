package eapli.elearning.meetingmanagement.domain;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@DomainService
public class CheckAvailabilityService {
    private final LectureInDayAndHourService lectureInDayAndHourService = new LectureInDayAndHourService();
    private final MeetingParticipationRepository meetingParticipationRepo = PersistenceContext.repositories().meetingParticipations();
    private final StudentRepository studentRepo = PersistenceContext.repositories().students();
    private final TeacherRepository teacherRepo = PersistenceContext.repositories().teachers();
    private final CourseEnrollmentRepository enrollmentsRepo  = PersistenceContext.repositories().courseEnrollments();
    private final LectureRepository lectureRepo = PersistenceContext.repositories().lectures();
    private final ExtraLectureRepository extraLectureRepo = PersistenceContext.repositories().extraLectures();

    /**
     * Verifies the availability of each system user on users.
     * @param meetingDateNTime date and time of the meeting.
     * @param users users to check availabiility.
     * @param meetingDuration duration of the meeting in minutes.
     * @return a map with the respective system user from users and their availability (true or false).
     */
    public Map<SystemUser, Boolean> checkAvailability(LocalDateTime meetingDateNTime, List<SystemUser> users, Integer meetingDuration){
        Map<SystemUser, Boolean> availability = new HashMap<>();
        for(SystemUser user : users){
            availability.put(user, checkSystemUserAvailability(user, meetingDateNTime, meetingDuration));
        }
        return availability;
    }

    private boolean checkSystemUserAvailability(SystemUser user, LocalDateTime meetingDateNTime, Integer meetingDuration){
        LocalTime startTime = meetingDateNTime.toLocalTime()
                , finalTime = meetingDateNTime.plus(meetingDuration, ChronoUnit.MINUTES).toLocalTime();
        LocalDate date = meetingDateNTime.toLocalDate();

        Iterable<Lecture> lectures = new ArrayList<>();
        Iterable<ExtraLecture> extraLectures = new ArrayList<>();

        if(user.roleTypes().contains(ElearningRoles.STUDENT)){
            Student ref = studentRepo.findStudentByUserName(user.username());

            Iterable<Course> enrolledCourses = enrollmentsRepo.
                    coursesThatStudentIsEnrolledOn(ref.identity().studentMechanograpicalNumber());

            for(Course c : enrolledCourses){
                lectures = lectureRepo.listLecturesByCourse(c.identity().code());
            }

        }else if(user.roleTypes().contains(ElearningRoles.TEACHER)){
            Teacher ref = teacherRepo.findTeacherByUserName(user.username());
            lectures = lectureRepo.listLecturesByTeacher(ref.identity().acronym());
            extraLectures = extraLectureRepo.listAllExtraLecturesOfTeacher(ref.identity().acronym());
        }

        Iterable<Meeting> meetings = meetingParticipationRepo.listFutureMeetingsByUser(user);

        return checkLectureAvailability(lectures, startTime, finalTime, date)
                && checkExtraLectureAvailability(extraLectures, startTime, finalTime, date)
                && checkMeetingAvailability(meetings, startTime, finalTime, date);
    }

    private boolean checkMeetingAvailability(Iterable<Meeting> meetings, LocalTime meetingInitalHour,
                                             LocalTime meetingFinalHour, LocalDate meetingDate){
        for(Meeting m : meetings) {
            if(!m.dateNTime().dateNTime().toLocalDate().isEqual(meetingDate)){
                continue;
            }
            if(isIntersect(m.dateNTime().dateNTime().toLocalTime(), m.dateNTime().dateNTime().
                            toLocalTime().plus(m.duration().duration(), ChronoUnit.MINUTES), meetingInitalHour,
                    meetingFinalHour)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLectureAvailability(Iterable<Lecture> lectures, LocalTime meetingInitalHour,
                                             LocalTime meetingFinalHour, LocalDate meetingDate){
        int dayOfTheWeek = meetingDate.getDayOfWeek().getValue() - 1;
        for(Lecture l : lectures){

            // Verifica se o dia da semana é o mesmo.
            if(l.weekDay().ordinal() != dayOfTheWeek) {
                continue;
            }

            // Na ocasião do dia da semana ser o mesmo, é preciso verificar se há colisões de horas.
            if(isIntersect(l.initialTime().initialTime(), l.finalTime().finalTime(), meetingInitalHour, meetingFinalHour)){
                return false;
            }
        }
        return true;
    }

    private boolean checkExtraLectureAvailability(Iterable<ExtraLecture> extraLectures, LocalTime initialHour,
                                                  LocalTime finalHour, LocalDate meetingDate){
        for(ExtraLecture el : extraLectures){
            if(!el.date().date().isEqual(meetingDate)){
                continue;
            }
            if(isIntersect(el.initialTime().initialTime(), el.finalTime().finalTime(), initialHour, finalHour)){
                return false;
            }
        }
        return true;
    }

    private boolean isIntersect(LocalTime start1, LocalTime final1, LocalTime start2, LocalTime final2){
        return start1.isBefore(final2) && final1.isAfter(start2);
    }
    public boolean checkLectureAvailability(LocalTime initialTime, LocalTime finalTime, LocalDate initialDate, LocalDate finalDate, String weekDay, SystemUser teacher){
        Iterable<Meeting> meetings = meetingParticipationRepo.listFutureMeetingsByUser(teacher);
        for(Meeting meeting : meetings) {
            if(lectureInDayAndHourService.isMeetingInDateHourAndWeekDay(initialTime, finalTime, initialDate, finalDate, weekDay, meeting))
                return false;
        }
        return true;
    }
}
