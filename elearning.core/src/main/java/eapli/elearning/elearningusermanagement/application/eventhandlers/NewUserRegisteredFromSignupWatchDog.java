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
package eapli.elearning.elearningusermanagement.application.eventhandlers;

import eapli.elearning.elearningusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.eventpubsub.EventHandler;
import eapli.framework.validations.Preconditions;

/**
 * @author Paulo Gandra de Sousa
 *
 */
public class NewUserRegisteredFromSignupWatchDog implements EventHandler {

	/*
	 * (non-Javadoc)
	 *
	 * @see eapli.framework.domain.events.EventHandler#onEvent(eapli.framework.
	 * domain. events.DomainEvent)
	 */
	@Override
	public void onEvent(final DomainEvent domainevent) {
		Preconditions.ensure(domainevent instanceof NewUserRegisteredFromSignupEvent);

		assert domainevent instanceof NewUserRegisteredFromSignupEvent;
		final NewUserRegisteredFromSignupEvent event = (NewUserRegisteredFromSignupEvent) domainevent;

		final var controller = new AddCafeteriaUserOnSignupAcceptedController();
		controller.addStudentUser(event);
	}
}
