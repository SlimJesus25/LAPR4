package eapli.elearning.usermanagement.application;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.GeneralDTO;

public class ListUsersByRoleController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final IUserService service = new UserService();

    public Iterable<GeneralDTO> listUsersByRole(Role role) {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.ADMINISTRATOR);
        return service.listUserByRole(role);
    }
}
