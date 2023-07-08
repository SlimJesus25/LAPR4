package eapli.elearning.exammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.examsectionmanagement.domain.ExamSection;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ExamFactory {
    public static Exam createExam(String examTitle, String examHeader, Set<ExamSection> examSection, Course course
            , ExamType type, LocalDateTime initalDateTime, LocalDateTime finalDateTime){
        return new Exam(examTitle, examHeader, examSection, course, type, initalDateTime, finalDateTime);
    }

    public static Exam createFormativeExam(String examTitle, String examHeader, Set<ExamSection> examSection
            , Course course){
        return new Exam(examTitle, examHeader, examSection, course);
    }
}
