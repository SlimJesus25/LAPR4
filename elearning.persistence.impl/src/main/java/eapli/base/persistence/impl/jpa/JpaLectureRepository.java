package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.lecturemanagement.domain.*;
import eapli.elearning.lecturemanagement.persistance.LectureRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class JpaLectureRepository extends JpaAutoTxRepository<Lecture, Integer, Integer> implements LectureRepository {
    public JpaLectureRepository(final TransactionalContext autoTx) {
        super(autoTx, "lecture_id");
    }

    public JpaLectureRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "lecture_id");
    }

    @Override
    public Iterable<Lecture> listLecturesByCourse(String courseCode) {
        final TypedQuery<Lecture> query = entityManager().createQuery("SELECT a FROM Lecture a" +
                " WHERE upper(a.course.id.courseCode) = upper(:code)", Lecture.class);
        query.setParameter("code", courseCode);
        return query.getResultList();
    }

    @Override
    public Iterable<Lecture> listLecturesByTeacher(String teacherAcronym) {
        final TypedQuery<Lecture> query = entityManager().createQuery("SELECT a FROM Lecture a" +
                " WHERE upper(a.teacher.id.teacherAcronym) = upper(:code)", Lecture.class);
        query.setParameter("code", teacherAcronym);
        return query.getResultList();
    }

    @Override
    public Lecture updateLecture(Lecture lecture, LectureInitialDate updatedInitialDate, LectureFinalDate updatedFinalDate, LectureWeekDay updatedWeekDay, LectureInitialTime updatedInitialTime, LectureFinalTime updatedFinalTime, LectureType updatedLectureType, Teacher teacher, Course course) {
        lecture.updateLecture(updatedInitialDate, updatedFinalDate, updatedWeekDay, updatedInitialTime, updatedFinalTime, updatedLectureType, teacher, course);
        this.save(lecture);
        return lecture;
    }

    @Override
    public Lecture findLectureByID(int id) {
        final TypedQuery<Lecture> query = entityManager().createQuery("SELECT a FROM Lecture a WHERE a.lectureID" +
                " = :id", Lecture.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Iterable<Lecture> getLecturesOfCourse(Course course) {
        TypedQuery<Lecture> query = entityManager().createQuery(
                "SELECT l FROM Lecture l WHERE l.course = :course", Lecture.class);
        query.setParameter("course", course);
        return query.getResultList();
    }

}
