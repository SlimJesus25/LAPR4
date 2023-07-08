package eapli.elearning.app.backoffice.console.presentation.enrollment;

import eapli.elearning.app.backoffice.console.presentation.elearninguser.AcceptRefuseSignupRequestUI;
import eapli.elearning.courseenrollmentmanagement.application.BulkStudentEnrollmentController;
import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupFactory;
import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.elearning.elearningusermanagement.domain.SignupRequest;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BulkEnrollmentUI extends AbstractUI {
    private final BulkStudentEnrollmentController theController = new BulkStudentEnrollmentController();

    @Override
    protected boolean doShow() {
        final String filepath = Console.readLine("File Path:");
        if(filepath.isEmpty() || filepath.isBlank()){
            System.out.println("Please insert the correct File Path!");
            return false;
        }
        try {
            File ficheiro = new File(filepath);
            if(!ficheiro.exists()){
                System.out.println("Please insert the correct File Path!");
                return false;
            }
            ArrayList<String> erros = this.theController.enrollStudents(new File(filepath));
            if(erros.size()==0){
                System.out.println("There was no errors while reading the file, every student was successfully enrolled");
            }
            for (int i = 0; i < erros.size(); i++) {
                System.out.println(erros.get(i));
            }
       } catch (Exception e) {
            System.out.println("That filename is invalid!");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Bulk Enrollment of Students by CSV";
    }
}
