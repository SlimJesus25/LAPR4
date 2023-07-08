package eapli.elearning.examquestionmanagement.domain;

import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class ExamQuestion implements DTOable<ExamQuestionDTO>, AggregateRoot<Integer> {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated (EnumType.STRING)
    private ExamQuestionType questionType;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ExamQuestionSolution> solutions = new ArrayList<>();

    @Embedded
    private ExamQuestionValue value;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyEnumerated(EnumType.STRING)
    private Map<ExamQuestionResult, ExamQuestionFeedback> feedbacks = new HashMap<>();

    @Embedded
    private ExamQuestionStatement statement;

    public ExamQuestion(ExamQuestionType questionType, List<String> solutions, Integer value,
                        HashMap<ExamQuestionResult,String> feedbacks, String statement) {
        this.questionType = questionType;
        //this.solutions = new ArrayList<>();
        solutions.forEach(solution -> this.solutions.add(new ExamQuestionSolution(solution)));
        this.value = new ExamQuestionValue(value);
        //this.feedbacks = new HashMap<>();
        feedbacks.forEach((result,feedback) -> this.feedbacks.put(result,new ExamQuestionFeedback(feedback)));
        this.statement = new ExamQuestionStatement(statement);
    }


    public ExamQuestionType questionType() {
        return questionType;
    }

    public List<ExamQuestionSolution> solution() {
        return solutions;
    }

    public ExamQuestionValue value() {
        return value;
    }

    public Map<ExamQuestionResult,ExamQuestionFeedback> feedback() {
        return feedbacks;
    }

    public ExamQuestionStatement statement() {
        return statement;
    }

    protected ExamQuestion() {
    }

    @Override
    public ExamQuestionDTO toDTO() {
        ArrayList<String> solutions = new ArrayList<>();
        this.solutions.forEach(solution -> solutions.add(solution.solution()));
        HashMap<ExamQuestionResult,String> feedbacks = new HashMap<>();
        this.feedbacks.forEach((result,feedback)-> feedbacks.put(result,feedback.questionFeedback()));
        return new ExamQuestionDTO(questionType, solutions, value.value(),
                feedbacks, statement.statement());
    }

    @Override
    public boolean sameAs(Object other) {
        return this.equals(other);
    }

    @Override
    public Integer identity() {
        return this.id;
    }
}
