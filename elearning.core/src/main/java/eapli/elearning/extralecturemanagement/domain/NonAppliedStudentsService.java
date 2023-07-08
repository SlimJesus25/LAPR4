package eapli.elearning.extralecturemanagement.domain;

import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.services.DomainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@DomainService
public class NonAppliedStudentsService {
    public List<Student> nonAppliedStudents(Iterable<Student> studentsIterator, Set<Student> studentsApplied) {
        List<Student> students= new ArrayList<>();
        for(Student student: studentsIterator){
            if(studentsApplied==null)
                students.add(student);
            else if(!studentsAppliedContains(studentsApplied,student))
                students.add(student);
        }
        return students;
    }
    public boolean newStudentsHasStudentNumber(Set<Student> newStudents, String studentNumber) {
        for(Student student: newStudents){
            if(student.identity().studentMechanograpicalNumber().equalsIgnoreCase(studentNumber))
                return true;
        }
        return false;
    }
    private boolean studentsAppliedContains(Set<Student> studentsApplied, Student student) {
        for(Student student1: studentsApplied){
            if(student1.identity().studentMechanograpicalNumber().equalsIgnoreCase(student.identity().studentMechanograpicalNumber()))
                return true;
        }
        return false;
    }
}
