package eapli.elearning.exammanagement.repository;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionStatement;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Set;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public interface ExamQuestionRepository extends DomainRepository<Integer, ExamQuestion> {
    List<ExamQuestion> listQuestionsByTypeAndCourse(Course course, Set<ExamQuestionType> questionTypes);
    Iterable<ExamQuestion> findQuestionByStatement(ExamQuestionStatement statement);

    Iterable<ExamQuestion> listQuestions();
}
