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

import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.strings.util.Strings;
import eapli.framework.validations.Invariants;

/**
 * eCafeteria Bootstrapping Demo data. This class bootstraps data for demo
 * purposes. It's main purpose is to avoid entering data in the UI while testing
 * and speedup the process.
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings("squid:S106")
public class ELearningDemoBootstrapper implements Action {

	private static final String POWERUSER_A1 = "poweruserA1";
	private static final String POWERUSER = "poweruser";

	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();

	@Override
	public boolean execute() {
		// declare bootstrap actions
		final Action[] actions = { new BackofficeUsersBootstrapper(), new StudentBootstrapper()
				, new ELearningUserBootstrapper(), new TeacherBootstrapper(), new CourseBootstrapper()
				, new LectureBootstrapper(), new ExtraLectureBootstrapper(), new ExtraLectureParticipantBootstrapper()
				, new CourseEnrollmentBootstrapper(), new MeetingBootstrapper(), new TeamElementBootstrapper()
				, new ExamBootstrapper(), new SharedBoardBootstrapper(), new FormerExamBootstrapper()};

		authenticateForBootstrapping();

		// execute all bootstrapping
		boolean ret = true;
		for (final Action boot : actions) {
			System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
			ret &= boot.execute();
		}
		return ret;
	}

	/**
	 * authenticate a super user to be able to register new users
	 *
	 */
	protected void authenticateForBootstrapping() {
		authenticationService.authenticate(POWERUSER, POWERUSER_A1);
		Invariants.ensure(authz.hasSession());
	}

	private String nameOfEntity(final Action boot) {
		final String name = boot.getClass().getSimpleName();
		return Strings.left(name, name.length() - "Bootstrapper".length());
	}
}
