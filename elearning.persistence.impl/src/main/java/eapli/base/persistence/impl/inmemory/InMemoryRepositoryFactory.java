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
package eapli.base.persistence.impl.inmemory;

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
import eapli.elearning.infrastructure.bootstrapers.ELearningBootstrapper;
import eapli.elearning.infrastructure.persistence.RepositoryFactory;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.meetingmanagement.persistance.MeetingRepository;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.teacherschedulemanagement.repositories.TeacherScheduleRepository;
import eapli.elearning.usermanagement.repository.SystemUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new ELearningBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ELearningUserRepository eLearningUsers(TransactionalContext autoTx) {
        return new InMemoryELearningUserRepository();
    }

    @Override
    public ELearningUserRepository eLearningUsers() {
        return null;
    }

    @Override
    public TeacherRepository teachers() {
        return null;
    }

    @Override
    public TeacherRepository teachers(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SharedBoardRepository sharedBoards() {
        return null;
    }

    @Override
    public SharedBoardRepository sharedBoards(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public TeamElementRepository courseTeams() {
        return null;
    }

    @Override
    public TeamElementRepository courseTeams(TransactionalContext autoTx) {
        return null;
    }
    @Override
    public ExtraLectureParticipantRepository extraLectureParticipants() {
        return null;
    }
    @Override
    public ExtraLectureParticipantRepository extraLectureParticipants(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CourseRepository courses() {
        return null;
    }

    @Override
    public CourseRepository courses(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CourseEnrollmentRepository courseEnrollments() {
        return null;
    }

    @Override
    public FormerExamRepository formerExams() {return null;}

    @Override
    public FormerExamRepository formerExams(TransactionalContext autoTx) {return null;}

    @Override
    public StudentRepository students() {
        return null;
    }

    @Override
    public StudentRepository students(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExamRepository exams() {
        return null;
    }

    @Override
    public ExamRepository exams(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExamQuestionRepository examQuestions() {
        return null;
    }

    @Override
    public ExamQuestionRepository examQuestions(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExamSectionRepository examSections() {
        return null;
    }

    @Override
    public ExamSectionRepository examSections(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SystemUserRepository systemUsers() {
        return null;
    }

    @Override
    public SystemUserRepository systemUsers(TransactionalContext autoTx) {return null;}

    @Override
    public ExtraLectureRepository extraLectures() {return null;}

    @Override
    public ExtraLectureRepository extraLectures(TransactionalContext autoTx) {return null;}

    @Override
    public MeetingRepository meetings() {return null;}
    @Override
    public MeetingRepository meetings(TransactionalContext autoTx) {
        return null;
    }
    @Override
    public LectureRepository lectures() {
        return null;
    }
    @Override
    public LectureRepository lectures(TransactionalContext autoTx) {
        return null;
    }
    @Override
    public TeacherScheduleRepository teacherSchedules(){return null;}
    @Override
    public TeacherScheduleRepository teacherSchedules(TransactionalContext autoTx){return null;}

    @Override
    public SharedBoardParticipationRepository sharedBoardParticipations() {
        return null;
    }

    @Override
    public SharedBoardParticipationRepository sharedBoardParticipations(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public MeetingParticipationRepository meetingParticipations(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public MeetingParticipationRepository meetingParticipations() {
        return null;
    }

//    @Override
//    public PostItRepository postIts() {
//        return null;
//    }
//
//    @Override
//    public PostItRepository postIts(TransactionalContext autoTx) {
//        return null;
//    }

//    @Override
//    public PostItModificationRepository postItModifications() {
//        return null;
//    }
//
//    @Override
//    public PostItModificationRepository postItModifications(TransactionalContext autoTx) {
//        return null;
//    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return null;
        //return new InMemoryELearningUserRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
