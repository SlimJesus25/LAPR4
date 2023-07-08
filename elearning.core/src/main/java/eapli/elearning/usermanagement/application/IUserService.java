package eapli.elearning.usermanagement.application;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.GeneralDTO;

public interface IUserService {
    Iterable<GeneralDTO> listUserByRole(Role role);
}
