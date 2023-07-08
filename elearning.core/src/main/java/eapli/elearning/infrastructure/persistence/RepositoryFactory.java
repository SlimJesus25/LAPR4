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
package eapli.elearning.infrastructure.persistence;

import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.extralectureparticipantmanagement.repositories.ExtraLectureParticipantRepository;
import eapli.elearning.formerexammanagement.persistence.FormerExamRepository;
import eapli.elearning.meetingparticipationmanagement.persistance.MeetingParticipationRepository;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.elearning.elearningusermanagement.repositories.ELearningUserRepository;
import eapli.elearning.elearningusermanagement.repositories.SignupRequestRepository;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.teacherschedulemanagement.repositories.TeacherScheduleRepository;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

public interface RepositoryFactory {

	/**
	 * Factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 * @param autoTx the transactional context to enroll
	 *
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 * @return
	 */

	/**
	 * @param autoTx the transactional context to enroll
	 *
	 * @return
	 */
	ELearningUserRepository eLearningUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ELearningUserRepository eLearningUsers();

	TeacherRepository teachers();

	TeacherRepository teachers(TransactionalContext autoTx);

	SharedBoardRepository sharedBoards();

	SharedBoardRepository sharedBoards(TransactionalContext autoTx);
	TeamElementRepository courseTeams();
	TeamElementRepository courseTeams(TransactionalContext autoTx);

    ExtraLectureParticipantRepository extraLectureParticipants();

	ExtraLectureParticipantRepository extraLectureParticipants(TransactionalContext autoTx);

	CourseRepository courses();

	CourseRepository courses(TransactionalContext autoTx);

	CourseEnrollmentRepository courseEnrollments();
	FormerExamRepository formerExams();
	FormerExamRepository formerExams(TransactionalContext autoTx);

	StudentRepository students();

	StudentRepository students(TransactionalContext autoTx);

	ExamRepository exams();
	ExamRepository exams(TransactionalContext autoTx);

	ExamQuestionRepository examQuestions();
	ExamQuestionRepository examQuestions(TransactionalContext autoTx);

	ExamSectionRepository examSections();
	ExamSectionRepository examSections(TransactionalContext autoTx);

	CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx);

	SystemUserRepository systemUsers();
	SystemUserRepository systemUsers(TransactionalContext autoTx);
	ExtraLectureRepository extraLectures();
	ExtraLectureRepository extraLectures(TransactionalContext autoTx);
	MeetingRepository meetings();
	MeetingRepository meetings(TransactionalContext autoTx);
	LectureRepository lectures();
	LectureRepository lectures(TransactionalContext autoTx);
    TeacherScheduleRepository teacherSchedules();
	TeacherScheduleRepository teacherSchedules(TransactionalContext autoTx);
	SharedBoardParticipationRepository sharedBoardParticipations();
	SharedBoardParticipationRepository sharedBoardParticipations(TransactionalContext autoTx);
	MeetingParticipationRepository meetingParticipations(TransactionalContext autoTx);
	MeetingParticipationRepository meetingParticipations();
//	PostItRepository postIts();
//	PostItRepository postIts(TransactionalContext autoTx);
//	PostItModificationRepository postItModifications();
//	PostItModificationRepository postItModifications(TransactionalContext autoTx);

	/**
	 * @param autoTx the transactional context to enroll
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

	
}
