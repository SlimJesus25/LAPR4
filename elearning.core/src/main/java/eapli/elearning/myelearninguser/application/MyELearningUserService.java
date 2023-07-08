/*
 * Copyright (c) 2013-2023 the original author or authors.
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
package eapli.elearning.myelearninguser.application;

import java.util.Optional;

import eapli.elearning.elearningusermanagement.domain.ELearningUser;
import eapli.elearning.elearningusermanagement.repositories.ELearningUserRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


/**
 *
 * @author Paulo Gandra de Sousa
 */
@ApplicationService
public class MyELearningUserService {

	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final ELearningUserRepository repo = PersistenceContext.repositories().eLearningUsers();

	public ELearningUser me() {
		final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
		final SystemUser myUser = s.authenticatedUser();
		// TODO cache the client user object
		final Optional<ELearningUser> me = repo.findByUsername(myUser.identity());
		return me.orElseThrow(IllegalStateException::new);
	}

	private ELearningUser myUser() {
		authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.STUDENT);
		final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
		final SystemUser me = s.authenticatedUser();
		return repo.findByUsername(me.identity()).orElseThrow(IllegalStateException::new);
	}

}
