package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralecturemanagement.repositories.ExtraLectureRepository;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.teachermanagement.domain.TeacherAcronym;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaExtraLectureRepository extends JpaAutoTxRepository<ExtraLecture, Integer, Integer> implements ExtraLectureRepository {
    public JpaExtraLectureRepository(final TransactionalContext autoTx) {
        super(autoTx, "lecture_id");
    }

    public JpaExtraLectureRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "lecture_id");
    }

    public ExtraLecture extraLecture(Integer id) {
        final TypedQuery<ExtraLecture> query = entityManager().createQuery("SELECT a FROM ExtraLecture a WHERE a.ID" +
                " = upper(:id)", ExtraLecture.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public Iterable<ExtraLecture> listAllExtraLecturesOfTeacher(String teacherAcronym) {
        final TypedQuery<ExtraLecture> query = entityManager().createQuery("SELECT a FROM ExtraLecture a" +
                " WHERE upper(a.teacher.id.teacherAcronym) = upper(:code)", ExtraLecture.class);
        query.setParameter("code", teacherAcronym);
        return query.getResultList();
    }

    @Override
    public ExtraLecture findExtraLectureByID(Integer id) {
        final TypedQuery<ExtraLecture> query = entityManager().createQuery("SELECT a FROM ExtraLecture a WHERE a.id" +
                " = :id", ExtraLecture.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
