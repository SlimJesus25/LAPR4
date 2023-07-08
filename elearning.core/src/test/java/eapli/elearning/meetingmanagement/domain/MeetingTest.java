package eapli.elearning.meetingmanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class MeetingTest {

    @Test
    public void ensureMeetingNameCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(60
                , LocalDateTime.of(LocalDate.of(2024, 10, 10), LocalTime.of(10, 0))
                , ""));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(60
                , LocalDateTime.of(LocalDate.of(2024, 10, 10), LocalTime.of(10, 0))
                , null));
    }

    @Test
    public void ensureMeetingDurationCantBeNullNegativeOrLongerThanADay(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(-50
                , LocalDateTime.of(LocalDate.of(2024, 10, 10), LocalTime.of(10, 0))
                , "Test"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(24*60
                , LocalDateTime.of(LocalDate.of(2024, 10, 10), LocalTime.of(10, 0))
                , "Test"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(null
                , LocalDateTime.of(LocalDate.of(2024, 10, 10), LocalTime.of(10, 0))
                , "Test"));
    }

    @Test
    public void ensureMeetingDateTimeCantBeNullOrBeforeActualDateTime(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(15
                , null
                , "Test"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Meeting(15
                , LocalDateTime.of(LocalDate.of(2022, 10, 10), LocalTime.of(10, 0))
                , "Test"));
    }

    @Test
    public void ensureMeetingIsCancelable(){
        Meeting meeting = new Meeting(30, LocalDateTime.of(LocalDate.of(2024, 10, 10)
                , LocalTime.of(10, 0)), "Test");

        meeting.cancelMeeting();

        Assertions.assertSame(meeting.state(), MeetingState.CANCELED);
    }

    @Test
    public void ensureMeetingCantBeCanceledIfAlreadyOccurred() throws InterruptedException {
        Meeting meeting = new Meeting(30, LocalDateTime.now().plusSeconds(1), "Test");
        Thread.sleep(2000);
        Assertions.assertThrows(IllegalArgumentException.class, meeting::cancelMeeting);

    }

    @Test
    public void ensureMeetingCantBeCanceledIfAlreadyCanceled(){
        Meeting meeting = new Meeting(30, LocalDateTime.of(LocalDate.of(2024, 10, 10)
                , LocalTime.of(10, 0)), "Test");

        meeting.cancelMeeting();

        Assertions.assertThrows(IllegalArgumentException.class, meeting::cancelMeeting);
    }
}
