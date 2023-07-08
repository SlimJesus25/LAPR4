package eapli.base.persistence.impl.jpa;

import eapli.elearning.Application;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;


public class JpaTeamElementRepository extends JpaAutoTxRepository<TeamElement, Integer, Integer> implements TeamElementRepository {

    public JpaTeamElementRepository(final TransactionalContext autoTx) {
        super(autoTx, "teamelement_id");
    }
    public JpaTeamElementRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "teamelement_id");
    }
    @Override
    public Iterable<Course> findCoursesOfTeacher(Teacher teacher){
        TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c.course FROM TeamElement c JOIN c.teacher t WHERE t = :teacher", Course.class);
        query.setParameter("teacher", teacher);
        return query.getResultList();
    }
}
