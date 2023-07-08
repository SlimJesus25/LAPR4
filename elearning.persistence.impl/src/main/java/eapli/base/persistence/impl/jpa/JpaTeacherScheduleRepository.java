package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.teacherschedulemanagement.domain.TeacherSchedule;
import eapli.elearning.teacherschedulemanagement.repositories.TeacherScheduleRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTeacherScheduleRepository extends JpaAutoTxRepository<TeacherSchedule, Integer, Integer> implements TeacherScheduleRepository {
    public JpaTeacherScheduleRepository(final TransactionalContext autoTx) {
        super(autoTx, "meeting_id");
    }

    public JpaTeacherScheduleRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "meeting_id");
    }

}
