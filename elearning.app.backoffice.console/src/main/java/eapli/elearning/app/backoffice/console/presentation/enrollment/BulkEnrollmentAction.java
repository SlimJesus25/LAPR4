package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.app.backoffice.console.presentation.elearninguser.AcceptRefuseSignupRequestUI;
import eapli.framework.actions.Action;

public class BulkEnrollmentAction implements Action {

    @Override
    public boolean execute() {
        return new BulkEnrollmentUI().show();
    }
}
