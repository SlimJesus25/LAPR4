/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.elearning.app.backoffice.console.presentation.authz;

import java.util.*;

import eapli.elearning.app.backoffice.console.presentation.course.TeacherDTOPrinter;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.elearningusermanagement.application.ShowRolesService;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.usermanagement.application.AddUserController;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.EnumSelectWidget;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * UI for adding a user to the application.
 *
 * Gabriel Costa e Silva
 */
@SuppressWarnings("java:S106")
public class AddUserUI extends AbstractUI {

    private final AddUserController theController = new AddUserController();
    private final ShowRolesService svc = new ShowRolesService();
    @Override
    protected boolean doShow() {
        final String username = Console.readLine("Username");
        final String password = Console.readLine("Password");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String email = Console.readLine("E-Mail");

        //final String mechanographicalNumber = Console.readLine("Mechanographical Number");

        List<Role> roles = svc.showRoles();
        System.out.println("Select roles for the user: ");

        final SelectWidget<Role> roleSelectWidget =
                new SelectWidget<>("All Roles: ", roles, new RolesPrinter());

        List<Role> selectedRoles = new LinkedList<>();

        //
        boolean keepChoosing = true;
        while(keepChoosing) {
            roleSelectWidget.show();
            Role selectedRole = roleSelectWidget.selectedElement();
            if (selectedRole == null) {
                System.out.println("Exiting...");
                return false;
            }
            selectedRoles.add(selectedRole);
            System.out.println("\nList of actual roles");
            for(Role role : selectedRoles)
                System.out.println(role.toString());
            System.out.println("\n\nKeep selecting?\n1.Yes\n2.No");
            if(Console.readOption(1, 2, 0) == 2){
                keepChoosing = false;
            }else {
                roles.remove(selectedRole);
            }
        }
        //


        //System.out.println("Select the role of the USER: ");
        //final Set<Role> roleTypes = new HashSet<>();
        //Add enum widget
        /*
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);
        roleTypes.add(ElearningRoles.ELEARNING_USER);
         */
        try {
            this.theController.addUser(username, password, firstName, lastName, email, selectedRoles);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("That username is already in use.");
        }
        System.out.println("Success!");
        return false;
    }

    /*
    private boolean showRoles(final Set<Role> roleTypes) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 0;
        rolesMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final Role roleType : theController.getRoleTypes()) {
            rolesMenu.addItem(
                    MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }
    /*

     */
    @Override
    public String headline() {
        return "Add User";
    }
}
