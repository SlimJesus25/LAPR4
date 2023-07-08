package eapli.elearning.exammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Exam implements AggregateRoot<Integer>, DTOable<ExamDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examID;
    @Embedded
    @Column(unique = true)
    private ExamTitle examTitle;
    @Embedded
    private ExamHeader examHeader;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ExamSection> examSection = new HashSet<>();
    // Aqui acima usa-se este tipo de fetch para que o objeto fique imediatamente disponível.

    @Embedded
    private ExamInitalDateTime initalDateTime;

    @Embedded
    private ExamFinalDateTime finalDateTime;
    @Enumerated(EnumType.STRING)
    private ExamType examType;
    @ManyToOne
    private Course course;

    public Exam(String examTitle, String examHeader, Set<ExamSection> examSection, Course course, ExamType examType
            , LocalDateTime initalDateTime, LocalDateTime finalDateTime) {
        this.examTitle = new ExamTitle(examTitle);
        this.examHeader = new ExamHeader(examHeader);
        this.examSection = examSection;
        this.course = course;
        this.examType = examType;
        this.initalDateTime = new ExamInitalDateTime(initalDateTime);
        this.finalDateTime = new ExamFinalDateTime(finalDateTime);
    }

    public Exam(String examTitle, String examHeader, Set<ExamSection> examSection, Course course) {
        this.examTitle = new ExamTitle(examTitle);
        this.examHeader = new ExamHeader(examHeader);
        this.examSection = examSection;
        this.course = course;
        this.examType = ExamType.FORMATIVE;
        this.initalDateTime = new ExamInitalDateTime(LocalDateTime.now().plusSeconds(10));
        this.finalDateTime = new ExamFinalDateTime(LocalDateTime.now().plusYears(100));
    }

    protected Exam(){}
    @Override
   public ExamDTO toDTO() {
        Set<ExamSectionDTO> sections = new HashSet<>();
        examSection.forEach(e -> sections.add(e.toDTO()));
        return new ExamDTO(identity(), examTitle.title(), examHeader.header(), sections, course.toDTO()
                , initalDateTime.dateTime(), finalDateTime.dateTime());
   }

    public Course course() {
        return course;
    }

    public void addSection(ExamSection examSection) {
        this.examSection.add(examSection);
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Exam that = (Exam) other;
        return Objects.equals(examID, that.examID);
    }
    @Override
    public Integer identity() {
        return examID;
    }


}
