package eapli.elearning.app.backoffice.console.presentation.enrollment;


import eapli.framework.actions.Action;

public class SetTeachersAction implements Action {

    @Override
    public boolean execute() {
        return new SetTeachersUI().show();
    }
}

