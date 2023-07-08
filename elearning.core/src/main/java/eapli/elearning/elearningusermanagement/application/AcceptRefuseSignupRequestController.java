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
package eapli.elearning.elearningusermanagement.application;

import eapli.elearning.elearningusermanagement.domain.ELearningUser;
import eapli.elearning.elearningusermanagement.domain.SignupRequest;

/**
 * The controller for the use case "Accept or refuse signup request".
 *
 * <p/>
 * Approving a signup request needs to create/change more than one aggregate
 * instance (i.e.
 * {@link ELearningUser CafeteriaUser}
 * and
 * {@link eapli.elearning.elearningusermanagement.domain.SignupRequest SignupRequest}),
 * as such it violates the rule that one controller should only create/change
 * one aggregate instance.
 *
 * <p/>
 * We provide two implementations of this controller for comparison of different
 * approaches. The (traditional) approach
 * {@link AcceptRefuseSignupRequestControllerTxImpl} creates a wrapping
 * transaction and performs the needed steps inside that transaction. It makes
 * it simple to develop and understand but hardcodes the process and fails the
 * Single Responsibility Principle (SRP) as now this class will have more than
 * one reason to change.
 * </p>
 * <p>
 * The other approach {@link AcceptRefuseSignupRequestControllerEventfulImpl}
 * uses events (i.e.
 * {@link eapli.elearning.elearningusermanagement.domain.events.NewUserRegisteredFromSignupEvent
 * NewUserRegisteredFromSignupEvent},
 * {@link eapli.elearning.elearningusermanagement.domain.events.SignupAcceptedEvent
 * SignupAcceptedEvent})
 * to decouple the different steps of the process. This makes
 * the system more flexible if there is the need to change the actual
 * process, enforces the SRP, but increases the complexity, e.g., there is
 * the need to have an event bus, there is no global
 * status, if something fails in the middle of the process it is not easy to
 * compensate (rollback) and there is no temporal coupling so the system needs
 * to handle "waiting" for something to happen before proceeding (see
 * {@link eapli.elearning.elearningusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog
 * NewUserRegisteredFromSignupWatchDog}
 * and
 * {@link eapli.elearning.elearningusermanagement.application.eventhandlers.AddCafeteriaUserOnSignupAcceptedController
 * AddCafeteriaUserOnSignupAcceptedController})
 *
 * @author Paulo Gandra de Sousa
 */
public interface AcceptRefuseSignupRequestController {

    SignupRequest acceptSignupRequest(SignupRequest theSignupRequest);

    SignupRequest refuseSignupRequest(SignupRequest theSignupRequest);

    Iterable<SignupRequest> listPendingSignupRequests();
}