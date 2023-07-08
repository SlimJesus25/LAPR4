package eapli.elearning.extralecturemanagement.repositories;

import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.lecturemanagement.domain.Lecture;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExtraLectureRepository extends DomainRepository<Integer, ExtraLecture> {
    Iterable<ExtraLecture> listAllExtraLecturesOfTeacher(String teacherAcronym);

    ExtraLecture findExtraLectureByID(Integer id);
}
