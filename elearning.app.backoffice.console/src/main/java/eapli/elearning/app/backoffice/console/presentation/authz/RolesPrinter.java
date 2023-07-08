package eapli.elearning.app.backoffice.console.presentation.authz;

import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.visitor.Visitor;

public class RolesPrinter implements Visitor<Role> {
    @Override
    public void visit(Role visitee) {
        System.out.println(visitee.toString());
    }
}
