package eapli.elearning.examsectionmanagement.domain;

import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ExamSection implements DTOable<ExamSectionDTO>, AggregateRoot<Integer> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private ExamSectionTextualDescription sectionDescription;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ExamQuestion> questions = new HashSet<>();
    // Aqui acima usa-se este tipo de fetch para que o objeto fique imediatamente disponível.

    public Integer identity() {
        return id;
    }

    public ExamSection(String description, Set<ExamQuestion> questions) {
        this.sectionDescription = new ExamSectionTextualDescription(description);
        this.questions = questions;
    }

    protected ExamSection() {
    }

    public Set<ExamQuestion> questions() {
        return questions;
    }

    @Override
    public ExamSectionDTO toDTO() {
        Set<ExamQuestionDTO> questions = new HashSet<>();
        this.questions.forEach(e -> questions.add(e.toDTO()));
        return new ExamSectionDTO(sectionDescription.description(), questions);
    }

    @Override
    public boolean sameAs(Object other) {
        return this.equals(other);
    }
}
