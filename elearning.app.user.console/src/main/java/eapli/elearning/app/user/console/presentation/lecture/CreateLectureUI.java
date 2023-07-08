package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.application.ListTeacherAppliedCoursesService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.extralecturemanagement.application.ListExtraClassesOfTeacherService;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.lecturemanagement.application.*;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.checkerframework.checker.guieffect.qual.UI;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@UI
public class CreateLectureUI extends AbstractUI {
    private final CreateLectureController createLectureController = new CreateLectureController();
    private final ScheduleDTOPrinter scheduleDTOPrinter= new ScheduleDTOPrinter();
    private final ScheduleOfDayDTOPrinter scheduleOfDayDTOPrinter= new ScheduleOfDayDTOPrinter();
    private final CourseDTOPrinter courseDTOPrinter= new CourseDTOPrinter();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListTeacherAppliedCoursesService listTeacherAppliedCoursesService = new ListTeacherAppliedCoursesService();
    private final GetTeacherScheduleService getTeacherScheduleService = new GetTeacherScheduleService();
    private final FindTeacherByUsernameService findTeacherByUsernameService = new FindTeacherByUsernameService();
    private final ListExtraClassesOfTeacherService getTeacherExtraClassesController = new ListExtraClassesOfTeacherService();
    private final FindCourseByCourseCodeService findCourseByCourseCodeService = new FindCourseByCourseCodeService();
    private final CollisionLecturesCourseService collisionLecturesCourseService = new CollisionLecturesCourseService();
    private final TeacherAvailableWeekDaysService teacherAvailableWeekDaysService = new TeacherAvailableWeekDaysService();
    private final UtilsLectureService utilsLectureService = new UtilsLectureService();
    private final ValidateExtraClassesCallerService validateExtraClassesCallerService = new ValidateExtraClassesCallerService();
    private final CheckMeetingCollisionService checkMeetingCollisionService = new CheckMeetingCollisionService();
    private final CheckLecturesHourRelatedService checkLecturesHourRelatedService = new CheckLecturesHourRelatedService();
    @Override
    protected boolean doShow() {
        Iterable<CourseDTO> coursesOfTeacherIterator = listTeacherAppliedCoursesService.listTeacherAppliedCourses(authz.session());
        List<CourseDTO> courses= new ArrayList<>();
        coursesOfTeacherIterator.forEach(courses::add);

        if(courses.size()>0) {

            CourseDTO selectedCourse=courseDTOSelectWidget(courses);
            showTeachingCourses(coursesOfTeacherIterator);
            if (selectedCourse == null) return false;

            Iterable<LectureDTO> schedule=teacherWeekSchedule();
            List<LectureDTO> scheduleList = StreamSupport.stream(schedule.spliterator(), false).collect(Collectors.toList());
            Iterable<LectureWeekDay> availableWeekDaysIterator =teacherAvailableWeekDaysService.listTeacherAvailableWeekDays(scheduleList);
            List<LectureWeekDay> availableWeekDays= new ArrayList<>();
            availableWeekDaysIterator.forEach(availableWeekDays::add);
            scheduleDTOPrinter.visit(schedule);
            if(availableWeekDays.size()>0){
                LectureWeekDay selectedWeekDay =weekDaySelectWidget(availableWeekDays);
                if(selectedWeekDay==null) return false;
                scheduleOfDayDTOPrinter.visit(Pair.of(selectedWeekDay,scheduleList));
                LectureInitialTime startHours= getLectureInitialTime(schedule,selectedWeekDay);
                if(startHours==null) return false;
                LectureFinalTime endHours= getLectureFinalTime(startHours,schedule,selectedWeekDay);
                if(endHours==null) return false;
                LectureInitialDate startDate= getLectureInitialDate();
                if(startDate==null) return false;
                LectureFinalDate finalDate= getLectureFinalDate(startDate,selectedWeekDay);
                if(finalDate==null) return false;
                LectureType lectureType=lectureTypeSelectWidget();
                if(lectureType==null) return false;
                Teacher teacher= findTeacherByUsernameService.findTeacherByUsername(authz.session().get().authenticatedUser().identity());
                List<ExtraLectureDTO> teacherExtraClasses= getTeacherExtraClassesController.allExtraClassesOfTeacher(teacher);
                Course course= findCourseByCourseCodeService.findCourseByCourseCode(selectedCourse.identity());
                if(validateExtraClassesCallerService.allTeacherExtraClassesValidated(teacherExtraClasses,startHours,endHours,startDate,finalDate,selectedWeekDay)) {
                    if(validateMeetingsInterception(startHours,endHours,startDate,finalDate,selectedWeekDay))
                        if(!collisionLecturesCourseService.isCollisionLectureAndLecturesCourse(selectedCourse,startHours.initialTime(),endHours.finalTime(),startDate.initialDate(),finalDate.finalDate(),selectedWeekDay.name()))
                            if(createLectureController.createLecture(startHours.initialTime(), endHours.finalTime(), startDate.initialDate(), finalDate.finalDate(), selectedWeekDay, lectureType, teacher, course)!=null)
                                System.out.println("Lecture created successfully!");
                            else
                                System.out.println("Something went wrong! Please try again!");
                        else
                            warnIsCollidingWithLecturesCourse();
                    else
                        warnLectureInterceptMeeting();
                }else
                    warnLectureInterceptExtraClass();
            }else{
                warnScheduleIsFull();
            }
        }else{
            warnToApplyToCourse();
        }
        return false;
    }

    private void warnIsCollidingWithLecturesCourse() {
        System.out.println("I'm sorry but the course already have a lecture scheduled in the same time interval!\n" +
                "Please talk to the course regent before you try to schedule a new class!");
    }

    private void warnLectureInterceptMeeting() {
        System.out.println("I'm sorry but you already have a meeting scheduled in the same time interval!\n" +
                "Please delete the meeting before you try to schedule a new class!");
    }

    private void warnToApplyToCourse() {
        System.out.println("You need to be applied to a course first!\n" +
                "Please contact the management team for you to be enrolled in a course before " +
                "you try to schedule a class!");
    }

    private void warnScheduleIsFull() {
        System.out.println("I'm sorry but your schedule is already full! If you desire " +
                "to schedule a new class you'll have to delete an already existing one!");
    }
    private void warnLectureInterceptExtraClass() {
        System.out.println("I'm sorry but you already have an extra class scheduled in the same time interval!\n" +
                "Please delete the extra class before you try to schedule a new class!");
    }
    private boolean validateMeetingsInterception(LectureInitialTime startHours, LectureFinalTime endHours, LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay selectedWeekDay) {
        return checkMeetingCollisionService.checkLectureAvailability(startHours.initialTime(),endHours.finalTime(),startDate.initialDate(),finalDate.finalDate(),selectedWeekDay.name(),authz.session().get().authenticatedUser());
    }
    private LectureFinalDate getLectureFinalDate(LectureInitialDate startDate, LectureWeekDay chosenWeekDay) {
        String inputLectureFinalDate = Console.readLine("Please insert the lecture final date (DD/MM/YYYY) Ensure the date you write is after the initial date and before 2050 \n\n0. Exit");
        if(inputLectureFinalDate.equals("0"))
            return null;
        LocalDate date;
        if(utilsLectureService.isValidDate(inputLectureFinalDate))
            date = LocalDate.parse(inputLectureFinalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        else{
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE DD/MM/YYYY!");
            System.out.println("Example: 01/01/2020");
            return getLectureFinalDate(startDate,chosenWeekDay);
        }
        LectureFinalDate finalDate=checkIfDateIsAfterStart(startDate,date,chosenWeekDay);
        return checkIfDateIntervalHasChosenWeekDay(startDate,finalDate,chosenWeekDay);
    }

    private LectureInitialDate getLectureInitialDate() {
        String inputLectureInitialDate = Console.readLine("Please insert the lecture initial date (DD/MM/YYYY) Ensure the date you write is from today on and before 2050 \n\n0. Exit");
        if(inputLectureInitialDate.equals("0"))
            return null;
        LocalDate date;
        if(utilsLectureService.isValidDate(inputLectureInitialDate))
            date = LocalDate.parse(inputLectureInitialDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        else{
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE DD/MM/YYYY!");
            System.out.println("Example: 04/05/2024");
            return getLectureInitialDate();
        }
        return new LectureInitialDate(date);
    }



    private LectureFinalTime getLectureFinalTime(LectureInitialTime start, Iterable<LectureDTO> schedule, LectureWeekDay selectedWeekDay) {
        String inputLectureFinalTime = Console.readLine("Please insert the lecture final time (HH:MM) Ensure the time you write is between 7:00 and 23:00 and it's after lecture initial time. \n\n0. Exit");
        if(inputLectureFinalTime.equals("0"))
            return null;
        LocalTime time = utilsLectureService.parseTimeString(inputLectureFinalTime);
        if(time==null) {
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE HH:MM! Ensure the time you write is between 7:00 and 23:00.");
            System.out.println("Example: 09:00");
            return getLectureFinalTime(start,schedule,selectedWeekDay);
        }
        LectureFinalTime finalTimeTemp=checkIfFinalTimeIsAvailable(time,start.initialTime(),schedule,selectedWeekDay);
        time=finalTimeTemp.finalTime();
        return checkIfTimeIsAfterStart(start,time,schedule,selectedWeekDay);
        //ask for lectureInitialTime
        //validate if lectureFinalTime is not in schedule
        //validate if there is no lecture between start and end (if schedule is all free)
    }

    private LectureFinalTime checkIfFinalTimeIsAvailable(LocalTime end, LocalTime start,Iterable<LectureDTO> schedule, LectureWeekDay selectedWeekDay) {
        LectureFinalTime endFinalTime = new LectureFinalTime(end);
        List<LectureDTO> lecturesInThisDay= checkLecturesHourRelatedService.lecturesInThisWeekDay(StreamSupport.stream(schedule.spliterator(), false).collect(Collectors.toList()),selectedWeekDay);
        for(LectureDTO lecture:lecturesInThisDay){
            if(lecture.getLectureInitialTime().initialTime().equals(end)||lecture.getLectureFinalTime().finalTime().equals(end)
                    ||lecture.getLectureInitialTime().initialTime().isBefore(end)&&lecture.getLectureFinalTime().finalTime().isAfter(end)){
                System.out.println("The lecture final time is not available!");
                endFinalTime=getLectureFinalTime(new LectureInitialTime(start),schedule,selectedWeekDay);
            }
            else if(utilsLectureService.selectedIntervalIsInsideLectureInterval(lecture,end,start)){
                System.out.println("The Lecture you are trying to schedule has another lecture inside!");
                endFinalTime=getLectureFinalTime(new LectureInitialTime(start),schedule,selectedWeekDay);
            }
        }
        return endFinalTime;

    }

    private LectureFinalTime checkIfTimeIsAfterStart(LectureInitialTime start, LocalTime time, Iterable<LectureDTO> schedule, LectureWeekDay selectedWeekDay  ) {
        LectureFinalTime end = new LectureFinalTime(time);
        if(time.isBefore(start.initialTime())|| time.equals(start.initialTime())){
            System.out.println("The lecture final time must be after the lecture initial time!");
            end=getLectureFinalTime(start,schedule,selectedWeekDay);
        }
        return end;
    }
    private LectureFinalDate checkIfDateIsAfterStart(LectureInitialDate startDate, LocalDate date, LectureWeekDay chosenWeekDay) {
        LectureFinalDate end = new LectureFinalDate(date);
        if(date.isBefore(startDate.initialDate())|| date.equals(startDate.initialDate())){
            System.out.println("The lecture final date must be after the lecture initial date!");
            end=getLectureFinalDate(startDate,chosenWeekDay);
        }
        return end;
    }
    private LectureFinalDate checkIfDateIntervalHasChosenWeekDay(LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay chosenWeekDay) {
        if(!utilsLectureService.isInInterval(startDate.initialDate(),finalDate.finalDate(),chosenWeekDay)){
            System.out.println("The lecture interval must have at least one "+chosenWeekDay+"!");
            finalDate=getLectureFinalDate(startDate,chosenWeekDay);
        }
        return finalDate;
    }



    private LectureInitialTime getLectureInitialTime(Iterable<LectureDTO> schedule, LectureWeekDay selectedWeekDay) {
        String inputLectureInitialTime = Console.readLine("Please insert the lecture initial time (HH:MM) Ensure the time you write is between 7:00 and 23:00.\n\n0. Exit");
        if(inputLectureInitialTime.equals("0"))
            return null;
        LocalTime time = utilsLectureService.parseTimeString(inputLectureInitialTime);
        if(time==null){
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE HH:MM! Ensure the time you write is between 7:00 and 23:00.");
            System.out.println("Example: 09:00");
            return getLectureInitialTime(schedule,selectedWeekDay);
        }
        return checkIfTimeIsAvailable(time,schedule,selectedWeekDay);
        //ask for lectureInitialTime
        //validate if lectureInitialTime is not in schedule
    }

    private LectureInitialTime checkIfTimeIsAvailable(LocalTime time, Iterable<LectureDTO> schedule, LectureWeekDay selectedWeekDay) {

        LectureInitialTime start = new LectureInitialTime(time);
        List<LectureDTO> lecturesInThisDay= checkLecturesHourRelatedService.lecturesInThisWeekDay(StreamSupport.stream(schedule.spliterator(), false).collect(Collectors.toList()),selectedWeekDay);
        for(LectureDTO lectureDTO:lecturesInThisDay){
            if(lectureDTO.getLectureInitialTime().initialTime().equals(time)||lectureDTO.getLectureFinalTime().finalTime().equals(time)||(lectureDTO.getLectureInitialTime().initialTime().isBefore(time)&&lectureDTO.getLectureFinalTime().finalTime().isAfter(time))){
                System.out.println("The lecture initial time is not available!");
                start=getLectureInitialTime(schedule,selectedWeekDay);
            }
        }
        return start;

    }

    private LectureWeekDay weekDaySelectWidget(List<LectureWeekDay> availableWeekDays) {
        final SelectWidget<LectureWeekDay> lectureWeekDaySelectWidget =
                new SelectWidget<>("Week days available\n", availableWeekDays, new WeekDayPrinter());
        lectureWeekDaySelectWidget.show();
        return lectureWeekDaySelectWidget.selectedElement();
    }
    private LectureType lectureTypeSelectWidget() {
        final SelectWidget<LectureType> lectureTypeSelectWidget =
                new SelectWidget<>("Lecture Types\n", Arrays.asList(LectureType.values()), new LectureTypePrinter());
        lectureTypeSelectWidget.show();
        return lectureTypeSelectWidget.selectedElement();
    }
    private Iterable<LectureDTO> teacherWeekSchedule() {
        System.out.println("Your Week Schedule");
        return getTeacherScheduleService.getTeacherSchedule(authz.session());
    }

    private void showTeachingCourses(Iterable<CourseDTO> coursesOfTeacherIterator) {
        System.out.println("Your Teaching Courses");
        coursesOfTeacherIterator.forEach(courseDTOPrinter::visit);
    }

    private CourseDTO courseDTOSelectWidget(List<CourseDTO> courses) {
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("Courses to enroll\n", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        return courseDTOSelectWidget.selectedElement();
    }

    @Override
    public String headline() {
        {
            return "Schedule Lecture";
        }
    }
}

