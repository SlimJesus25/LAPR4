package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.enterprise.inject.Typed;
import javax.persistence.TypedQuery;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaSystemUserRepository extends JpaAutoTxRepository<SystemUser, Username, Username> implements SystemUserRepository {

    public JpaSystemUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "username");
    }

    public JpaSystemUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "username");
    }
    @Override
    public SystemUser findSystemUserByUsername(String username) {
        TypedQuery<SystemUser> query = entityManager().createQuery("SELECT a FROM SystemUser a WHERE upper(a.username) like" +
                " upper(:username)", SystemUser.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public Iterable<SystemUser> listUsersByRole(Role role) {
        return findAll();
    }

}
