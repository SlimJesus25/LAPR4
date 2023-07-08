package eapli.elearning.usermanagement.repository;

import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface SystemUserRepository extends DomainRepository<Username, SystemUser> {
    public SystemUser findSystemUserByUsername(String username);
    public Iterable<SystemUser> listUsersByRole(Role role);
}
