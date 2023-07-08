package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.application.LectureIsOverlappingWithHourController;
import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.visitor.Visitor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTOPrinter implements Visitor<Iterable<LectureDTO>> {
    LectureInDayAndHourService lectureInDayAndHour=new LectureInDayAndHourService();
    LectureIsOverlappingWithHourController lectureIsOverlappingWithHour=new LectureIsOverlappingWithHourController();
    @Override
    public void visit(Iterable<LectureDTO> visitee) {
        ArrayList<LocalTime> times = populateTimes();
        System.out.println("============================================================================================================");
        System.out.println("       ||   Monday  ||  Tuesday  || Wednesday ||  Thursday ||   Friday  ||  Saturday ||  Sunday   ||       ");
        System.out.println("============================================================================================================");
        for (LocalTime time:times) {
            showHourSchedule(time,visitee);
        }
        System.out.println("============================================================================================================");
        System.out.println("       ||           ||           ||           ||           ||           ||           ||           ||           ");

    }

    private void showHourSchedule(LocalTime time, Iterable<LectureDTO> visitee) {
        List<LectureDTO> lecturesRelevantToHour= lectureInDayAndHour.getLecturesRelevantToHour(time,visitee);
        showHourScheduleInHour(time,lecturesRelevantToHour);
        if(time.getHour()!=23) {
            showHourScheduleInHourInterval(time, lecturesRelevantToHour);
            showOverlappingLectures(time, lecturesRelevantToHour);
        }
    }

    private void showOverlappingLectures(LocalTime time, List<LectureDTO> lecturesRelevantToHour) {
        for (LectureDTO lecture: lecturesRelevantToHour) {
            LocalTime overlappingTime=lectureIsOverlappingWithHour.lectureIsOverlappingWithHour(time,lecture);
            if(overlappingTime!=null){
                showHourScheduleInHour(overlappingTime,lecturesRelevantToHour);
                showHourScheduleInHourInterval(overlappingTime,lecturesRelevantToHour);
            }
        }
    }




    private void showHourScheduleInHourInterval(LocalTime time, List<LectureDTO> lecturesRelevantToHour) {
        for (LectureWeekDay day: LectureWeekDay.values()) {
            if(day.equals(LectureWeekDay.Monday))
                System.out.print("       ||");
            LectureDTO lecture =lectureInDayAndHour.lectureInThisWeekDay(lecturesRelevantToHour, day);
            if(lecture!=null){
                if(lecture.getLectureInitialTime().initialTime().equals(time)) {
                    System.out.print(writeWhenLectureOccurring(lecture));
                  }
                else if(lecture.getLectureFinalTime().finalTime().equals(time))
                    System.out.print("           ||");
                else if(lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time))
                    System.out.print(writeWhenLectureOccurring(lecture));
                else
                    System.out.print("           ||");
            }
            else
                System.out.print("           ||");
        }
        System.out.print("\n");
    }

    private String writeWhenLectureOccurring(LectureDTO lecture) {
        String toWrite = lecture.getCourse().getCourseTitle() + "-" + lecture.getLectureType().name();
        int neededSpaces= 11-toWrite.length();
            while (neededSpaces>0){
                if(neededSpaces>1) {
                    toWrite = " " + toWrite + " ";
                    neededSpaces-=2;
                }
                else{
                    toWrite = toWrite + " ";
                    neededSpaces--;
                    }
            }
            toWrite = toWrite + "||";
        return toWrite;
    }

    private void showHourScheduleInHour(LocalTime time, List<LectureDTO> lecturesRelevantToHour) {
        for (LectureWeekDay day: LectureWeekDay.values()) {
            if(day.equals(LectureWeekDay.Monday))
                System.out.print(" "+time+" ||");
            LectureDTO lecture =lectureInDayAndHour.lectureInThisWeekDay(lecturesRelevantToHour, day);
            if(lecture!=null){
                if(lecture.getLectureInitialTime().initialTime().equals(time))
                    System.out.print("|---------|||");
                else if(lecture.getLectureFinalTime().finalTime().equals(time))
                    System.out.print("|---------|||");
                else if(lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time))
                    System.out.print(writeWhenLectureOccurring(lecture));
                else
                    System.out.print("           ||");
            }
            else
                System.out.print("           ||");
        }
        System.out.print("\n");
    }


    private ArrayList<LocalTime> populateTimes() {
        ArrayList<LocalTime> times=new ArrayList<>();
        for (int hour = 7; hour <= 23; hour++) {
            times.add(LocalTime.of(hour, 0));
        }
        return times;
    }
}
