package eapli.elearning.exammanagement.domain;


import eapli.framework.domain.model.DomainFactory;

public class ExamBuilder implements DomainFactory<Exam> {
    private Exam theExam;
    private ExamTitle examTitle;
    private ExamHeader examHeader;

    public ExamBuilder withExamTitle(ExamTitle examTitle) {
        this.examTitle = examTitle;
        return this;
    }
    public ExamBuilder withExamHeader(ExamHeader examHeader) {
        this.examHeader = examHeader;
        return this;
    }

    @Override
    public Exam build() {
        final Exam exam = buildOrThrow();
        theExam = null;
        return exam;
    }
    private Exam buildOrThrow(){
        if (theExam != null)
            return theExam;
        else if (examTitle != null && examHeader != null){
            //theExam = new Exam(examTitle,examHeader,examHeaderDescription);
            return theExam;
        } else throw new IllegalStateException();
    }
}
