package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.coursemanagement.application.ListTeacherAppliedCoursesService;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.extralecturemanagement.application.ListExtraClassesOfTeacherService;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.lecturemanagement.application.GetTeacherScheduleService;
import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.application.UpdateLectureController;
import eapli.elearning.lecturemanagement.domain.ValidateExtraClassesService;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.elearning.meetingmanagement.domain.CheckAvailabilityService;
import eapli.elearning.teachermanagement.application.FindTeacherByUsernameService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.EnumSelectWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UpdateLectureUI extends AbstractUI {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final GetTeacherScheduleService getTeacherScheduleService = new GetTeacherScheduleService();
    private final ListExtraClassesOfTeacherService getTeacherExtraClassesController= new ListExtraClassesOfTeacherService();
    private final FindTeacherByUsernameService findTeacherByUsernameService = new FindTeacherByUsernameService();

    private final ListTeacherAppliedCoursesService listTeacherAppliedCoursesService = new ListTeacherAppliedCoursesService();
    private final LectureInDayAndHourService lectureInDayAndHourService = new LectureInDayAndHourService();
    private final UpdateLectureController updateLectureController = new UpdateLectureController();
    private final ValidateExtraClassesService validateExtraClassesService = new ValidateExtraClassesService();
    private final CheckAvailabilityService checkAvailabilityService= new CheckAvailabilityService();

    private final UpdateLectureTypePrinter updateLectureTypePrinter = new UpdateLectureTypePrinter();
    private final UpdateLectureCourseDTOPrinter courseDTOPrinter= new UpdateLectureCourseDTOPrinter();

    @Override
    protected boolean doShow() {
        Iterable<LectureDTO> schedule=teacherWeekSchedule();
        List<LectureDTO> scheduleList = StreamSupport.stream(schedule.spliterator(), false).collect(Collectors.toList());
        if(scheduleList.isEmpty()){
            System.out.println("In order to update a lecture you need to have one already assigned!");
            return false;
        }
        LectureDTO selectedLecture=lectureDTOSelectWidget(scheduleList);
        if(selectedLecture==null){
            System.out.println("No lecture selected!");
            return false;
        }
        LectureInitialDate updatedInitialDate= initialDateChange(selectedLecture.getLectureInitialDate());
        LectureFinalDate updatedFinalDate= finalDateChange(selectedLecture.getLectureFinalDate());
        LectureWeekDay updatedWeekDay= weekDayChange(selectedLecture.getLectureWeekDay());
        LectureInitialTime updatedInitialTime= initialTimeChange(selectedLecture.getLectureInitialTime());
        LectureFinalTime updatedFinalTime= finalTimeChange(selectedLecture.getLectureFinalTime(),updatedInitialTime);
        LectureType updatedLectureType= lectureTypeChange(selectedLecture.getLectureType());
        CourseDTO updatedLectureCourse= lectureCourseChange(selectedLecture.getCourse());
        scheduleList.remove(selectedLecture);
        List<ExtraLectureDTO> teacherExtraClasses= getTeacherExtraClassesController.allExtraClassesOfTeacher(findTeacherByUsernameService.findTeacherByUsername(authz.session().get().authenticatedUser().identity()));
        if(validateIfLectureCanBeUpdated(updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,scheduleList,teacherExtraClasses))
            if(askIfLectureShouldBeUpdated(updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,updatedLectureType,updatedLectureCourse))
                if(updateLectureController.updateLecture(selectedLecture,updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,updatedLectureType,updatedLectureCourse))
                    System.out.println("Lecture updated successfully!");
                else
                    System.out.println("Sorry but some unexpected error happened, please try again!");
        return false;
    }

    private boolean askIfLectureShouldBeUpdated(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, CourseDTO updatedLectureCourse) {
        informationAboutLecture(updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,updatedLectureType,updatedLectureCourse);
        String answer=Console.readLine("Are you sure you want to update the lecture with the new information? (Y/N)");
        if(answer.equals("Y")||answer.equals("y")) {
            System.out.println("The lecture will be updated!");
            return true;
        }
        else if(answer.equals("N")||answer.equals("n")){
            System.out.println("The lecture won't be updated!");
            return false;
        }
        else{
            System.out.println("Invalid answer!");
            askIfLectureShouldBeUpdated(updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,updatedLectureType,updatedLectureCourse);
        }
        return false;
    }

    private void informationAboutLecture(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, CourseDTO updatedLectureCourse) {
        System.out.println("The lecture will be updated with the following information:");
        System.out.println("Initial date: "+updatedInitialDate.initialDate());
        System.out.println("Final date: "+updatedFinalDate.finalDate());
        System.out.println("Week day: "+updatedWeekDay.toString());
        System.out.println("Initial time: "+updatedInitialTime.initialTime());
        System.out.println("Final time: "+updatedFinalTime.finalTime());
        System.out.print("Lecture type: ");
        updateLectureTypePrinter.visit(updatedLectureType);
        System.out.print("\n");
        System.out.print("Course: ");
        courseDTOPrinter.visit(updatedLectureCourse);
        System.out.print("\n");
    }

    private boolean validateIfLectureCanBeUpdated(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, List<LectureDTO> schedule, List<ExtraLectureDTO> teacherExtraClasses) {
        if(!updatedFinalDate.finalDate().isAfter(updatedInitialDate.initialDate())){
            System.out.println("The final date must be after the initial date! Therefore the lecture cannot be updated!");
            return false;
        }
        if(!validateIfDateIntervalHasChosenWeekDay(updatedInitialDate,updatedFinalDate,updatedWeekDay)){
            System.out.println("The chosen week day is not in the interval of the initial and final date! Therefore the lecture cannot be updated!");
            return false;
        }
        if(!lectureIsNotBlockingLecturesInTeacherSchedule(updatedInitialDate,updatedFinalDate,updatedWeekDay,updatedInitialTime,updatedFinalTime,schedule)){
            System.out.println("The lecture is blocking another lecture in your schedule! Therefore the lecture cannot be updated!");
            return false;
        }
        if(!validateExtraClassesService.allTeacherExtraClassesValidated(teacherExtraClasses,updatedInitialTime,updatedFinalTime,updatedInitialDate,updatedFinalDate,updatedWeekDay)) {
            System.out.println("The lecture is blocking another extra class in your schedule! Therefore the lecture cannot be updated!");
            return false;
        }
        if(!validateMeetingsInterception(updatedInitialTime,updatedFinalTime,updatedInitialDate,updatedFinalDate,updatedWeekDay)){
            System.out.println("The lecture is blocking another meeting in your schedule! Therefore the lecture cannot be updated!");
            return false;
        }
        return true;
    }

    private boolean validateMeetingsInterception(LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay) {
        return checkAvailabilityService.checkLectureAvailability(updatedInitialTime.initialTime(),updatedFinalTime.finalTime(),updatedInitialDate.initialDate(),updatedFinalDate.finalDate(),updatedWeekDay.name(),authz.session().get().authenticatedUser());
    }

    private boolean lectureIsNotBlockingLecturesInTeacherSchedule(LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, List<LectureDTO> schedule) {
        return !lectureInDayAndHourService.areLecturesInDateHourAndWeekDay(updatedInitialDate, updatedFinalDate, updatedWeekDay, updatedInitialTime, updatedFinalTime, schedule);
    }

    private boolean validateIfDateIntervalHasChosenWeekDay(LectureInitialDate startDate, LectureFinalDate finalDate, LectureWeekDay chosenWeekDay) {
        return isInInterval(startDate.initialDate(),finalDate.finalDate(),chosenWeekDay);
    }

    private boolean isInInterval(LocalDate initialDate, LocalDate finalDate, LectureWeekDay chosenWeekDay) {
        LocalDate date=initialDate;
        while(date.isBefore(finalDate)||date.equals(finalDate)){
            String dayOfWeekString = date.getDayOfWeek().toString();
            if(dayOfWeekString.toUpperCase().equals(chosenWeekDay.toString().toUpperCase()))
                return true;
            date=date.plusDays(1);
        }
        return false;
    }

    private CourseDTO lectureCourseChange(CourseDTO course) {
        System.out.println("Current Course: "+course.getCourseTitle()+" - "+ course.getCourseDescription());
        String answer = Console.readLine("Do you want to change the course? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeCourse(course);
        return course;
    }

    private LectureType lectureTypeChange(LectureType lectureType) {
        System.out.print("Current Lecture Type: ");
        updateLectureTypePrinter.visit(lectureType);
        System.out.print("\n");
        String answer = Console.readLine("Do you want to change the lecture type? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeLectureType(lectureType);
        return lectureType;
    }

    private LectureFinalTime finalTimeChange(LectureFinalTime lectureFinalTime, LectureInitialTime updatedInitialTime) {
        if(!lectureFinalTime.finalTime().isAfter(updatedInitialTime.initialTime())){
            System.out.println("As you updated the initial time after the previous final time, the final time must be updated!");
            return forcedChangeFinalTime(updatedInitialTime);
        }
        else {
            System.out.println("Current Final Time: " + lectureFinalTime.finalTime());
            String answer = Console.readLine("Do you want to change the final time? (Y/N)");
            if (answer.equals("Y") || answer.equals("y"))
                return goingToChangeFinalTime(lectureFinalTime, updatedInitialTime);
            return lectureFinalTime;
        }
    }

    private LectureInitialTime initialTimeChange(LectureInitialTime lectureInitialTime) {
        System.out.println("Current Initial Time: " + lectureInitialTime.initialTime());
        String answer = Console.readLine("Do you want to change the initial time? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeInitialTime(lectureInitialTime);
        return lectureInitialTime;
    }

    private LectureWeekDay weekDayChange(LectureWeekDay lectureWeekDay) {
        System.out.println("Current Week Day: " + lectureWeekDay.toString());
        String answer = Console.readLine("Do you want to change the week day? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeWeekDay(lectureWeekDay);
        return lectureWeekDay;
    }

    private LectureFinalDate finalDateChange(LectureFinalDate lectureFinalDate) {
        System.out.println("Current Final Date: " + lectureFinalDate.finalDate());
        String answer = Console.readLine("Do you want to change the final date? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeFinalDate(lectureFinalDate);
        return lectureFinalDate;
    }

    private LectureInitialDate initialDateChange(LectureInitialDate lectureInitialDate) {
        System.out.println("Current Initial Date: " + lectureInitialDate.initialDate());
        String answer = Console.readLine("Do you want to change the initial date? (Y/N)");
        if (answer.equals("Y") || answer.equals("y"))
            return goingToChangeInitialDate(lectureInitialDate);
        return lectureInitialDate;
    }

    private LectureFinalTime forcedChangeFinalTime(LectureInitialTime updatedInitialTime) {
        String newFinalTime = Console.readLine("Please insert the lecture final time (HH:mm)." +
                " Ensure the time you write is after the initial time and before 23:00.\n" +
                " Also take in consideration to check your already scheduled lectures and be aware if the lecture you're updating will be assigned in an available time!\n");
        if(newTimeIsValid(newFinalTime,DateTimeFormatter.ofPattern("HH:mm"))){
            if(newTimeIsAfterInitialTime(newFinalTime,updatedInitialTime))
                return new LectureFinalTime(LocalTime.parse(newFinalTime,DateTimeFormatter.ofPattern("HH:mm")));
            else
                System.out.println("INVALID INPUT! THE TIME YOU INSERTED IS NOT AFTER THE INITIAL TIME!");
        }
        else {
            System.out.println("INVALID INPUT! THE TIME YOU INSERTED IS NOT IN THE FORMAT (mm:HH)!");
        }
        return forcedChangeFinalTime(updatedInitialTime);
    }

    private LectureFinalTime goingToChangeFinalTime(LectureFinalTime lectureFinalTime, LectureInitialTime updatedInitialTime) {
        String newFinalTime = Console.readLine("Please insert the lecture final time (HH:mm)." +
                " Ensure the time you write is after the initial time and before 23:00.\n" +
                " Also take in consideration to check your already scheduled lectures and be aware if the lecture you're updating will be assigned in an available time! \n\n0. Exit");
        if(newFinalTime.equals("0"))
            return lectureFinalTime;
        else if(newTimeIsValid(newFinalTime,DateTimeFormatter.ofPattern("HH:mm"))){
            if(newTimeIsAfterInitialTime(newFinalTime,updatedInitialTime))
                return new LectureFinalTime(LocalTime.parse(newFinalTime,DateTimeFormatter.ofPattern("HH:mm")));
            else
                System.out.println("INVALID INPUT! THE TIME YOU INSERTED IS NOT AFTER THE INITIAL TIME!");
            return goingToChangeFinalTime(lectureFinalTime,updatedInitialTime);
        }
        else {
            System.out.println("INVALID INPUT! THE TIME YOU INSERTED IS NOT IN THE FORMAT (mm:HH)!");
            return goingToChangeFinalTime(lectureFinalTime,updatedInitialTime);
        }
    }

    private LectureInitialTime goingToChangeInitialTime(LectureInitialTime lectureInitialTime) {
        String newInitialTime = Console.readLine("Please insert the lecture initial time (HH:mm). Ensure the time you write is from 07:00 on and before 23:00 \n\n0. Exit");
        if(newInitialTime.equals("0"))
            return lectureInitialTime;
        else if(newTimeIsValid(newInitialTime,DateTimeFormatter.ofPattern("HH:mm")))
            return new LectureInitialTime(LocalTime.parse(newInitialTime,DateTimeFormatter.ofPattern("HH:mm")));
        else {
            System.out.println("INVALID INPUT!");
            return goingToChangeInitialTime(lectureInitialTime);
        }
    }

    private LectureWeekDay goingToChangeWeekDay(LectureWeekDay lectureWeekDay) {
        String newWeekDay = Console.readLine("Please insert the lecture week day " +
                "(MONDAY/TUESDAY/WEDNESDAY/THURSDAY/FRIDAY/SATURDAY/SUNDAY) \n\n0. Exit");
        if(newWeekDay.equals("0"))
            return lectureWeekDay;
        else if(newWeekDayIsValid(newWeekDay))
            return LectureWeekDay.valueOf(newWeekDay.substring(0,1).toUpperCase() + newWeekDay.substring(1).toLowerCase());
        else {
            System.out.println("INVALID INPUT!");
            return goingToChangeWeekDay(lectureWeekDay);
        }
    }

    private LectureFinalDate goingToChangeFinalDate(LectureFinalDate lectureFinalDate) {
        String newFinalDate = Console.readLine("Please insert the lecture final date " +
                "(DD/MM/YYYY) Ensure the date you write is from the initial " +
                "date on and before 2050! Also take in consideration the lecture must have at least one class between the initial and final date!" +
                "If the above instructions won't be applied the lecture won't be created! \n\n0. Exit");
        if(newFinalDate.equals("0"))
            return lectureFinalDate;
        else if(newDateIsValid(newFinalDate,DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            return new LectureFinalDate(LocalDate.parse(newFinalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        else {
            System.out.println("INVALID INPUT!");
            return goingToChangeFinalDate(lectureFinalDate);
        }
    }

    private LectureInitialDate goingToChangeInitialDate(LectureInitialDate lectureInitialDate) {
        String newInitialDate = Console.readLine("Please insert the lecture initial date (DD/MM/YYYY) Ensure the date you write is from today on and before 2050 \n\n0. Exit");
        if(newInitialDate.equals("0"))
            return lectureInitialDate;
        else if(newDateIsValid(newInitialDate,DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            return new LectureInitialDate(LocalDate.parse(newInitialDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        else {
            System.out.println("INVALID INPUT!");
            return goingToChangeInitialDate(lectureInitialDate);
        }
    }

    private boolean newTimeIsAfterInitialTime(String newFinalTime, LectureInitialTime updatedInitialTime) {
        return LocalTime.parse(newFinalTime,DateTimeFormatter.ofPattern("HH:mm")).isAfter(updatedInitialTime.initialTime());
    }
    private boolean newTimeIsValid(String newInitialTime, DateTimeFormatter ofPattern) {
        try{
            LocalTime.parse(newInitialTime,ofPattern);
            return LocalTime.parse(newInitialTime,ofPattern).isAfter(LocalTime.of(6,59)) && LocalTime.parse(newInitialTime,ofPattern).isBefore(LocalTime.of(23,1));
        }catch (Exception e){
            return false;
        }
    }

    private boolean newWeekDayIsValid(String newWeekDay) {
        try{
            LectureWeekDay.valueOf(newWeekDay.substring(0,1).toUpperCase() + newWeekDay.substring(1).toLowerCase());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean newDateIsValid(String newDate, DateTimeFormatter ofPattern) {
        try{
            LocalDate.parse(newDate,ofPattern);
            return LocalDate.parse(newDate,ofPattern).isAfter(LocalDate.now()) || LocalDate.parse(newDate,ofPattern).isEqual(LocalDate.now());
        }catch (Exception e){
            return false;
        }
    }

    private CourseDTO goingToChangeCourse(CourseDTO course) {
        Iterable<CourseDTO> coursesOfTeacherIterator = listTeacherAppliedCoursesService.listTeacherAppliedCourses(authz.session());
        List<CourseDTO> courses= new ArrayList<>();
        coursesOfTeacherIterator.forEach(courses::add);
        CourseDTO selectedCourse=courseDTOSelectWidget(courses);
        showTeachingCourses(coursesOfTeacherIterator);
        if(selectedCourse!=null)
            return selectedCourse;
        else
            return course;
    }

    private void showTeachingCourses(@NotNull Iterable<CourseDTO> coursesOfTeacherIterator) {
        System.out.println("Your Teaching Courses");
        coursesOfTeacherIterator.forEach(courseDTOPrinter::visit);
    }
    private CourseDTO courseDTOSelectWidget(List<CourseDTO> courses) {
        final SelectWidget<CourseDTO> courseDTOSelectWidget =
                new SelectWidget<>("Courses to enroll\n", courses, new CourseDTOPrinter());
        courseDTOSelectWidget.show();
        return courseDTOSelectWidget.selectedElement();
    }

    private LectureType goingToChangeLectureType(LectureType lectureType) {
        EnumSelectWidget<LectureType> lectureTypeSelectWidget = new EnumSelectWidget<>("Lecture Types:", LectureType.class);
        lectureTypeSelectWidget.show();
        LectureType selectedLectureType = lectureTypeSelectWidget.selectedElement();
        if(selectedLectureType==null){
            System.out.println("No lecture type selected!");
            return lectureType;
        }
        return selectedLectureType;
    }

    private LectureDTO lectureDTOSelectWidget(List<LectureDTO> lectures) {
        final SelectWidget<LectureDTO> lectureDTOSelectWidget =
                new SelectWidget<>("Lectures to update\n", lectures, new LectureDTOPrinter());
        lectureDTOSelectWidget.show();
        return lectureDTOSelectWidget.selectedElement();
    }
    private Iterable<LectureDTO> teacherWeekSchedule() {
        return getTeacherScheduleService.getTeacherSchedule(authz.session());
    }

    @Override
    public String headline() {
        return "Update Lecture";
    }

}

