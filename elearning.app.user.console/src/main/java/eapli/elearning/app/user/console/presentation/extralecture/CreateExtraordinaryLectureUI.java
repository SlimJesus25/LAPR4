package eapli.elearning.app.user.console.presentation.extralecture;

import eapli.elearning.app.user.console.presentation.lecture.CourseDTOPrinter;
import eapli.elearning.app.user.console.presentation.lecture.ScheduleDTOPrinter;
import eapli.elearning.courseenrollmentmanagement.application.GetCourseEnrolledStudentsService;
import eapli.elearning.coursemanagement.application.FindCourseByCourseCodeService;
import eapli.elearning.coursemanagement.application.ListTeacherAppliedCoursesService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.extralecturemanagement.application.CreateExtraLectureController;
import eapli.elearning.extralecturemanagement.application.ListExtraClassesOfTeacherService;
import eapli.elearning.extralecturemanagement.application.NonAppliedStudentsExtraClassService;
import eapli.elearning.extralecturemanagement.domain.*;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.lecturemanagement.application.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.studentmanagement.application.FindStudentByMechanographicalNumberService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CreateExtraordinaryLectureUI extends AbstractUI {
    private final CreateExtraLectureController ctrl = new CreateExtraLectureController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentPrinter studentPrinter= new StudentPrinter();
    private final CourseDTOPrinter courseDTOPrinter= new CourseDTOPrinter();
    private final ScheduleDTOPrinter scheduleDTOPrinter= new ScheduleDTOPrinter();
    private final FindStudentByMechanographicalNumberService findStudentByMechanographicalNumberService = new FindStudentByMechanographicalNumberService();
    private final ListTeacherAppliedCoursesService listTeacherAppliedCoursesService = new ListTeacherAppliedCoursesService();
    private final GetTeacherScheduleService getTeacherScheduleService = new GetTeacherScheduleService();
    private final GetCourseEnrolledStudentsService getCourseEnrolledStudentsService = new GetCourseEnrolledStudentsService();
    private final FindTeacherByUsernameService findTeacherByUsernameService = new FindTeacherByUsernameService();
    private final ListExtraClassesOfTeacherService getTeacherExtraClassesService = new ListExtraClassesOfTeacherService();
    private final FindCourseByCourseCodeService findCourseByCourseCodeService = new FindCourseByCourseCodeService();
    private final CheckMeetingCollisionService checkMeetingCollisionService = new CheckMeetingCollisionService();
    private final CheckLecturesHourRelatedService checkLecturesHourRelatedService = new CheckLecturesHourRelatedService();
    private final ValidateExtraClassesCallerService validateExtraClassesCallerService = new ValidateExtraClassesCallerService();
    private final UtilsLectureService utilsLectureService = new UtilsLectureService();
    private final NonAppliedStudentsExtraClassService nonAppliedStudentsExtraClassService = new NonAppliedStudentsExtraClassService();
    private final CollisionLecturesCourseService collisionLecturesCourseService = new CollisionLecturesCourseService();

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
            ExtraLectureInitialTime startHours= getExtraLectureInitialTime();
            if(startHours==null) return false;
            ExtraLectureFinalTime endHours= getExtraLectureFinalTime(startHours);
            if(endHours==null) return false;
            ExtraLectureDate date= getLectureDate(scheduleList,startHours,endHours);
            if(date==null) return false;
            ExtraLectureType extraLectureType= extraLectureTypeSelectWidget();
            if(extraLectureType==null) return false;
            Set<Student> students=new HashSet<>();
            getStudents(selectedCourse, students);
            if(students.isEmpty()) return false;
            Teacher teacher= findTeacherByUsernameService.findTeacherByUsername(authz.session().get().authenticatedUser().identity());
            List<ExtraLectureDTO> teacherExtraClasses= getTeacherExtraClassesService.allExtraClassesOfTeacher(teacher);
            Course course= findCourseByCourseCodeService.findCourseByCourseCode(selectedCourse.identity());
            if(validateExtraClassesCallerService.allTeacherExtraClassesValidated(teacherExtraClasses,startHours.initialTime(),endHours.finalTime(),date.date()))
                if(validateMeetingsInterception(startHours,endHours,date,date.date().getDayOfWeek())) {
                    if (!collisionLecturesCourseService.isCollisionLectureAndLecturesCourse(selectedCourse, startHours.initialTime(), endHours.finalTime(), date.date(), date.date(), date.date().getDayOfWeek().toString())) {
                        ExtraLecture extraLecture = ctrl.createExtraLecture(startHours.initialTime(), endHours.finalTime(), date.date(), extraLectureType, teacher, course);
                        if (extraLecture != null) {
                            createExtraLectureParticipants(extraLecture, students);
                            System.out.println("Lecture created successfully!");
                        } else
                            System.out.println("Something went wrong! Please try again!");
                    }
                    else
                        warnIsCollidingWithLecturesCourse();
                }
                else
                    warnLectureInterceptMeeting();
            else
                warnExtraLectureInterceptExtraClass();
        }else {
            warnToApplyToCourse();
        }
        return false;
    }

    private void createExtraLectureParticipants(ExtraLecture extraLecture, Set<Student> students) {
        for (Student student : students) {
            ctrl.createExtraLectureParticipant(extraLecture, student);
        }
    }
    private void warnIsCollidingWithLecturesCourse() {
        System.out.println("I'm sorry but the course already have a lecture scheduled in the same time interval!\n" +
                "Please talk to the course regent before you try to schedule a new class!");
    }
    private void warnLectureInterceptMeeting() {
        System.out.println("I'm sorry but you already have a meeting scheduled in the same time interval!\n" +
                "Please delete the meeting before you try to schedule a new class!");
    }

    private void warnExtraLectureInterceptExtraClass() {
        System.out.println("I'm sorry but you already have an extra class scheduled in the same time interval!\n" +
                "Please delete the extra class before you try to schedule a new class!");
    }
    private void getStudents(CourseDTO selectedCourse, Set<Student> students) {
        Set<Student> newStudents=showStudents(selectedCourse,students);
        if(newStudents.isEmpty()) return;
        String answer= Console.readLine("Do you want to insert students? (Y/N)");
        if (answer.equals("Y") || answer.equals("y")){
               String studentNumber= Console.readLine("Please insert the student number:");
               if(nonAppliedStudentsExtraClassService.newStudentsHasStudentNumber(newStudents,studentNumber)){
                   students.add(findStudentByMechanographicalNumberService.findStudentByMechanographicalNumber(studentNumber));
                   System.out.println("Student " + studentNumber + " inserted!");
                   getStudents(selectedCourse,students);
               }
               else {
                   System.out.println("Student " + studentNumber + " does not exist or is already inserted!");
                     getStudents(selectedCourse,students);
               }
        }
    }

    private boolean validateMeetingsInterception(ExtraLectureInitialTime startHours, ExtraLectureFinalTime endHours, ExtraLectureDate date, DayOfWeek dayOfWeek) {
        return checkMeetingCollisionService.checkLectureAvailability(startHours, endHours, date, dayOfWeek);
    }

    private Set<Student> showStudents(CourseDTO selectedCourse, Set<Student> studentsApplied) {
        Iterable<Student> studentsIterator = getCourseEnrolledStudentsService.getCourseEnrolledStudents(selectedCourse);
        List<Student> students= nonAppliedStudentsExtraClassService.nonAppliedStudents(studentsIterator,studentsApplied);
        if(students.size()>0) {
            System.out.println("Students:");
            for (Student student : students) {
                studentPrinter.visit(student.toDTO());
            }
            return new HashSet<>(students);
        }else if(studentsApplied.isEmpty()){
            System.out.println("There are no students registered in this course!");
            return new HashSet<>();
        }
        else{
            System.out.println("There are no students registered in this course that you haven't already inserted!");
            return new HashSet<>();
        }
    }

    private ExtraLectureDate getLectureDate(List<LectureDTO> scheduleList, ExtraLectureInitialTime startHours, ExtraLectureFinalTime endHours) {
        String inputLectureInitialDate = Console.readLine("Please insert the lecture initial date (DD/MM/YYYY) Ensure the date you write is from today on and before 2050 \n\n0. Exit");
        if(inputLectureInitialDate.equals("0"))
            return null;
        LocalDate date;
        if(utilsLectureService.isValidDate(inputLectureInitialDate, "dd/MM/yyyy"))
            date = LocalDate.parse(inputLectureInitialDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        else{
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE DD/MM/YYYY!");
            System.out.println("Example: 04/05/2024");
            return getLectureDate(scheduleList,startHours,endHours);
        }
        return ifOverlappingLecture(scheduleList,date,startHours,endHours);
    }

    private ExtraLectureDate ifOverlappingLecture(List<LectureDTO> scheduleList, LocalDate date, ExtraLectureInitialTime startHours, ExtraLectureFinalTime endHours) {
        ExtraLectureDate lectureDate = new ExtraLectureDate(date);
        List<LectureDTO> lecturesInThisDay= checkLecturesHourRelatedService.lecturesInThisWeekDay(scheduleList,date);
        if(lecturesInThisDay.size()>0){
            if(checkLecturesHourRelatedService.lecturesInThisHour(lecturesInThisDay,startHours.initialTime(),endHours.finalTime())){
                System.out.println("There is already a lecture in this day and hour!");
                return getLectureDate(scheduleList,startHours,endHours);
            }
        }
        return lectureDate;
    }

    private ExtraLectureType extraLectureTypeSelectWidget() {
        final SelectWidget<ExtraLectureType> extraLectureTypeSelectWidget =
                new SelectWidget<>("Extra Lecture Types\n", Arrays.asList(ExtraLectureType.values()), new ExtraLectureTypePrinter());
        extraLectureTypeSelectWidget.show();
        return extraLectureTypeSelectWidget.selectedElement();
    }
    private ExtraLectureFinalTime getExtraLectureFinalTime(ExtraLectureInitialTime startHours) {
        String inputLectureFinalTime = Console.readLine("Please insert the lecture final time (HH:MM) Ensure the time you write is between 7:00 and 23:00 and it's after lecture initial time. \n\n0. Exit");
        if(inputLectureFinalTime.equals("0"))
            return null;
        LocalTime time = utilsLectureService.parseTimeString(inputLectureFinalTime);
        if(time==null) {
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE HH:MM! Ensure the time you write is between 7:00 and 23:00.");
            System.out.println("Example: 09:00");
            return getExtraLectureFinalTime(startHours);
        }
        return checkIfTimeIsAfterStart(startHours,time);
    }

    private ExtraLectureFinalTime checkIfTimeIsAfterStart(ExtraLectureInitialTime startHours, LocalTime time) {
        if(time.isBefore(startHours.initialTime())||time.equals(startHours.initialTime())){
            System.out.println("The lecture final time must be after the lecture initial time!");
            return getExtraLectureFinalTime(startHours);
        }
        return new ExtraLectureFinalTime(time);
    }

    private ExtraLectureInitialTime getExtraLectureInitialTime() {
        String inputLectureInitialTime = Console.readLine("Please insert the lecture initial time (HH:MM) Ensure the time you write is between 7:00 and 23:00.\n\n0. Exit");
        if(inputLectureInitialTime.equals("0"))
            return null;
        LocalTime time = utilsLectureService.parseTimeString(inputLectureInitialTime);
        if(time==null){
            System.out.println("DATE FORMAT WRONG YOU NEED TO WRITE HH:MM! Ensure the time you write is between 7:00 and 23:00.");
            System.out.println("Example: 09:00");
            return getExtraLectureInitialTime();
        }
        return new ExtraLectureInitialTime(time);
    }


    private void warnScheduleIsFull() {
        System.out.println("I'm sorry but your schedule is already full! If you desire " +
                "to schedule a new class you'll have to delete an already existing one!");
    }
    private void warnToApplyToCourse() {
        System.out.println("You need to be applied to a course first!\n" +
                "Please contact the management team for you to be enrolled in a course before " +
                "you try to schedule a class!");
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
        return "Schedule an Extra Class";
    }
}
