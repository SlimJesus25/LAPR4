/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.elearning.infrastructure.bootstrapers.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupFactory;
import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupRequestControllerEventfulImpl;
import eapli.elearning.elearningusermanagement.application.AcceptRefuseSignupRequestControllerTxImpl;
import eapli.elearning.elearningusermanagement.domain.SignupRequest;
import eapli.elearning.infrastructure.bootstrapers.TestDataConstants;
import eapli.elearning.myelearninguser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 * Bootstrapper that demonstrates how a Cafeteria User can be added to the
 * system.
 * <p>
 * If application property {@code UseEventfulControllers} is set to
 * {@code false}, than the {@link AcceptRefuseSignupRequestController} uses an
 * fully transactional (eventless) controller
 * {@link AcceptRefuseSignupRequestControllerTxImpl}.
 * <p>
 * If application property {@code UseEventfulControllers} is set to
 * {@code true}, than the {@link AcceptRefuseSignupRequestController} uses an
 * eventful controller {@link AcceptRefuseSignupRequestControllerEventfulImpl}.
 *
 * @author Paulo Sousa
 */
public class ELearningUserBootstrapper implements Action {
	private static final Logger LOGGER = LogManager.getLogger(ELearningUserBootstrapper.class);

	private final SignupController signupController = new SignupController();
	private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory.build();

	@Override
	public boolean execute() {
		// signup a couple of users and accept them so they can be used imediately in
		// the User app
		signupAndApprove(TestDataConstants.USER_TEST1, TestDataConstants.PASSWORD1, "John", "Smith", "john@smith.com",
				TestDataConstants.USER_TEST1);
		signupAndApprove(TestDataConstants.USER_TEST2, TestDataConstants.PASSWORD1, "Mary", "Smith", "mary@smith.com",
				TestDataConstants.USER_TEST2);
		// make a bunch of signups but leave them for approval so the backoffice user
		// will aprove them
		signup("isep111", TestDataConstants.PASSWORD1, "John", "Smith One", "john1@smith.com", "isep111");
		signup("isep222", TestDataConstants.PASSWORD1, "Mary", "Smith Two", "mary2@smith.com", "isep222");
		signup("isep333", TestDataConstants.PASSWORD1, "Mary", "Smith Three", "mary3@smith.com", "isep333");

		return true;
	}

	private SignupRequest signup(final String username, final String password, final String firstName,
			final String lastName, final String email, final String mecanographicNumber) {
		return doSignupAndApprove(username, password, firstName, lastName, email, mecanographicNumber, false);
	}

	private SignupRequest signupAndApprove(final String username, final String password, final String firstName,
			final String lastName, final String email, final String mecanographicNumber) {
		return doSignupAndApprove(username, password, firstName, lastName, email, mecanographicNumber, true);
	}

	private SignupRequest doSignupAndApprove(final String username, final String password, final String firstName,
			final String lastName, final String email, final String mecanographicNumber, boolean approve) {
		SignupRequest request = null;
		try {
			request = signupController.signup(username, password, firstName, lastName, email, mecanographicNumber);
			if (approve) {
				acceptController.acceptSignupRequest(request);
			}
		} catch (final ConcurrencyException | IntegrityViolationException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated user
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
			LOGGER.trace("Assuming existing record", e);
		}
		return request;
	}
}
