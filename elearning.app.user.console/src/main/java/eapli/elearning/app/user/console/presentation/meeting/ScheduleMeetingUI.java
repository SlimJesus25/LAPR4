package eapli.elearning.app.user.console.presentation.meeting;

import eapli.elearning.meetingmanagement.application.ScheduleMeetingController;
import eapli.elearning.meetingmanagement.application.ScheduleMeetingControllerImpl;
import eapli.elearning.meetingmanagement.domain.Meeting;
import eapli.elearning.meetingparticipationmanagement.application.AddParticipationToMeetingController;
import eapli.elearning.myelearninguser.application.ListStudentsAndTeachersUsersService;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ScheduleMeetingUI extends AbstractUI {

    private final ScheduleMeetingController scheduleMeetingController = new ScheduleMeetingControllerImpl();
    private final AddParticipationToMeetingController addParticipationController = new AddParticipationToMeetingController();
    private final ListStudentsAndTeachersUsersService listStudentsAndTeachersUsersService
            = new ListStudentsAndTeachersUsersService();
    @Override
    protected boolean doShow() {

        String meetingName = Console.readNonEmptyLine("Name of the meeting", "Meeting");
        Calendar day = Console.readCalendar("Date (dd/MM/yyyy)", "dd/MM/yyyy");
        String time = Console.readNonEmptyLine("Hour to start (between 00:00 and 23:59)", "");
        String[] divisors = time.split(":");

        // This Calendar.MONTH + 1 exists due a Java issue/bug that months are indexed from 0 and not 1.
        LocalDateTime meetingDateNTime = LocalDateTime.of(LocalDate.of(day.get(Calendar.YEAR),
                day.get(Calendar.MONTH) + 1, day.get(Calendar.DAY_OF_MONTH)), LocalTime.of(Integer.parseInt(divisors[0]),
                Integer.parseInt(divisors[1])));

        int meetingDuration = Console.readInteger("Duration of the meeting (in minutes)");

        List<SystemUser> users = listStudentsAndTeachersUsersService.listStudentsAndTeachersUsers();
        users.removeIf(user -> !(user.roleTypes().contains(ElearningRoles.TEACHER)
                || user.roleTypes().contains(ElearningRoles.STUDENT)));

        System.out.println("Select users to invite");
        final SelectWidget<SystemUser> userDTOSelectWidget =
                new SelectWidget<>("Users", users, new SystemUserPrinter());
        boolean keepChoosing = true;
        List<SystemUser> selectedUsers = new LinkedList<>();
        while(keepChoosing) {
            userDTOSelectWidget.show();
            SystemUser selectedUser = userDTOSelectWidget.selectedElement();
            if (selectedUser == null) {
                System.out.println("Exiting...");
                return false;
            }
            selectedUsers.add(selectedUser);
            System.out.println("\nList of actual guests");
            for(SystemUser user : selectedUsers)
                System.out.println(user.name());
            System.out.println("\n\nKeep selecting?\n1.Yes\n2.No");
            if(Console.readOption(1, 2, 0) == 2){
                keepChoosing = false;
            }else {
                users.remove(selectedUser);
            }
        }

        try {
            Map<SystemUser, Boolean> avaliability = scheduleMeetingController.
                    checkUsersAvailability(meetingDateNTime, meetingDuration, selectedUsers);
            int low=1, high=1;
            System.out.println("\tGuests Availability\n");
            avaliability.forEach((u, c) -> System.out.println(u.name() + "->" + (c ? "Available" : "Not available")));
            System.out.println("\n1.Proceed to invite all users");
            if(avaliability.containsValue(false)){
                System.out.println("2.Invite only the available ones");
                high = 2;
            }
            System.out.println("0.Exit");
            int inviteOption = Console.readOption(low, high, 0);
            LinkedList<SystemUser> guests = new LinkedList<>();

            if(inviteOption == 1){
                avaliability.forEach((u, b) -> guests.add(u));
            }else if(inviteOption == 2){
                avaliability.forEach((u, b) -> {if(b)guests.add(u);} );
            }else{
                System.out.println("The meeting was not scheduled");
                return false;
            }

            Meeting m = scheduleMeetingController.scheduleMeeting(meetingName, meetingDateNTime, meetingDuration);

            guests.forEach(e -> addParticipationController.addParticipationToMeeting(m, e));

//            guests.forEach(e -> {
//                if(e.equals(guests.getLast())){
//                    addParticipationController.addParticipationOwnerToMeeting(m, e);
//                }else{
//                    addParticipationController.addParticipationToMeeting(m, e);
//                }
//            });

            System.out.println("The meeting with the name " + meetingName + " is scheduled for " + meetingDateNTime +
                    " with the duration of " + meetingDuration + " minutes");
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Schedule meeting";
    }
}
