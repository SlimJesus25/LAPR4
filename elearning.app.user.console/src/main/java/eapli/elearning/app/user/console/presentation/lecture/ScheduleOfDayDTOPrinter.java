package eapli.elearning.app.user.console.presentation.lecture;

import eapli.elearning.lecturemanagement.domain.LectureInDayAndHourService;
import eapli.elearning.lecturemanagement.application.LectureIsOverlappingWithHourController;
import eapli.elearning.lecturemanagement.domain.LectureWeekDay;
import eapli.elearning.lecturemanagement.dto.LectureDTO;
import eapli.framework.visitor.Visitor;
import org.springframework.data.util.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleOfDayDTOPrinter implements Visitor<Pair<LectureWeekDay,List<LectureDTO>>> {
    LectureIsOverlappingWithHourController lectureIsOverlappingWithHour=new LectureIsOverlappingWithHourController();

    LectureInDayAndHourService lectureInDayAndHour=new LectureInDayAndHourService();
    @Override
    public void visit(Pair<LectureWeekDay,List<LectureDTO>> visitee) {
        ArrayList<LocalTime> times = populateTimes();
        System.out.println("=============================");
        System.out.println("       ||"+printWithNeededSpaces(visitee.getFirst())+"||       ");
        System.out.println("=============================");
        for (LocalTime time:times) {
            showHourScheduleInHour(time,visitee.getSecond(),visitee.getFirst());
            if(time.getHour()!=23) {
                showHourScheduleInHourInterval(time,visitee.getSecond(),visitee.getFirst());
                showOverlappingLectures(time,visitee.getSecond(),visitee.getFirst());
            }
        }
        System.out.println("=============================");
        System.out.println("       ||           ||");
    }

    private void showHourScheduleInHour(LocalTime time, List<LectureDTO> lectures, LectureWeekDay day) {
        System.out.print(" "+time+" ||");
        LectureDTO lecture =lectureInDayAndHour.lecturesInThisWeekDayAndHour(lectures, day,time);
        if(lecture!=null){
            if(lecture.getLectureInitialTime().initialTime().equals(time))
                System.out.print("|---------|||\n");
            else if(lecture.getLectureFinalTime().finalTime().equals(time))
                System.out.print("|---------|||\n");
            else if(lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time))
                System.out.print(writeWhenLectureOccurring(lecture));
            else
                System.out.print("           ||\n");
        }
        else
            System.out.print("           ||\n");
    }
    private void showHourScheduleInHourInterval(LocalTime time, List<LectureDTO> lectures, LectureWeekDay day) {
        System.out.print("       ||");
        LectureDTO lecture =lectureInDayAndHour.lecturesInThisWeekDayAndHour(lectures, day,time);
        if(lecture!=null){
            if(lecture.getLectureInitialTime().initialTime().equals(time))
                System.out.print(writeWhenLectureOccurring(lecture));
            else if(lecture.getLectureFinalTime().finalTime().equals(time))
                System.out.print("           ||\n");
            else if(lecture.getLectureInitialTime().initialTime().isBefore(time) && lecture.getLectureFinalTime().finalTime().isAfter(time))
                System.out.print(writeWhenLectureOccurring(lecture));
            else
                System.out.print("           ||\n");
        }
        else
            System.out.print("           ||\n");
    }
    private void showOverlappingLectures(LocalTime time, List<LectureDTO> lectures, LectureWeekDay weekDay) {
        List<LectureDTO> listLectures= lectureInDayAndHour.lecturesInThisWeekDay(lectureInDayAndHour.lecturesStartingOrEndingInInterval(lectures, time,LocalTime.of(time.getHour()+1,0)),weekDay);

            for (LectureDTO lecture:listLectures) {
                LocalTime overlappingTime=lectureIsOverlappingWithHour.lectureIsOverlappingWithHour(time,lecture);
                if(overlappingTime!=null){
                    showHourScheduleInHour(overlappingTime,listLectures,weekDay);
                    showHourScheduleInHourInterval(overlappingTime,listLectures,weekDay);
                }
            }

    }
    private String printWithNeededSpaces(LectureWeekDay lectureWeekDay) {
        String day=lectureWeekDay.name();
        while(day.length()<11) {
            if(day.length()<9)
                day=" "+day+" ";
            else
                day=day+" ";
        }
        return day;
    }

    private ArrayList<LocalTime> populateTimes() {
        ArrayList<LocalTime> times=new ArrayList<>();
        for (int hour = 7; hour <= 23; hour++) {
            times.add(LocalTime.of(hour, 0));
        }
        return times;
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
        toWrite = toWrite + "||\n";
        return toWrite;
    }
}
