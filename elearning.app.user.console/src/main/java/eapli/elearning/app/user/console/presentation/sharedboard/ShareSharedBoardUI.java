package eapli.elearning.app.user.console.presentation.sharedboard;

import eapli.elearning.app.user.console.presentation.meeting.SystemUserPrinter;
import eapli.elearning.myelearninguser.application.ListStudentsAndTeachersUsersService;
import eapli.elearning.servermanagement.SendRequestService;
import eapli.elearning.sharedboardmanagement.application.ListOwnedAndActiveSharedBoardsService;
import eapli.elearning.sharedboardmanagement.application.ListUsersService;
import eapli.elearning.sharedboardmanagement.application.SendShareSharedBoardController;
import eapli.elearning.sharedboardmanagement.application.SendShareSharedBoardControllerImpl;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.elearning.usermanagement.domain.User;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShareSharedBoardUI extends AbstractUI {
    private final ListOwnedAndActiveSharedBoardsService listSharedBoardService = new ListOwnedAndActiveSharedBoardsService();
    private final SendRequestService svc = new SendRequestService();
    private final ListStudentsAndTeachersUsersService userSvc = new ListStudentsAndTeachersUsersService();
    @Override
    protected boolean doShow() {
        try {
            List<SharedBoardDTO> ownedSharedBoards = listSharedBoardService.listOwnedAndActiveSharedBoards();

            if (ownedSharedBoards.isEmpty()) {
                System.out.println("You don't have any active shared board!");
                return false;
            }

            System.out.println("Choose a board you own");
            final SelectWidget<SharedBoardDTO> sharedBoardDTOSelectWidget =
                    new SelectWidget<>("Shared Boards", ownedSharedBoards, new SharedBoardPrinter());
            sharedBoardDTOSelectWidget.show();
            SharedBoardDTO selectedSharedBoard = sharedBoardDTOSelectWidget.selectedElement();
            if (selectedSharedBoard == null) {
                System.out.println("Exiting...");
                return false;
            }
            List<UserPermission> up = new ArrayList<>();
            up.add(UserPermission.READ);
            up.add(UserPermission.WRITE);
            List<SystemUser> users = userSvc.listStudentsAndTeachersUsers();
            users.removeIf(user -> !(user.roleTypes().contains(ElearningRoles.TEACHER)
                    || user.roleTypes().contains(ElearningRoles.STUDENT)));

            System.out.println("Select users to invite");
            final SelectWidget<SystemUser> userDTOSelectWidget =
                    new SelectWidget<>("Users", users, new SystemUserPrinter());
            boolean keepChoosing = true;
            List<SystemUser> selectedUsers = new ArrayList<>();
            List<UserPermission> selectedPermissions = new ArrayList<>();
            while(keepChoosing) {
                userDTOSelectWidget.show();
                SystemUser selectedUser = userDTOSelectWidget.selectedElement();
                if (selectedUser == null) {
                    System.out.println("Exiting...");
                    return false;
                }
                selectedUsers.add(selectedUser);
                //Select a permission for this user
                System.out.println("Select the permission for this user:");
                final SelectWidget<UserPermission> userPermissionSelectWidget =
                        new SelectWidget<>("User Permission", up);
                userPermissionSelectWidget.show();
                UserPermission selectedUserPermission = userPermissionSelectWidget.selectedElement();

                if(selectedUserPermission == null) {
                    System.out.println("Exiting...");
                    return false;
                }
                selectedPermissions.add(selectedUserPermission);
                System.out.println("\nList of actual guests");
                for(SystemUser user : selectedUsers)
                    System.out.println(user.name());
                System.out.println("\n\nKeep selecting?\n1.Yes\n2.No");
                if(Console.readOption(1, 2, 0) == 2){
                    keepChoosing = false;
                }else {
                    users.remove(selectedUser);
                }
                String feedback = svc.sendShareSharedBoardRequest(selectedSharedBoard, selectedUsers, selectedPermissions);
                if(feedback.isEmpty()){
                    System.out.println("Shared board \"" + selectedSharedBoard.getSharedBoardTitle()
                            + "\" shared successfully!");
                }else{
                    System.out.println("An error occurred trying to archive the shared board: " + feedback);
                }
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }

        return false;
    }
    @Override
    public String headline () {
        return "Sharing the Shared Board";
    }
}
