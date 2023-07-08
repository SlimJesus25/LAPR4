package eapli.elearning.extralectureparticipantmanagement.repositories;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExtraLectureParticipantRepository  extends DomainRepository<Integer, ExtraLectureParticipant> {
    public Iterable<Student> findExtraLectureParticipantsByExtraLecture(ExtraLecture extraLecture);
}
