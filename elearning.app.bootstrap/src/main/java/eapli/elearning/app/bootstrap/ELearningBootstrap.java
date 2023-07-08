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
package eapli.elearning.app.bootstrap;

import eapli.elearning.app.common.console.ELearningBaseApplication;
import eapli.elearning.elearningusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.elearning.elearningusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.elearning.elearningusermanagement.domain.events.SignupAcceptedEvent;
import eapli.elearning.infrastructure.bootstrapers.ELearningBootstrapper;
import eapli.elearning.infrastructure.bootstrapers.demo.ELearningDemoBootstrapper;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.infrastructure.smoketests.ELearningDemoSmokeTester;
import eapli.elearning.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import eapli.elearning.usermanagement.domain.ElearningPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import eapli.framework.io.util.Console;
import eapli.framework.util.ArrayPredicates;

/**
 * eCafeteria Bootstrapping data app
 */
@SuppressWarnings("squid:S106")
public final class ELearningBootstrap extends ELearningBaseApplication {

	private boolean isToBootstrapDemoData;
	private boolean isToRunSampleE2E;
	private boolean isToWaitInTheEnd;

	/**
	 * avoid instantiation of this class.
	 */
	private ELearningBootstrap() {
	}

	public static void main(final String[] args) {

		new ELearningBootstrap().run(args);
	}

	@Override
	protected void doMain(final String[] args) {
		handleArgs(args);

		System.out.println("\n\n------- MASTER DATA -------");
		new ELearningBootstrapper().execute();

		System.out.println("\n\n------- DEMO DATA -------");
		new ELearningDemoBootstrapper().execute();

		if (isToRunSampleE2E) {
			System.out.println("\n\n------- BASIC SCENARIO -------");
			new ELearningDemoSmokeTester().execute();
		}

		if (isToWaitInTheEnd) {
			Console.readLine("\n\n>>>>>> Enter to finish the program.");
		}
	}

	private void handleArgs(final String[] args) {
		isToRunSampleE2E = ArrayPredicates.contains(args, "-smoke:basic");
		if (isToRunSampleE2E) {
			isToBootstrapDemoData = true;
		} else {
			isToBootstrapDemoData = ArrayPredicates.contains(args, "-bootstrap:demo");
		}

		isToWaitInTheEnd = ArrayPredicates.contains(args, "-wait");
	}

	@Override
	protected String appTitle() {
		return "Bootstrapping eLearning data ";
	}

	@Override
	protected String appGoodbye() {
		return "Bootstrap data done.";
	}

	@Override
	protected void configureAuthz() {
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new ElearningPasswordPolicy(),
				new PlainTextEncoder());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
		dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(), NewUserRegisteredFromSignupEvent.class);
		dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
	}
}
