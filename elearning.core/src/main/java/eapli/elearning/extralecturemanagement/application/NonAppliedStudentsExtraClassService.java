package eapli.elearning.extralecturemanagement.application;

import eapli.elearning.extralecturemanagement.domain.NonAppliedStudentsService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.application.ApplicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApplicationService
public class NonAppliedStudentsExtraClassService {
    NonAppliedStudentsService nonAppliedStudentsService = new NonAppliedStudentsService();
    public List<Student> nonAppliedStudents(Iterable<Student> studentsIterator, Set<Student> studentsApplied) {
        return nonAppliedStudentsService.nonAppliedStudents(studentsIterator, studentsApplied);
    }
    public boolean newStudentsHasStudentNumber(Set<Student> newStudents, String studentNumber) {
        return nonAppliedStudentsService.newStudentsHasStudentNumber(newStudents, studentNumber);
    }
}
