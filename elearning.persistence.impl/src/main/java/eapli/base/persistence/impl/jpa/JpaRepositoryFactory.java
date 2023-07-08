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

import eapli.elearning.Application;
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
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }
    @Override
    public UserRepository users() {return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(), Application.settings().getExtendedPersistenceProperties());}
    @Override
    public ELearningUserRepository eLearningUsers(TransactionalContext autoTx) {return new JpaClientUserRepository(autoTx);}
    @Override
    public ELearningUserRepository eLearningUsers() {return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public TeacherRepository teachers() {return new JpaTeacherRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public TeacherRepository teachers(TransactionalContext autoTx) {
        return new JpaTeacherRepository(autoTx);
    }
    @Override
    public SharedBoardRepository sharedBoards() {return new JpaSharedBoardRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public SharedBoardRepository sharedBoards(TransactionalContext autoTx) {return new JpaSharedBoardRepository(autoTx);}
    @Override
    public TeamElementRepository courseTeams() {return new JpaTeamElementRepository(Application.settings().getPersistenceUnitName()) ;}
    @Override
    public TeamElementRepository courseTeams(TransactionalContext autoTx) {return new JpaTeamElementRepository(autoTx);}
    @Override
    public ExtraLectureParticipantRepository extraLectureParticipants() {return new JpaExtraLectureParticipantRepository(Application.settings().getPersistenceUnitName()) ;}
    @Override
    public ExtraLectureParticipantRepository extraLectureParticipants(TransactionalContext autoTx) {return new JpaExtraLectureParticipantRepository(autoTx);}
    @Override
    public CourseRepository courses() {return new JpaCourseRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public CourseRepository courses(TransactionalContext autoTx) {return new JpaCourseRepository(autoTx);}
    @Override
    public FormerExamRepository formerExams() {return new JpaFormerExamRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public FormerExamRepository formerExams(TransactionalContext autoTx) {return new JpaFormerExamRepository(autoTx);}
    @Override
    public CourseEnrollmentRepository courseEnrollments() {return new JpaCourseEnrollmentsRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public StudentRepository students() {return new JpaStudentRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public StudentRepository students(TransactionalContext autoTx) {
        return new JpaStudentRepository(autoTx);
    }
    @Override
    public ExamRepository exams() {
        return new JpaExamRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public ExamRepository exams(TransactionalContext autoTx) {
        return new JpaExamRepository(autoTx);
    }

    @Override
    public ExamQuestionRepository examQuestions() {
        return new JpaExamQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamQuestionRepository examQuestions(TransactionalContext autoTx) {
        return new JpaExamQuestionRepository(autoTx);
    }

    @Override
    public ExamSectionRepository examSections() {
        return new JpaExamSectionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamSectionRepository examSections(TransactionalContext autoTx) {
        return new JpaExamSectionRepository(autoTx);
    }

    @Override
    public CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx) {return new JpaCourseEnrollmentsRepository(autoTx);}
    @Override
    public SystemUserRepository systemUsers() {return new JpaSystemUserRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public SystemUserRepository systemUsers(TransactionalContext autoTx) {
        return new JpaSystemUserRepository(autoTx);
    }
    @Override
    public ExtraLectureRepository extraLectures() {return new JpaExtraLectureRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public ExtraLectureRepository extraLectures(TransactionalContext autoTx) {return new JpaExtraLectureRepository(autoTx);}
    @Override
    public MeetingRepository meetings() {return new JpaMeetingRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public MeetingRepository meetings(TransactionalContext autoTx) {return new JpaMeetingRepository(autoTx);}
    @Override
    public LectureRepository lectures() {return new JpaLectureRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public LectureRepository lectures(TransactionalContext autoTx) {return new JpaLectureRepository(autoTx);}
    @Override
    public TeacherScheduleRepository teacherSchedules() {return new JpaTeacherScheduleRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public TeacherScheduleRepository teacherSchedules(TransactionalContext autoTx) {return new JpaTeacherScheduleRepository(autoTx);}
    @Override
    public SharedBoardParticipationRepository sharedBoardParticipations() {
        return new JpaSharedBoardParticipantRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public SharedBoardParticipationRepository sharedBoardParticipations(TransactionalContext autoTx) {
        return new JpaSharedBoardParticipantRepository(autoTx);
    }

    @Override
    public MeetingParticipationRepository meetingParticipations(TransactionalContext autoTx) {
        return new JpaMeetingParticipationRepository(autoTx);
    }

    @Override
    public MeetingParticipationRepository meetingParticipations() {
        return new JpaMeetingParticipationRepository(Application.settings().getPersistenceUnitName());
    }

//    @Override
//    public PostItRepository postIts() {
//        return new JpaPostItRepository(Application.settings().getPersistenceUnitName());
//    }
//
//    @Override
//    public PostItRepository postIts(TransactionalContext autoTx) {
//        return new JpaPostItRepository(autoTx);
//    }

//    @Override
//    public PostItModificationRepository postItModifications() {
//        return new JpaPostItModificationRepository(Application.settings().getPersistenceUnitName());
//    }
//
//    @Override
//    public PostItModificationRepository postItModifications(TransactionalContext autoTx) {
//        return new JpaPostItModificationRepository(autoTx);
//    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {return new JpaSignupRequestRepository(autoTx);}
    @Override
    public SignupRequestRepository signupRequests() {return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());}
    @Override
    public TransactionalContext newTransactionalContext() {return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(), Application.settings().getExtendedPersistenceProperties());}

}
