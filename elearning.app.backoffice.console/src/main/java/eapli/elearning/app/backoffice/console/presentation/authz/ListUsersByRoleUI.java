package eapli.elearning.app.backoffice.console.presentation.authz;

import eapli.elearning.app.backoffice.console.presentation.course.TeacherDTOPrinter;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.elearningusermanagement.application.ShowRolesService;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.usermanagement.application.ListUsersByRoleController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.LinkedList;
import java.util.List;

public class ListUsersByRoleUI extends AbstractUI {
    ShowRolesService svc = new ShowRolesService();
    ListUsersByRoleController theController = new ListUsersByRoleController();
    @Override
    protected boolean doShow() {

        List<Role> roles = svc.showRoles();
        System.out.println("Select a role to show the users ");
        final SelectWidget<Role> roleSelectWidget =
                new SelectWidget<>("All Roles: ", roles, new RolesPrinter());

        roleSelectWidget.show();
        Role selectedRole = roleSelectWidget.selectedElement();
        if (selectedRole == null) {
            System.out.println("Exiting...");
            return false;
        }
        try {
            Iterable<GeneralDTO> users = this.theController.listUsersByRole(selectedRole);
            for (GeneralDTO a:users) {
                System.out.println(a.values());
            }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("There is no users with that role");
        }
        System.out.println("Success!");
        return false;
    }

    @Override
    public String headline() {
        return "List Users by Role";
    }
}
