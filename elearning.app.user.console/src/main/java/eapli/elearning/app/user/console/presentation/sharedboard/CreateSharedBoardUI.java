package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.app.user.console.presentation.meeting.SystemUserPrinter;
import eapli.elearning.myelearninguser.application.ListStudentsAndTeachersUsersService;
import eapli.elearning.sharedboardmanagement.application.CreateSharedBoardController;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.application.CreateSharedBoardParticipantionController;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateSharedBoardUI extends AbstractUI {
    private CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    private final ListStudentsAndTeachersUsersService listStudentsAndTeachersUsersService
            = new ListStudentsAndTeachersUsersService();
    private CreateSharedBoardParticipantionController createSharedBoardParticipantionController
            = new CreateSharedBoardParticipantionController();
    @Override
    protected boolean doShow() {
        final String title = Console.readLine("Shared board title");
        final LocalDateTime creation = LocalDateTime.now();

        /*
        List<SystemUser> users = listStudentsAndTeachersUsersController.listStudentsAndTeachersUsers();
        users.removeIf(user -> !(user.roleTypes().contains(ElearningRoles.TEACHER)
                || user.roleTypes().contains(ElearningRoles.STUDENT)));

        System.out.println("Select users to invite");
        final SelectWidget<SystemUser> userDTOSelectWidget =
                new SelectWidget<>("Users", users, new SystemUserPrinter());
        boolean keepChoosing = true;
        List<SystemUser> selectedUsers = new ArrayList<>();
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
        */

        try {
            SharedBoard sharedBoard = createSharedBoardController.createSharedBoard(title, creation);
            //createSharedBoardParticipantionController.createSharedBoardParticipation(selectedUsers, sharedBoard);
            createSharedBoardParticipantionController.createSharedBoardParticipationOwner(sharedBoard);
            System.out.println("Shared board created successfully!\n");
        } catch (Exception e) {
            System.out.println("Shared board not created: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create a Shared Board!";
    }
}
