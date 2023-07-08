package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.extralectureparticipantmanagement.repositories.ExtraLectureParticipantRepository;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaExtraLectureParticipantRepository extends JpaAutoTxRepository<ExtraLectureParticipant, Integer, Integer> implements ExtraLectureParticipantRepository {
    public JpaExtraLectureParticipantRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExtraLectureParticipantRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Student> findExtraLectureParticipantsByExtraLecture(ExtraLecture extraLecture) {
        return null;
    }
}
