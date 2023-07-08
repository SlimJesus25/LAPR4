package eapli.elearning.formerexammanagement.domain;

import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.domain.model.DomainFactory;

public class FormerExamBuilder implements DomainFactory<FormerExam> {
    private FormerExam theFormerExam;
    private Integer formerExamGrade;
    private Student formerExamStudent;
    private Exam formerExamExam;

    public FormerExamBuilder withFormerExamGrade(Integer formerExamGrade) {
        this.formerExamGrade = formerExamGrade;
        return this;
    }
    public FormerExamBuilder withFormerExamStudent(Student formerExamStudent) {
        this.formerExamStudent = formerExamStudent;
        return this;
    }
    public FormerExamBuilder withFormerExamExam(Exam formerExamExam) {
        this.formerExamExam = formerExamExam;
        return this;
    }

    @Override
    public FormerExam build() {
        final FormerExam formerExam = buildOrThrow();
        theFormerExam = null;
        return formerExam;
    }
    private FormerExam buildOrThrow(){
        if (theFormerExam != null)
            return theFormerExam;
        else if (formerExamGrade != null && formerExamStudent != null && formerExamExam != null) {
            theFormerExam = new FormerExam(formerExamStudent,formerExamExam,formerExamGrade);
            return theFormerExam;
        } else throw new IllegalStateException();
    }
}
