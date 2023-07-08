package eapli.elearning.app.backoffice.console.presentation.course;

import eapli.framework.actions.Action;

public class AddCourseAction implements Action {
    @Override
    public boolean execute() {
        return new AddCourseUI().show();
    }
}
