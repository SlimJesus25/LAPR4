/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.jpa;

import java.util.*;

import eapli.elearning.Application;
import eapli.elearning.elearningusermanagement.domain.ELearningUser;
import eapli.elearning.elearningusermanagement.domain.MecanographicNumber;
import eapli.elearning.elearningusermanagement.repositories.ELearningUserRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.RoleAssignment;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
class JpaClientUserRepository
        extends JpaAutoTxRepository<ELearningUser, MecanographicNumber, MecanographicNumber>
        implements ELearningUserRepository {

    public JpaClientUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JpaClientUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }

    @Override
    public Optional<ELearningUser> findByUsername(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<ELearningUser> findByMecanographicNumber(final MecanographicNumber number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.mecanographicNumber=:number", params);
    }

    @Override
    public Iterable<ELearningUser> findAllActive() {
        return match("e.systemUser.active = true");
    }

    @Override
    public List<Role> showRoles() {
        final TypedQuery<eapli.framework.infrastructure.authz.domain.model.Role> query = entityManager().createQuery(
                "SELECT DISTINCT r.type FROM RoleAssignment r", Role.class);
        return query.getResultList();
    }

}
