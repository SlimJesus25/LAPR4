package eapli.elearning.app.user.console.presentation.meeting;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SystemUserPrinter implements Visitor<SystemUser> {

    @Override
    public void visit(SystemUser visitee) {
        System.out.println("User: " + visitee.name());
    }
}
