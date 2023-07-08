package eapli.elearning.usermanagement.application;

import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private final SystemUserRepository repo = PersistenceContext.repositories().systemUsers();
    public Iterable<GeneralDTO> listUserByRole(Role role) {
        Iterable<SystemUser> result = repo.listUsersByRole(role);
        List<GeneralDTO> finalResult = new ArrayList<>();
        for (SystemUser a: result) {
            if (a.roleTypes().contains(role)){
                finalResult.add(a.toDTO());
            }
        }
        return finalResult;
    }
}
