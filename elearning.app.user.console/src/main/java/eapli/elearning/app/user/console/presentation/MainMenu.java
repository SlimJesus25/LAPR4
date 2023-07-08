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
package eapli.elearning.app.user.console.presentation;

import eapli.elearning.app.common.console.presentation.authz.MyUserMenu;
import eapli.elearning.app.user.console.presentation.formerexam.TakeExamUI;
import eapli.elearning.app.user.console.presentation.formerexam.TakeFormativeExamUI;
import eapli.elearning.app.user.console.presentation.exam.*;
import eapli.elearning.app.user.console.presentation.exam.AddUpdadeQuestionUI;
import eapli.elearning.app.user.console.presentation.exam.CreateUpdateAutomaticFormativeExamUI;
import eapli.elearning.app.user.console.presentation.course.ListCoursesAvailableUI;
import eapli.elearning.app.user.console.presentation.extralecture.CreateExtraordinaryLectureUI;
import eapli.elearning.app.user.console.presentation.lecture.CreateLectureUI;
import eapli.elearning.app.user.console.presentation.meeting.AnswerMeetingInvitationUI;
import eapli.elearning.app.user.console.presentation.meeting.CancelMeetingUI;
import eapli.elearning.app.user.console.presentation.meeting.ListMeetingParticipantsUI;
import eapli.elearning.app.user.console.presentation.meeting.ScheduleMeetingUI;
import eapli.elearning.app.user.console.presentation.postit.CreatePostItUI;
import eapli.elearning.app.user.console.presentation.postit.UndoLastChangePostItUI;
import eapli.elearning.app.user.console.presentation.sharedboard.ArchiveBoardUI;
import eapli.elearning.app.user.console.presentation.sharedboard.CreateSharedBoardUI;
import eapli.elearning.app.user.console.presentation.courseenrollment.MakeCourseEnrollmentApplicationUI;
import eapli.elearning.app.user.console.presentation.sharedboard.ShareSharedBoardUI;
import eapli.elearning.app.user.console.presentation.lecture.UpdateLectureUI;
import eapli.elearning.app.user.console.presentation.sharedboard.VisualizeSharedBoardUI;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;


/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends ELearningUserBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int BOOKINGS_OPTION = 2;
    private static final int ACCOUNT_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;

    // BOOKINGS MENU
    private static final int BOOK_A_MEAL_OPTION = 2;
    private static final int LIST_MY_BOOKINGS_OPTION = 3;

    // ACCOUNT MENU
    private static final int LIST_MOVEMENTS_OPTION = 1;

    // SETTINGS
    private static final int SET_USER_ALERT_LIMIT_OPTION = 1;

    //////////////////////////////////////////////////
    private static final int SCHEDULE_MEETING = 2;
    private static final int ANSWER_MEETING_INVITATION = 3;
    private static final int USER_CREATE_SHARED_BOARD = 4;
    private static final int LIST_MEETING_PARTICIPANTS = 5;
    private static final int CANCEL_MEETING = 6;
    private static final int ARCHIVE_BOARD = 7;
    private static final int CREATE_POST_IT = 8;
    private static final int CHANGE_POST_IT = 0;
    private static final int USER_SHARE_BOARD = 9;
    private static final int USER_UNDO_CHANGE = 10;
    private static final int STUDENT_ENROLL_COURSE = 11;
    private static final int STUDENT_LIST_EXAMS = 12;
    private static final int STUDENT_LIST_COURSES_AVAILABLE = 13;
    private static final int STUDENT_TAKE_EXAM = 14;
    private static final int STUDENT_TAKE_FORMATIVE_EXAM = 15;
    private static final int STUDENT_LIST_GRADES = 16;
    private static final int TEACHER_SCHEDULE_CLASS = 11;
    private static final int TEACHER_SCHEDULE_EXTRAORDINARY_CLASS = 12;
    private static final int TEACHER_UPDATE_CLASS = 13;
    private static final int TEACHER_LIST_EXAMS = 14;
    private static final int TEACHER_CREATE_UPDATE_FORMATIVE_AUTOMATIC_EXAM = 15;
    private static final int TEACHER_ADD_QUESTION_TO_REPOSITORY = 16;
    private static final int TEACHER_LIST_COURSES_AVAILABLE = 17;
    private static final int TEACHER_LIST_EXAMS_GRADES = 18;
    private static final int TEACHER_CREATE_EXAM = 19;
    private static final int SHOW_BOARD = 100;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        // Initial form to identify the user role.
        // List<Role> sessionRole = new ArrayList<>(this.authz.session().get().authenticatedUser().roleTypes());
//        var x=this.authz.session().get().authenticatedUser().roleTypes();
//        var y= x.toArray()[1];

        // Verifies if there is any value (other than null) to

        if(this.authz.session().isPresent()) {
            String userRoles = this.authz.session().get().authenticatedUser().roleTypes().toString();
            System.out.println("Hello, " + this.authz.session().get().authenticatedUser().name() + "!\nRoles: "
                    + userRoles.substring(1, userRoles.length()-1).toLowerCase());
        }
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final var renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();

        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        if(authz.hasSession()) {

            mainMenu.addItem(SCHEDULE_MEETING, "Schedule meeting", new ScheduleMeetingUI()::show);
            mainMenu.addItem(ANSWER_MEETING_INVITATION, "Accept/Refuse meeting invitation"
                    , new AnswerMeetingInvitationUI()::show);
            mainMenu.addItem(USER_CREATE_SHARED_BOARD, "Create a Shared Board", new CreateSharedBoardUI()::show);
            mainMenu.addItem(LIST_MEETING_PARTICIPANTS, "List participants in my meetings"
                    , new ListMeetingParticipantsUI()::show);
            mainMenu.addItem(CANCEL_MEETING, "Cancel meeting", new CancelMeetingUI()::show);
            mainMenu.addItem(ARCHIVE_BOARD, "Archive board", new ArchiveBoardUI()::show);
            mainMenu.addItem(CREATE_POST_IT, "Create post-it", new CreatePostItUI()::show);
            mainMenu.addItem(USER_SHARE_BOARD, "Share a board with other users", new ShareSharedBoardUI()::show);
            mainMenu.addItem(USER_UNDO_CHANGE, "Undo the last change", new UndoLastChangePostItUI()::show);
            if (authz.isAuthenticatedUserAuthorizedTo(ElearningRoles.POWER_USER, ElearningRoles.STUDENT)) {
                //mainMenu.addItem(STUDENT_ENROLL_COURSE, "Enroll in course", new MakeCourseEnrollmentApplicationUI()::show);
                mainMenu.addItem(STUDENT_LIST_EXAMS, "List my future exams", new ListUserExamsUI()::show);
                mainMenu.addItem(STUDENT_LIST_COURSES_AVAILABLE, "List courses available", new ListCoursesAvailableUI()::show);
                mainMenu.addItem(STUDENT_TAKE_EXAM, "Take an Exam", new TakeExamUI()::show);
                mainMenu.addItem(STUDENT_TAKE_FORMATIVE_EXAM, "Take a Formative Exam", new TakeFormativeExamUI()::show);
                mainMenu.addItem(STUDENT_LIST_GRADES, "List the grades of the exams of a course", new ListExamGradesStudentUI()::show);
                mainMenu.addItem(SHOW_BOARD, "Visualize shared board", new VisualizeSharedBoardUI()::show);
            }
            if (authz.isAuthenticatedUserAuthorizedTo(ElearningRoles.POWER_USER, ElearningRoles.TEACHER)) {
                mainMenu.addItem(TEACHER_SCHEDULE_CLASS, "Schedule class", new CreateLectureUI()::show);
                mainMenu.addItem(TEACHER_SCHEDULE_EXTRAORDINARY_CLASS, "Schedule extra class"
                        , new CreateExtraordinaryLectureUI()::show);
                mainMenu.addItem(TEACHER_UPDATE_CLASS, "Update class", new UpdateLectureUI()::show);
                mainMenu.addItem(TEACHER_LIST_EXAMS, "List Exams", new ListExamsUI()::show);
                mainMenu.addItem(TEACHER_CREATE_UPDATE_FORMATIVE_AUTOMATIC_EXAM, "Create automatic formative exams"
                        , new CreateUpdateAutomaticFormativeExamUI()::show);
                mainMenu.addItem(TEACHER_ADD_QUESTION_TO_REPOSITORY, "Add question to repository"
                        , new AddUpdadeQuestionUI()::show);
                mainMenu.addItem(TEACHER_LIST_COURSES_AVAILABLE, "List courses available"
                        , new ListCoursesAvailableUI()::show);
                mainMenu.addItem(TEACHER_LIST_EXAMS_GRADES, "List exams grades of a course", new ListCoursesExamsGradesUI()::show);
                mainMenu.addItem(TEACHER_CREATE_EXAM, "Create Exam", new CreateExamUI()::show);
            }

            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }
}
