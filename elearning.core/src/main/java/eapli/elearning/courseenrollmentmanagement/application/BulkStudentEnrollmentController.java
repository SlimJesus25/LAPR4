package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.util.ArrayList;

public class BulkStudentEnrollmentController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private ReadBulkStudentEnrollmentCSVService readBulStudentEnrollmentCSVService = new ReadBulkStudentEnrollmentCSVService();

    public ArrayList<String> enrollStudents(File file){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.ADMINISTRATOR);
        return readBulStudentEnrollmentCSVService.bulkRegisterStudents(file);

    }
}
